package com.teamo.shredengine.engine.renderer;

import com.teamo.shredengine.model.Color;
import com.teamo.shredengine.model.Vertex;

import java.util.List;

public interface Renderable {
    List<Vertex> getVertices();
    Color getColor();
}
