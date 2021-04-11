package com.asodc.jme3.example.simpleapplication;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class HelloSimpleApplication extends SimpleApplication {
    public static void main(String... args) {
        new HelloSimpleApplication().start();
    }

    public void simpleInitApp() {
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Blue);

        Box boxMesh = new Box(1f, 1f, 1f);

        Geometry boxGeometry = new Geometry("box", boxMesh);
        boxGeometry.setMaterial(material);

        rootNode.attachChild(boxGeometry);
    }
}
