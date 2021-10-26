package com.teamo.shredengine.engine.shader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.*;

public class Shader implements ShaderType {

    private int programId;
    private Map<String, String> sources;

    public Shader() {
        this.sources = new HashMap<>();
    }

    private String load(String filePath, boolean useCache) {
        if (useCache && sources.containsKey(filePath)) {
            return sources.get(filePath);
        }

        try {
            Path path = Paths.get(filePath);
            byte[] bytes = Files.readAllBytes(path);
            String source = new String(bytes);
            if (useCache) {
                sources.put(filePath, source);
            }
            return source;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load shader");
        }
    }

    private List<String> load(List<String> filePaths, boolean useCache) {
        List<String> sources = new ArrayList<>();
        for (String filePath : filePaths) {
            String source = load(filePath, useCache);
            sources.add(source);
        }
        return sources;
    }

    public void init(List<String> filePaths) {
        List<String> sources = load(filePaths, true);
        List<Integer> sourceIds = compile(sources);
        programId = link(sourceIds);
    }

    private List<Integer> compile(List<String> sources) {
        List<Integer> sourceIds = new ArrayList<>();
        for (String source : sources) {
            Integer sourceId = compile(source);
            sourceIds.add(sourceId);
        }
        return sourceIds;
    }

    private int compile(String source) {
        // Compile the shader
        int id = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(id, source);
        glCompileShader(id);

        // Check compilation status
        int compileStatus = glGetShaderi(id, GL_COMPILE_STATUS);
        if (compileStatus == GL_FALSE) {
            int logLength = glGetShaderi(id, GL_INFO_LOG_LENGTH);
            String error = glGetShaderInfoLog(id, logLength);
            System.out.println(error);
            throw new RuntimeException("Failed to compile shader");
        } else {
            return id;
        }
    }

    private int link(List<Integer> ids) {
        // Link the shaders
        int programId = glCreateProgram();
        for (int id : ids) {
            glAttachShader(programId, id);
        }
        glLinkProgram(programId);

        // Check linking status
        int linkStatus = glGetProgrami(programId, GL_LINK_STATUS);
        if (linkStatus == GL_FALSE) {
            int logLength = glGetProgrami(programId, GL_INFO_LOG_LENGTH);
            String error = glGetProgramInfoLog(programId, logLength);
            System.out.println(error);
            throw new RuntimeException("Failed to compile shader");
        } else {
            return programId;
        }
    }
}
