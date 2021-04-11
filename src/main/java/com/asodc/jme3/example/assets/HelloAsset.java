package com.asodc.jme3.example.assets;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class HelloAsset extends SimpleApplication {
    public static void main(String... args) {
        new HelloAsset().start();
    }

    @Override
    public void simpleInitApp() {
        initTeapot();
        initWall();
        initFont();
        initNinja();
        initLighting();
    }

    private void initLighting() {
        DirectionalLight directionalLight = new DirectionalLight();
        directionalLight.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));

        rootNode.addLight(directionalLight);
    }

    private void initNinja() {
        Spatial ninja = assetManager.loadModel("Models/Ninja/Ninja.mesh.xml");
        ninja.scale(0.05f, 0.05f, 0.05f);
        ninja.rotate(0.0f, -3.0f, 0.0f);
        ninja.setLocalTranslation(0.0f, -5.0f, -2.0f);

        rootNode.attachChild(ninja);
    }

    private void initFont() {
        BitmapText text = new BitmapText(guiFont, false);
        text.setSize(guiFont.getCharSet().getRenderedSize());
        text.setText("Hello World");
        text.setLocalTranslation(300, text.getLineHeight(), 0);

        guiNode.attachChild(text);
        guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
    }

    private void initWall() {
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setTexture("ColorMap", assetManager.loadTexture("Textures/Terrain/BrickWall/BrickWall.jpg"));

        Box boxMesh = new Box(2.5f, 2.5f, 1.0f);

        Spatial wall = new Geometry("box", boxMesh);
        wall.setMaterial(material);
        wall.setLocalTranslation(2.0f, -2.5f, 0.0f);

        rootNode.attachChild(wall);
    }

    private void initTeapot() {
        Material material = new Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");

        Spatial teapot = assetManager.loadModel("Models/Teapot/Teapot.obj");
        teapot.setMaterial(material);

        rootNode.attachChild(teapot);
    }
}
