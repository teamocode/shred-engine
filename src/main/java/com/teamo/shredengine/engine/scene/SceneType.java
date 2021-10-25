package com.teamo.shredengine.engine.scene;

import com.teamo.shredengine.engine.renderer.Renderable;

public interface SceneType {
    Renderable update(float deltaTime);
}
