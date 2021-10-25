package com.teamo.shredengine.application.builder;

import com.teamo.shredengine.application.Application;
import com.teamo.shredengine.application.ApplicationType;
import com.teamo.shredengine.engine.clock.Clock;
import com.teamo.shredengine.engine.renderer.Renderer;
import com.teamo.shredengine.engine.renderer.RendererType;
import com.teamo.shredengine.engine.window.Window;

public class ApplicationBuilder implements ApplicationBuilderType {

    public ApplicationType build() {
        Clock clock = new Clock();
        RendererType renderer = new Renderer();
        Window window = new Window(clock, renderer);
        return new Application(window);
    }
}
