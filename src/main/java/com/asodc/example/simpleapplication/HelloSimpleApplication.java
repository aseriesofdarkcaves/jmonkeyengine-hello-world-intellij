package com.asodc.example.simpleapplication;

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
        Box box = new Box(1, 1, 1);
        Geometry geometry = new Geometry("Box", box);
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Blue);
        geometry.setMaterial(material);
        rootNode.attachChild(geometry);
    }
}
