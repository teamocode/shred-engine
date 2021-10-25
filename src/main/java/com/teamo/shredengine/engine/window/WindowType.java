package com.teamo.shredengine.engine.window;

import com.teamo.shredengine.engine.scene.SceneType;

public interface WindowType {
    void launch(int width, int height, String title);
    void setScene(SceneType scene);
    long getId();
}
