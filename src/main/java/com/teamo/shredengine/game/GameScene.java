package com.teamo.shredengine.game;

import com.teamo.shredengine.engine.input.keyboard.KeyboardType;
import com.teamo.shredengine.engine.input.mouse.MouseType;
import com.teamo.shredengine.engine.renderer.Renderable;
import com.teamo.shredengine.engine.scene.Scene;
import com.teamo.shredengine.model.GameObject;

public class GameScene extends Scene {

    public GameScene(KeyboardType keyboard, MouseType mouse) {
        super(keyboard, mouse);
    }

    @Override
    public Renderable update(float deltaTime) {
        Renderable renderable = new GameObject();
        return renderable;
    }
}
