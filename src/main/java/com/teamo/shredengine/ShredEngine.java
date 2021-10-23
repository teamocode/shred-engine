package com.teamo.shredengine;

import com.teamo.shredengine.util.Loader;
import com.teamo.shredengine.render.OpenGlRenderer;
import com.teamo.shredengine.render.Shader;
import com.teamo.shredengine.render.VertexArrayObject;
import com.teamo.shredengine.render.VertexBufferObject;
import com.teamo.shredengine.window.GlfwWindow;

public class ShredEngine {

    public static void main(String[] args) {
        System.out.println("sup planet");


        // create window
        int windowWidth = 1024;
        int windowHeight = 768;
        String windowTitle = "Shred Engine";
        GlfwWindow window = new GlfwWindow(windowWidth, windowHeight, windowTitle);
        window.create();


        // create renderer
        OpenGlRenderer renderer = new OpenGlRenderer();


        // create shader
        Shader shader = new Shader();
        String vertexShaderFile = "/vertex.shad";
        String fragmentShaderFile = "/fragment.shad";
        try {
            shader.create(Loader.loadShader(vertexShaderFile),
                    Loader.loadShader(fragmentShaderFile));
        } catch (Exception e) {
            e.printStackTrace();
        }


        // create a vao
        VertexArrayObject vao = new VertexArrayObject();
        float[] vertices = {0f, 0f, 0f,
                0.5f, 0f, 0f,
                0f, 0.5f, 0f};
        VertexBufferObject vbo = new VertexBufferObject(vertices);
        vao.setVbo(vbo);


        // create another vao
        VertexArrayObject vao2 = new VertexArrayObject();
        float[] vertices2 = {0f, 0f, 0f,
                -0.5f, 0f, 0f,
                0f, -0.5f, 0f};
        VertexBufferObject vbo2 = new VertexBufferObject(vertices2);
        vao2.setVbo(vbo2);


        // game loop
        while(!window.shouldClose()) {

            // clear previous rendering
            renderer.clearScreen();
            // bind shader
            renderer.bindShader(shader);
            // render vao's
            renderer.renderVao(vao);
            renderer.renderVao(vao2);
            // unbind shader
            renderer.unbindShader();

            // update window
            window.update();
        }

    }

}
