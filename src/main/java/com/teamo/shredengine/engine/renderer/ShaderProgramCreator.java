package com.teamo.shredengine.engine.renderer;

import static org.lwjgl.opengl.GL20.*;

public class ShaderProgramCreator {
    public static ShaderProgram create(String vertShaderCode,
                                       String fragShaderCode) {
        int programId = glCreateProgram();
        compileShader(GL_VERTEX_SHADER, vertShaderCode, programId);
        compileShader(GL_FRAGMENT_SHADER, fragShaderCode, programId);
        glLinkProgram(programId);

        return new ShaderProgram(programId);
    }

    private static void compileShader(int shaderType,
                                      String shaderCode,
                                      int programId) {
        int shaderId = glCreateShader(shaderType);
        glShaderSource(shaderId, shaderCode);
        glCompileShader(shaderId);
        glAttachShader(programId, shaderId);
    }
}
