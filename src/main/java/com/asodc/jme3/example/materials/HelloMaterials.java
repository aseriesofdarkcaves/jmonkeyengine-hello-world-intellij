package com.asodc.jme3.example.materials;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;

public class HelloMaterials extends SimpleApplication {
    public static void main(String... args) {
        new HelloMaterials().start();
    }

    @Override
    public void simpleInitApp() {
        initCube();
        initTransparentCube();
        initSphere();
        initLighting();
    }

    private void initCube() {
        Texture texture = assetManager.loadTexture("Interface/Logo/Monkey.jpg");

        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setTexture("ColorMap", texture);

        Box mesh = new Box(1f, 1f, 1f);

        Geometry cube = new Geometry("cube", mesh);
        cube.setMaterial(material);
        cube.setLocalTranslation(-3f, 1.0f, 0f);

        rootNode.attachChild(cube);
    }

    private void initTransparentCube() {
        Texture texture = assetManager.loadTexture("Textures/ColoredTex/Monkey.png");

        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setTexture("ColorMap", texture);
        material.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);

        Box mesh = new Box(1f, 1f, 0.01f);

        Geometry cube = new Geometry("transparentCube", mesh);
        cube.setQueueBucket(RenderQueue.Bucket.Transparent);
        cube.setMaterial(material);

        rootNode.attachChild(cube);
    }

    private void initSphere() {
        Texture diffuseMap = assetManager.loadTexture("Textures/Terrain/Pond/Pond.jpg");
        Texture normalMap = assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png");

        Material material = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        material.setTexture("DiffuseMap", diffuseMap);
        material.setTexture("NormalMap", normalMap);
        material.setBoolean("UseMaterialColors", true);
        material.setColor("Diffuse", ColorRGBA.White);
        material.setColor("Specular", ColorRGBA.White);
        material.setFloat("Shininess", 64f);

        Sphere mesh = new Sphere(32, 32, 2f);

        Geometry sphere = new Geometry("sphere", mesh);
        sphere.setMaterial(material);
        sphere.setLocalTranslation(0f, 2f, -2f);
        sphere.rotate(1.6f, 0f, 0f);

        rootNode.attachChild(sphere);
    }

    private void initLighting() {
        DirectionalLight directionalLight = new DirectionalLight();
        directionalLight.setDirection(new Vector3f(1f, 0f, -2f));
        directionalLight.setColor(ColorRGBA.White);

        rootNode.addLight(directionalLight);
    }
}
