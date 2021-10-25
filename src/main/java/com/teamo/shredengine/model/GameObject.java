package com.teamo.shredengine.model;

import com.teamo.shredengine.engine.contact.Contactable;
import com.teamo.shredengine.engine.renderer.Renderable;

import java.util.ArrayList;
import java.util.List;

public class GameObject implements Contactable, Renderable {

    @Override
    public Vertex getPosition() {
        return new Vertex(0f, 0f);
    }

    @Override
    public float getRadius() {
        return 0.5f;
    }

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> vertices = new ArrayList<Vertex>();
        vertices.add(new Vertex(0, 0));
        vertices.add(new Vertex(0.5f, 0f));
        vertices.add(new Vertex(0.5f, 0.5f));
        vertices.add(new Vertex(0f, 0.8f));
        vertices.add(new Vertex(-0.5f, 0.5f));
        vertices.add(new Vertex(-0.5f, -0.5f));
        return vertices;
    }

    @Override
    public Color getColor() {
        return new Color(0.5f, 0.5f, 0.5f);
    }
}
