package com.asodc.jme3.example.update;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class ColorChangingBox extends SimpleApplication {
    private Material boxMaterial;

    private float elapsedTickTime = 0f;
    private float colorChangeRate = 1f;

    public static void main(String... args) {
        new ColorChangingBox().start();
    }

    @Override
    public void simpleInitApp() {
        boxMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");

        Box boxMesh = new Box(1f, 1f, 1f);

        Geometry boxGeometry = new Geometry("box", boxMesh);
        boxGeometry.setMaterial(boxMaterial);

        rootNode.attachChild(boxGeometry);
    }

    @Override
    public void simpleUpdate(float tpf) {
        elapsedTickTime += tpf;

        if (elapsedTickTime > colorChangeRate) {
            boxMaterial.setColor("Color", ColorRGBA.randomColor());
            elapsedTickTime = 0f;
        }
    }
}
