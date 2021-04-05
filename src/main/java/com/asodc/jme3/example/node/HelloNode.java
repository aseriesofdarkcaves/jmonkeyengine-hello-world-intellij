package com.asodc.jme3.example.node;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class HelloNode extends SimpleApplication {
    public static void main(String... args) {
        new HelloNode().start();
    }

    @Override
    public void simpleInitApp() {
        Geometry blueBox = createBox("blueBox", ColorRGBA.Blue);
        blueBox.setLocalTranslation(1f, -1f, 1f);

        Geometry redBox = createBox("redBox", ColorRGBA.Red);
        redBox.setLocalTranslation(1f, 3f, 1f);

        Node pivot = new Node("pivot");
        pivot.attachChild(blueBox);
        pivot.attachChild(redBox);
        pivot.rotate(0.4f, 0.4f, 0f);

        rootNode.attachChild(pivot);
    }

    private Geometry createBox(String name, ColorRGBA color) {
        Box box = new Box(1f, 1f, 1f);

        Geometry geometry = new Geometry(name, box);

        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", color);
        geometry.setMaterial(material);

        return geometry;
    }
}
