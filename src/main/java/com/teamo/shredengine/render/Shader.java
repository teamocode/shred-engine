package com.teamo.shredengine.render;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

    private int id;

    private int vertexShaderId;
    private int fragmentShaderId;

    public Shader() {
        id = glCreateProgram();
    }

    public void create(String vertexShaderCode, String fragmentShaderCode) throws Exception {
        vertexShaderId = createShader(vertexShaderCode, GL_VERTEX_SHADER);
        fragmentShaderId = createShader(fragmentShaderCode, GL_FRAGMENT_SHADER);
        link();
    }

    private int createShader(String shaderCode, int shaderType) throws Exception {
        int shaderId = glCreateShader(shaderType);
        if (shaderId == 0) {
            throw new Exception("Error creating shader. Type: " + shaderType);
        }

        glShaderSource(shaderId, shaderCode);
        glCompileShader(shaderId);

        if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0) {
            throw new Exception("Error compiling Shader code: " + glGetShaderInfoLog(shaderId, 1024));
        }

        glAttachShader(id, shaderId);

        return shaderId;
    }

    private void link() throws Exception {
        glLinkProgram(id);
        if (glGetProgrami(id, GL_LINK_STATUS) == 0) {
            throw new Exception("Error linking Shader code: " + glGetProgramInfoLog(id, 1024));
        }

        if (vertexShaderId != 0) {
            glDetachShader(id, vertexShaderId);
        }
        if (fragmentShaderId != 0) {
            glDetachShader(id, fragmentShaderId);
        }

    }

    public int getId() {
        return id;
    }

}
