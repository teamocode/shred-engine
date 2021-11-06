package com.teamo.shredengine.engine.renderer;

import com.teamo.shredengine.model.Mesh;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class Renderer implements RendererType {

    @Override
    public void render(Renderable renderable) {
        renderMeshes(renderable.getMeshes(), renderable.getShaderProgram());
    }

    private void renderMeshes(Mesh[] meshes, ShaderProgram shaderProgram) {
        glUseProgram(shaderProgram.getId());

        for(Mesh mesh : meshes) {
            glBindVertexArray(mesh.getVaoId());
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, mesh.getIboId());
            glEnableVertexAttribArray(0);

            glDrawElements(GL_TRIANGLES, mesh.getIndexCount(), GL_UNSIGNED_INT, 0);

            glDisableVertexAttribArray(0);
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
            glBindVertexArray(0);
        }

        glUseProgram(0);
    }
}
