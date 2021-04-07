package com.asodc.jme3.example.update;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class HelloUpdateLoop extends SimpleApplication {
    private Geometry boxGeometry;

    public static void main(String... args) {
        new HelloUpdateLoop().start();
    }

    @Override
    public void simpleInitApp() {
        Box boxMesh = new Box(1f, 1f, 1f);
        boxGeometry = new Geometry("player", boxMesh);
        Material boxMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        boxMaterial.setColor("Color", ColorRGBA.Blue);
        boxGeometry.setMaterial(boxMaterial);
        rootNode.attachChild(boxGeometry);
    }

    @Override
    public void simpleUpdate(float tpf) {
        boxGeometry.rotate(0f, 2f * tpf, 0f);
    }
}
