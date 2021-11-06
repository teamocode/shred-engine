package com.teamo.shredengine.engine.renderer;

import com.teamo.shredengine.model.Mesh;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class MeshCreator {

    public static Mesh create() {
        int vaoId = glGenVertexArrays();
        glBindVertexArray(vaoId);
        int vboId = createVbo();
        int iboId = createIbo();
        glBindVertexArray(0);

        return new Mesh(vaoId, iboId, 6);
    }

    private static int createVbo() {
        int vboId = glGenBuffers();

        float[] vertices = {
                -0.25f, -0.25f,
                0.25f, -0.25f,
                0.25f, 0.25f,
                -0.25f, 0.25f
        };

        FloatBuffer vertexBuffer = MemoryUtil.memAllocFloat(vertices.length);
        vertexBuffer.put(vertices).flip();

        glBindBuffer(GL_ARRAY_BUFFER, vboId);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
        glDisableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);

        return vboId;
    }

    private static int createIbo() {
        int iboId = glGenBuffers();

        int[] indices = {
                0, 1, 2,
                2, 0, 3,
        };

        IntBuffer indexBuffer = MemoryUtil.memAllocInt(indices.length);
        indexBuffer.put(indices).flip();

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, iboId);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL_STATIC_DRAW);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

        return iboId;
    }

}
