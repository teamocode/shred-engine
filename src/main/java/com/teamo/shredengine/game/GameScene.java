package com.teamo.shredengine.game;

import com.teamo.shredengine.engine.input.keyboard.KeyboardType;
import com.teamo.shredengine.engine.input.mouse.MouseType;
import com.teamo.shredengine.engine.renderer.Renderable;
import com.teamo.shredengine.engine.scene.Scene;

public class GameScene extends Scene {

    public GameScene(KeyboardType keyboard, MouseType mouse) {
        super(keyboard, mouse);
    }

    @Override
    public Renderable update(float deltaTime) {
        return null;
    }
}
