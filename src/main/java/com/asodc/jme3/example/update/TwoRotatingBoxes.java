package com.asodc.jme3.example.update;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class TwoRotatingBoxes extends SimpleApplication {
    private Geometry box1;
    private Geometry box2;

    public static void main(String... args) {
        new TwoRotatingBoxes().start();
    }

    @Override
    public void simpleInitApp() {
        box1 = createBoxGeometry("box1", ColorRGBA.Blue);
        box1.setLocalTranslation(-2f, 0f, 0f);
        rootNode.attachChild(box1);

        box2 = createBoxGeometry("box2", ColorRGBA.Red);
        box2.setLocalTranslation(2f, 0f, 0f);
        rootNode.attachChild(box2);
    }

    @Override
    public void simpleUpdate(float tpf) {
        // Make box2 rotate twice as fast as box1
        final float rotationAngle = 2f * tpf;
        box1.rotate(0f, rotationAngle, 0f);
        box2.rotate(0f, rotationAngle * 2, 0f);
    }

    private Geometry createBoxGeometry(String name, ColorRGBA color) {
        Box boxMesh = new Box(1f, 1f, 1f);
        Geometry boxGeometry = new Geometry(name, boxMesh);
        Material boxMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        boxMaterial.setColor("Color", color);
        boxGeometry.setMaterial(boxMaterial);
        return boxGeometry;
    }
}
