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
    private float rotationRate = 2f;
    private float translationRate = 2f;

    public static void main(String... args) {
        new RollingCube().start();
    }

    @Override
    public void simpleInitApp() {
        Box cubeMesh = new Box(1f, 1f, 1f);

        Material cubeMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        cubeMaterial.setColor("Color", ColorRGBA.Red);

        cubeGeometry = new Geometry("cube", cubeMesh);
        cubeGeometry.setMaterial(cubeMaterial);

        rootNode.attachChild(cubeGeometry);
    }

    @Override
    public void simpleUpdate(float tpf) {
        doIndependentMovement(tpf, rotationRate, translationRate);
    }

    /**
     * Moves the cube in a manner where the rotation and translation rates are locked to the same value.
     *
     * @param tpf time per frame
     * @param movementRate the rate of movement for rotation and translation
     */
    private void doLockedMovement(float tpf, float movementRate) {
        rotationTicks += tpf;
        if (rotationTicks < movementRate) {
            cubeGeometry.rotate(movementRate * tpf, 0f, 0f);
            cubeGeometry.move(0f, 0f, movementRate * tpf);
            rotationTicks = 0;
        }
    }

    /**
     * Moves the cube in a manner where the rotation and translation rates can vary independently from each other.
     *
     * @param tpf time per frame
     */
    private void doIndependentMovement(float tpf, float rotationRate, float translationRate) {
        rotationTicks += tpf;

        if (rotationTicks < rotationRate) {
            cubeGeometry.rotate(rotationRate * tpf, 0f, 0f);
            rotationTicks = 0f;
        }

        if (translationTicks < translationRate) {
            cubeGeometry.move(0f, 0f, translationRate * tpf);
            translationTicks = 0f;
        }
    }
}
