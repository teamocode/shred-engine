package com.teamo.shredengine.model;

import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Mesh {

    /*
    In this case, a Mesh is a geometric object.

    Every Mesh has a Vertex Array Object.

    A mesh can be instantiated with either an indexed or
    non-indexed Vertex Buffer Object.

    Note: There examples of both instantiations in the Renderable class.
    Note: Indexed VBO's are more efficient for polygons with multiple triangles!

    --
    P.S.
    Putting OpenGL code in the constructor seems weird.
    */

    private int vaoId = 0;
    private int vboId = 0;
    private int iboId = 0;
    private int indexCount = 0;

    public Mesh(float[] vertices) {
        vaoId = glGenVertexArrays();
        vboId = glGenBuffers();
        indexCount = vertices.length / 3;

        FloatBuffer vertexBuffer = MemoryUtil.memAllocFloat(vertices.length);
        vertexBuffer.put(vertices).flip();

        glBindVertexArray(vaoId);
        initVbo(vertexBuffer);
        glBindVertexArray(0);
    }

    public Mesh(float[] vertices, int[] indices) {
        vaoId = glGenVertexArrays();
        vboId = glGenBuffers();
        iboId = glGenBuffers();
        indexCount = indices.length;

        FloatBuffer vertexBuffer = MemoryUtil.memAllocFloat(vertices.length);
        vertexBuffer.put(vertices).flip();

        IntBuffer indexBuffer = MemoryUtil.memAllocInt(indices.length);
        indexBuffer.put(indices).flip();

        glBindVertexArray(vaoId);
        initVbo(vertexBuffer);
        initIbo(indexBuffer);
        glBindVertexArray(0);
    }

    private void initVbo(FloatBuffer vertexBuffer) {
        glBindBuffer(GL_ARRAY_BUFFER, vboId);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        glDisableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }

    private void initIbo(IntBuffer indexBuffer) {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, iboId);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL_STATIC_DRAW);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    public void destroy() {
        glBindVertexArray(vaoId);
        glDeleteBuffers(vboId);

        if(iboId > 0) {
            glDeleteBuffers(iboId);
        }

        glBindVertexArray(0);
        glDeleteVertexArrays(vaoId);
    }

    public int getVaoId() {
        return vaoId;
    }

    public int getIboId() {
        return iboId;
    }

    public int getIndexCount() {
        return indexCount;
    }

}
