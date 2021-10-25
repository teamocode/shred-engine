package com.teamo.shredengine.engine.input.keyboard;

public interface KeyboardType {
    void startDetecting();
    void stopDetecting();
    boolean isKeyPressed(Key key);
}
