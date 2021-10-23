package com.teamo.shredengine.render;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class OpenGlRenderer  {

    public void renderVao(VertexArrayObject vao) {
        bindVao(vao);
        drawVao(vao);
        unbindVao();
    }

    public void clearScreen() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void bindShader(Shader shader) {
        glUseProgram(shader.getId());
    }

    public void unbindShader() {
        glUseProgram(0);
    }

    private void bindVao(VertexArrayObject vao) {
        glBindVertexArray(vao.getId());
    }

    private void unbindVao() {
        glBindVertexArray(0);
    }

    private void drawVao(VertexArrayObject vao) {
        glDrawArrays(GL_TRIANGLES, 0, 3);
    }

}
