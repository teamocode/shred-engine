package com.teamo.shredengine.render;

import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class VertexArrayObject {

    private int id;

    public VertexArrayObject() {
        id = glGenVertexArrays();
    }

    public void setVbo(VertexBufferObject vbo) {
        glBindVertexArray(id);
        glBindBuffer(GL_ARRAY_BUFFER, vbo.getId());

        glBufferData(GL_ARRAY_BUFFER, vbo.getVerticesBuffer(), GL_STATIC_DRAW);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);
    }

    public int getId() {
        return id;
    }

}
