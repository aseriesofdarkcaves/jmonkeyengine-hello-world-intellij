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
    private float rotationRate = 5f;
    private float translationRate = 2.5f;

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
        doLockedMovement(tpf);
//        doIndependentMovement(tpf);
    }

    /**
     * Moves the cube in a manner where the rotation and translation rates are locked to the same value.
     *
     * @param tpf time per frame
     */
    private void doLockedMovement(float tpf) {
        rotationTicks += tpf;
        if (rotationTicks < rotationRate) {
            cubeGeometry.rotate(rotationRate * tpf, 0f, 0f);
            cubeGeometry.move(0f, 0f, rotationRate * tpf);
            rotationTicks = 0;
        }
    }

    /**
     * Moves the cube in a manner where the rotation and translation rates can vary independently from each other.
     *
     * @param tpf time per frame
     */
    private void doIndependentMovement(float tpf) {
        rotationTicks += tpf;

        // rotation part
        if (rotationTicks < rotationRate) {
            cubeGeometry.rotate(rotationRate * tpf, 0f, 0f);
            rotationTicks = 0f;
        }

        // translation part
        if (translationTicks < translationRate) {
            cubeGeometry.move(0f, 0f, translationRate * tpf);
            translationTicks = 0f;
        }
    }
}
