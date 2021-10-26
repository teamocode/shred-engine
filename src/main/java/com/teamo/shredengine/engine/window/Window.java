package com.teamo.shredengine.engine.window;

import com.teamo.shredengine.engine.clock.ClockType;
import com.teamo.shredengine.engine.renderer.Renderable;
import com.teamo.shredengine.engine.renderer.RendererType;
import com.teamo.shredengine.engine.scene.SceneType;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window implements WindowType {

    private final ClockType clock;
    private final RendererType renderer;

    private long windowId;
    private SceneType scene;

    public Window(ClockType clock, RendererType renderer) {
        this.clock = clock;
        this.renderer = renderer;
        this.windowId = NULL;
    }

    private void create(int width, int height, String title) {
        // Prepare the window
        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit()) {
            throw new IllegalStateException("Failed to create window");
        } else if (scene == null) {
            throw new IllegalStateException("Scene must be set before calling create");
        }

        // Configure the window
        // glfwDefaultWindowHints();
        // glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

        // Create the window
        windowId = glfwCreateWindow(width, height, title, NULL, NULL);
        if (windowId == NULL) {
            throw new IllegalStateException("Failed to create window");
        }

        // Show the window
        glfwMakeContextCurrent(windowId);
        glfwSwapInterval(1);
        glfwShowWindow(windowId);
        GL.createCapabilities();
    }

    private void start() {
        // Prepare the clock
        clock.reset();

        // Start the window loop
        while (!glfwWindowShouldClose(windowId)) {
            // Detect input state
            glfwPollEvents();

            // Set the base view
            GL11.glClearColor(0f, 0f, 0f, 1f);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            // Update the scene
            float elapsedTime = clock.getElapsedTime();
            if (elapsedTime > 0) {
                Renderable renderable = scene.update(elapsedTime);
                // Display the scene's renderable
                renderer.render(renderable);
                glfwSwapBuffers(windowId);
            }

            // Update the time
            clock.tick();
        }
    }

    private void destroy() {
        glfwFreeCallbacks(windowId);
        glfwDestroyWindow(windowId);
        glfwTerminate();
        GLFWErrorCallback callback = glfwSetErrorCallback(null);
        if (callback != null) {
            callback.free();
        }
    }

    @Override
    public void setScene(SceneType scene) {
        this.scene = scene;
    }

    @Override
    public void launch(int width, int height, String title) {
        create(width, height, title);
        start();
        destroy();
    }

    @Override
    public long getId() {
        return windowId;
    }
}
