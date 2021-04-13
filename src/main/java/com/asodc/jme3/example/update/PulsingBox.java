package com.asodc.jme3.example.update;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class PulsingBox extends SimpleApplication {
    private Geometry box;
    private float scaleLowerLimit = 1f;
    private float scaleUpperLimit = 2.5f;
    private float scaleSpeed = 1f;
    private boolean isGrowing = true;

    public static void main(String... args) {
        new PulsingBox().start();
    }

    @Override
    public void simpleInitApp() {
        box = createBoxGeometry("box", ColorRGBA.Blue);

        rootNode.attachChild(box);
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
        Material boxMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        boxMaterial.setColor("Color", color);

        Box boxMesh = new Box(1f, 1f, 1f);

        Geometry boxGeometry = new Geometry(name, boxMesh);
        boxGeometry.setMaterial(boxMaterial);

        return boxGeometry;
    }
}
