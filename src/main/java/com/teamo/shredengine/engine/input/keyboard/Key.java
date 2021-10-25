package com.teamo.shredengine.engine.input.keyboard;

public enum Key {
    LEFT(203),
    RIGHT(205),
    UP(200),
    DOWN(208),
    SPACE(57);

    public final int id;

    Key(int id) {
        this.id = id;
    }
}
