package com.teamo.shredengine.engine.renderer;

import com.teamo.shredengine.model.Mesh;

public interface Renderable {

    /*
    Renderable will have getters for:
    -an array of meshes (geometric objects)
    -a shader (group of programs** run on the gpu)
    */

    Mesh[] getMeshes();
    ShaderProgram getShaderProgram();
}
