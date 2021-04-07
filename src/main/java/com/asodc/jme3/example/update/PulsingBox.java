package com.asodc.jme3.example.update;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class PulsingBox extends SimpleApplication {
    private Geometry box;
    private float scaleLowerLimit;
    private float scaleUpperLimit;

    public static void main(String... args) {
        new PulsingBox().start();
    }

    @Override
    public void simpleInitApp() {
        box = createBoxGeometry("box1", ColorRGBA.Blue);
        rootNode.attachChild(box);

        scaleLowerLimit = 1f;
        scaleUpperLimit = 100f;

        flyCam.setEnabled(false);
    }

    @Override
    public void simpleUpdate(float tpf) {
        // TODO: make the box pulsate
        // box.getLocalScale will return the current scale of the box as a Vector3f
        // we have a cube so we only need to check one component for its scale because they're all the same scale
        float currentScale = box.getLocalScale().x;

        if (currentScale <= scaleLowerLimit) {
            box.scale(1.01f);
//            box.setLocalScale();
        } else {
            box.scale(0.9f);
        }
        System.out.println(currentScale);
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
