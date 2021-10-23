package com.teamo.shredengine.render;

import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL15.glGenBuffers;

public class VertexBufferObject {

    private int id;

    private FloatBuffer verticesBuffer;

    public VertexBufferObject(float[] vertices) {
        id = glGenBuffers();

        verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
        verticesBuffer.put(vertices).flip();
    }

    public int getId() {
        return id;
    }

    public FloatBuffer getVerticesBuffer() {
        return verticesBuffer;
    }

}
