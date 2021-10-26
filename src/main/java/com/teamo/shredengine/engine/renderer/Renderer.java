package com.teamo.shredengine.engine.renderer;

import com.teamo.shredengine.model.Mesh;
import com.teamo.shredengine.render.Shader;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class Renderer implements RendererType {

    /*
    Rendering a mesh:
    1: apply a shader
    2: bind VAO
    3: bind necessary VAO attributes
    4: draw the VBO (either non-indexed, or indexed)
     */

    @Override
    public void render(Renderable renderable) {
        renderMeshes(renderable.getMeshes(), renderable.getShader());
    }

    /*
    RenderMeshes binds the shader and VAO, then determines how the VBO should be drawn
     */
    private void renderMeshes(Mesh[] meshes, Shader shader) {
        glUseProgram(shader.getId());

        for(Mesh mesh : meshes) {
            glBindVertexArray(mesh.getVaoId());

            if(mesh.getIboId() > 0) {
                drawIndexedVbo(mesh.getIboId(), mesh.getIndexCount());
            } else {
                drawVbo(mesh.getIndexCount());
            }

            glBindVertexArray(0);
        }

        glUseProgram(0);
    }

    private void drawVbo(int indexCount) {
        glEnableVertexAttribArray(0);
        glDrawArrays(GL_TRIANGLES, 0, indexCount);
        glDisableVertexAttribArray(0);
    }

    private void drawIndexedVbo(int iboId, int indexCount) {
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, iboId);
        glDrawElements(GL_TRIANGLES, indexCount, GL_UNSIGNED_INT, 0);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        glDisableVertexAttribArray(0);
    }
}
