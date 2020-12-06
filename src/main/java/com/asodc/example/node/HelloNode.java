package com.asodc.example.node;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class HelloNode extends SimpleApplication {
    public static void main(String... args) {
        new HelloNode().start();
    }

    @Override
    public void simpleInitApp() {
        // TODO: refactor these into a reusable method
        Geometry blueBoxGeometry = getBlueBox();
        Geometry redBoxGeometry = getRedBox();

        Node pivot = new Node("pivot");
        rootNode.attachChild(pivot);

        pivot.attachChild(blueBoxGeometry);
        pivot.attachChild(redBoxGeometry);

        pivot.rotate(0.4f, 0.4f, 0f);
    }

    private Geometry getBlueBox() {
        Box blueBox = new Box(1, 1, 1);
        Geometry blueGeometry = new Geometry("blueBox", blueBox);
        blueGeometry.setLocalTranslation(new Vector3f(1, -1, 1));
        // TODO: find solution for materials in IntelliJ
        Material blueBoxMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        blueBoxMaterial.setColor("Color", ColorRGBA.Blue);
        return blueGeometry;
    }

    private Geometry getRedBox() {
        Box redBox = new Box(1, 1, 1);
        Geometry redGeometry = new Geometry("redBox", redBox);
        redGeometry.setLocalTranslation(new Vector3f(1, 3, 1));
        // TODO: find solution for materials in IntelliJ
        Material redBoxMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        redBoxMaterial.setColor("Color", ColorRGBA.Red);
        return redGeometry;
    }
}
