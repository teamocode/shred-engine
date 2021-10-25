package com.teamo.shredengine.model;

public class Vertex {

    public float x;
    public float y;

    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vertex(double x, double y) {
        this.x = (float) x;
        this.y = (float) y;
    }
}
