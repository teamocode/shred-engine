package com.teamo.shredengine.engine.renderer;

import com.teamo.shredengine.model.Mesh;
import com.teamo.shredengine.render.Shader;

public interface Renderable {

    /*
    Renderable will have getters for:
    -an array of meshes (geometric objects)
    -a shader (group of programs** run on the gpu)
    */

    Mesh[] getMeshes();
    Shader getShader();
}
