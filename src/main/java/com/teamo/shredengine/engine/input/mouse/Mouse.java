package com.teamo.shredengine.engine.input.mouse;

import com.teamo.shredengine.model.Vertex;

import static org.lwjgl.glfw.GLFW.*;

public class Mouse implements MouseType {

    private final long windowId;
    private final boolean[] pressedButtons = new boolean[3];

    private double scrollX = 0.0;
    private double scrollY = 0.0;
    private double lastX = 0.0;
    private double lastY = 0.0;
    private double x = 0.0;
    private double y = 0.0;
    private boolean isDragging = false;

    public Mouse(long windowId) {
        this.windowId = windowId;
    }

    private void prepareForReuse() {
        scrollX = 0.0;
        scrollY = 0.0;
        lastX = x;
        lastY = y;
    }

    private void setButtonPressed(int button, boolean isPressed) {
        if (button < pressedButtons.length) {
            pressedButtons[button] = isPressed;
        }
    }

    private void onMoved(long window, double x, double y) {
        lastX = this.x;
        lastY = this.y;
        this.x = x;
        this.y = y;

        isDragging = false;
        for (boolean isPressed : pressedButtons) {
            if (isPressed) {
                isDragging = true;
                break;
            }
        }
    }

    private void onButtonClicked(long window, int button, int action, int mods) {
        if (action == GLFW_PRESS) {
            setButtonPressed(button, true);
        } else if (action == GLFW_RELEASE) {
            setButtonPressed(button, false);
            isDragging = false;
        }
    }

    private void onScrolled(long window, double x, double y) {
        scrollX = x;
        scrollY = y;
    }

    @Override
    public void startDetecting() {
        glfwSetCursorPosCallback(windowId, this::onMoved);
        glfwSetMouseButtonCallback(windowId, this::onButtonClicked);
        glfwSetScrollCallback(windowId, this::onScrolled);
    }

    @Override
    public void stopDetecting() {
        glfwSetCursorPosCallback(windowId, null);
        glfwSetMouseButtonCallback(windowId, null);
        glfwSetScrollCallback(windowId, null);
    }

    @Override
    public Vertex getPosition() {
        return new Vertex(x, y);
    }

    @Override
    public Vertex getScrollPosition() {
        return new Vertex(scrollX, scrollY);
    }

    @Override
    public Vertex getPositionDelta() {
        return new Vertex(lastX - x, lastY - y);
    }

    @Override
    public boolean isButtonPressed(MouseButton button) {
        return button.id < pressedButtons.length && pressedButtons[button.id];
    }

    @Override
    public boolean isDragging() {
        return isDragging;
    }
}
