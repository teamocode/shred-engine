package com.teamo.shredengine.engine.input.keyboard;

import static org.lwjgl.glfw.GLFW.*;

public class Keyboard implements KeyboardType {

    private final long windowId;
    private final boolean[] pressedKeys = new boolean[350];

    public Keyboard(long windowId) {
        this.windowId = windowId;
    }

    private void setKeyPressed(int key, boolean isPressed) {
        if (key < pressedKeys.length) {
            pressedKeys[key] = isPressed;
        }
    }

    private void onKeyStateChanged(long windowId, int key, int scanCode, int action, int mods) {
        if (action == GLFW_PRESS) {
            setKeyPressed(key, true);
        } else if (action == GLFW_RELEASE) {
            setKeyPressed(key, false);
        }
    }

    @Override
    public void startDetecting() {
        glfwSetKeyCallback(windowId, this::onKeyStateChanged);
    }

    @Override
    public void stopDetecting() {
        glfwSetKeyCallback(windowId, null);
    }

    @Override
    public boolean isKeyPressed(Key key) {
        return key.id < pressedKeys.length && pressedKeys[key.id];
    }
}
