package com.teamo.shredengine.engine.clock;

public class Clock implements ClockType {

    private final float initialTime = System.nanoTime();

    private float startTime = 0f;
    private float endTime = 0f;
    private float elapsedTime = -1f;

    public Clock() {}

    private float getTime() {
        float elapsedTime = System.nanoTime() - initialTime;
        double elapsedSeconds = elapsedTime * 1E-9;
        return (float) elapsedSeconds;
    }

    @Override
    public void reset() {
        startTime = getTime();
        endTime = startTime;
    }

    @Override
    public float getElapsedTime() {
        return elapsedTime;
    }

    @Override
    public void tick() {
        endTime = getTime();
        elapsedTime = endTime - startTime;
        startTime = endTime;
    }
}
