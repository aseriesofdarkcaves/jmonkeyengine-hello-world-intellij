package com.asodc.jme3.example.update;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class RollingCube extends SimpleApplication {
    private Geometry cubeGeometry;

    private float rotationTicks = 0f;
    private float translationTicks = 0f;
    private float rotationRate = 1f;
    private float translationRate = 0.01f;

    public static void main(String... args) {
        new RollingCube().start();
    }

    @Override
    public void simpleInitApp() {
        Box cubeMesh = new Box(1f, 1f, 1f);

        cubeGeometry = new Geometry("cube", cubeMesh);

        Material cubeMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        cubeMaterial.setColor("Color", ColorRGBA.Red);

        cubeGeometry.setMaterial(cubeMaterial);

        rootNode.attachChild(cubeGeometry);
    }

    @Override
    public void simpleUpdate(float tpf) {
        rotationTicks += tpf;

        // rotation part
        if (rotationTicks < rotationRate) {
            cubeGeometry.rotate(tpf, 0f, 0f);
            rotationTicks = 0f;
        }

        // translation part
        if (translationTicks < translationRate) {
            cubeGeometry.setLocalTranslation(0f, 0f, translationRate);
            translationTicks = 0f;
        }
    }
}
