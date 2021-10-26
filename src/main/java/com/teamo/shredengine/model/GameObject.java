package com.teamo.shredengine.model;

import com.teamo.shredengine.engine.contact.Contactable;
import com.teamo.shredengine.engine.renderer.Renderable;
import com.teamo.shredengine.render.Shader;
import com.teamo.shredengine.util.Loader;

import java.util.ArrayList;
import java.util.List;

public class GameObject implements Contactable, Renderable {

    /*
    Game Object has place-holder data under the methods extended from Renderable.

    Note: In 'getMeshes()', you will see instantiations of two indexed VBO Meshes
          and one non-indexed VBO Mesh
     */

    @Override
    public Vertex getPosition() {
        return new Vertex(0f, 0f);
    }

    @Override
    public float getRadius() {
        return 0.5f;
    }

    @Override
    public Mesh[] getMeshes() {
        float[] vertices1 = {
                0f, 0f, 0f,
                0.5f, 0f, 0f,
                0.5f, 0.5f, 0f,
                0f, 0.5f, 0f,
                0f, 0.9f, 0f
        };
        int[] indices1 = new int[]{
                0, 1, 2,
                2, 3, 0,
                2, 4, 3
        };
        Mesh indexedMesh1 = new Mesh(vertices1, indices1);

        float[] vertices2 = {
                -0.3f, 0f, 0f,
                -0.5f, 0f, 0f,
                -0.5f, -0.5f, 0f,
                -0.3f, -0.5f, 0f,
                -0.3f, -0.9f, 0f
        };
        int[] indices2 = new int[]{
                0, 1, 2,
                2, 3, 0,
                2, 4, 3
        };
        Mesh indexedMesh2 = new Mesh(vertices2, indices2);

        float[] vertices3 = {
                0.5f, -0.5f, 0f,
                0.5f, -0.8f, 0f,
                0.8f, -0.5f, 0f,

                0.8f, -0.5f, 0f,
                0.8f, -0.8f, 0f,
                0.5f, -0.8f, 0f
        };
        Mesh nonIndexedMesh = new Mesh(vertices3);

        return new Mesh[] {
                indexedMesh1,
                indexedMesh2,
                nonIndexedMesh
        } ;
    }

    @Override
    public Shader getShader() {
        Shader shader = new Shader();
        String vertexShaderFile = "/vertex.shad";
        String fragmentShaderFile = "/fragment.shad";
        try {
            shader.create(Loader.loadShader(vertexShaderFile),
                    Loader.loadShader(fragmentShaderFile));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return shader;
    }

}
