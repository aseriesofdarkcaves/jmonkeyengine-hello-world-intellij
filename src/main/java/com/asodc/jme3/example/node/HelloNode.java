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

        Node node = new Node("node");
        node.attachChild(blueBox);
        node.attachChild(redBox);
        node.rotate(0.4f, 0.4f, 0f);

        // not all nodes need to be visible, they can also store data which can be used later
        Node testNode = new Node("test");
        testNode.setUserData("health", 100);

        int health = testNode.getUserData("health");

        rootNode.attachChild(node);
    }

    private Geometry createBox(String name, ColorRGBA color) {
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", color);

        Box boxMesh = new Box(1f, 1f, 1f);

        Geometry boxGeometry = new Geometry(name, boxMesh);
        boxGeometry.setMaterial(material);

        return boxGeometry;
    }
}
