package com.teamo.shredengine.engine.clock;

public interface ClockType {
    float getElapsedTime();
    void tick();
    void reset();
}
