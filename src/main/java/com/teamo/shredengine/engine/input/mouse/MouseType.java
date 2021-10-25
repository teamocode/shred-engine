package com.teamo.shredengine.engine.input.mouse;

import com.teamo.shredengine.model.Vertex;

public interface MouseType {
    void startDetecting();
    void stopDetecting();
    Vertex getPosition();
    Vertex getScrollPosition();
    Vertex getPositionDelta();
    boolean isButtonPressed(MouseButton button);
    boolean isDragging();
}
