package com.teamo.shredengine.engine.scene;

import com.teamo.shredengine.engine.input.keyboard.KeyboardType;
import com.teamo.shredengine.engine.input.mouse.MouseType;

public abstract class Scene implements SceneType {

    private final KeyboardType keyboard;
    private final MouseType mouse;

    public Scene(KeyboardType keyboard, MouseType mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
