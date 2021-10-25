package com.teamo.shredengine.engine.input.mouse;

public enum MouseButton {
    LEFT(0),
    RIGHT(1),
    WHEEL(3);

    public final int id;

    MouseButton(int id) {
        this.id = id;
    }
}
