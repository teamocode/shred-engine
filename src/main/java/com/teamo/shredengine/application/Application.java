package com.teamo.shredengine.application;

import com.teamo.shredengine.engine.input.keyboard.Keyboard;
import com.teamo.shredengine.engine.input.mouse.Mouse;
import com.teamo.shredengine.engine.window.WindowType;
import com.teamo.shredengine.game.GameScene;

public class Application implements ApplicationType {

    private final WindowType window;

    public Application(WindowType window) {
        this.window = window;
    }

    @Override
    public void run() {
        Mouse mouse = new Mouse(window.getId());
        Keyboard keyboard = new Keyboard(window.getId());
        GameScene scene = new GameScene(keyboard, mouse);
        window.setScene(scene);
        window.launch(500, 500, "Java Game");
    }
}
