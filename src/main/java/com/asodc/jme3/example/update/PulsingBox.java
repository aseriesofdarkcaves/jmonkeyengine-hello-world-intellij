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
    private float scaleSpeed;
    private boolean isGrowing;

    public static void main(String... args) {
        new PulsingBox().start();
    }

    @Override
    public void simpleInitApp() {
        box = createBoxGeometry("box1", ColorRGBA.Blue);
        rootNode.attachChild(box);

        scaleLowerLimit = 1f;
        scaleUpperLimit = 2.5f;
        scaleSpeed = 1f;
        isGrowing = true;
    }

    @Override
    public void simpleUpdate(float tpf) {
        if (isGrowing)
            box.scale(1f + (scaleSpeed * tpf));
        else
            box.scale(1f - (scaleSpeed * tpf));

        float currentScale = box.getLocalScale().x;

        if (currentScale > scaleUpperLimit)
            isGrowing = false;
        else if (currentScale < scaleLowerLimit)
            isGrowing = true;
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
