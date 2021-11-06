package com.teamo.shredengine.game;

import com.teamo.shredengine.engine.input.keyboard.KeyboardType;
import com.teamo.shredengine.engine.input.mouse.MouseType;
import com.teamo.shredengine.engine.renderer.MeshCreator;
import com.teamo.shredengine.engine.renderer.Renderable;
import com.teamo.shredengine.engine.renderer.ShaderProgram;
import com.teamo.shredengine.engine.renderer.ShaderProgramCreator;
import com.teamo.shredengine.engine.scene.Scene;
import com.teamo.shredengine.engine.util.Loader;
import com.teamo.shredengine.model.Mesh;

public class GameScene extends Scene implements Renderable {

    private Mesh[] meshes;

    private ShaderProgram shaderProgram;

    public GameScene(KeyboardType keyboard, MouseType mouse) {
        super(keyboard, mouse);
    }

    @Override
    public void setup() {
        meshes = new Mesh[] {MeshCreator.create()};

        String vertexShaderCode = Loader.loadShader("/vertex.shad");
        String fragmentShaderCode = Loader.loadShader("/fragment.shad");
        shaderProgram = ShaderProgramCreator.create(vertexShaderCode, fragmentShaderCode);
    }

    @Override
    public Renderable update(float deltaTime) {
        return this;
    }

    @Override
    public Mesh[] getMeshes() {
        return meshes;
    }

    @Override
    public ShaderProgram getShaderProgram() {
        return shaderProgram;
    }
}
