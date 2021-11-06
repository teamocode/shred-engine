package com.teamo.shredengine.model;

import com.teamo.shredengine.engine.renderer.Renderable;

import java.util.Vector;

public class Entity {

    private final int id;

    private final Vector<Float> position;
    private final Vector<Float> size;
    private final Vector<Float> rotation;
    private final Vector<Float> colour;

    public Entity(int id) {
        this.id = id;

        position = new Vector<>(2);
        size = new Vector<>(2);
        rotation = new Vector<>(1);
        colour = new Vector<>(3);
    }

    public int getId() {
        return id;
    }

    public Vector<Float> getPosition() {
        return position;
    }

    public Vector<Float> getSize() {
        return size;
    }

    public Vector<Float> getRotation() {
        return rotation;
    }

    public Vector<Float> getColour() {
        return colour;
    }
}
