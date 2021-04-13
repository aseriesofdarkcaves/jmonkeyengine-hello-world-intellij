package com.asodc.jme3.example.update;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class RollingCube extends SimpleApplication {
    private Geometry cubeGeometry;

    private float rotationRate = 2f;
    private float translationRate = 2f;

    public static void main(String... args) {
        new RollingCube().start();
    }

    @Override
    public void simpleInitApp() {
        Material cubeMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        cubeMaterial.setColor("Color", ColorRGBA.Red);

        Box cubeMesh = new Box(1f, 1f, 1f);

        cubeGeometry = new Geometry("cube", cubeMesh);
        cubeGeometry.setMaterial(cubeMaterial);

        rootNode.attachChild(cubeGeometry);
    }

    @Override
    public void simpleUpdate(float tpf) {
        rollCube(tpf, rotationRate, translationRate);
    }

    /**
     * Moves the cube in a manner where the rotation and translation rates can vary independently from each other.
     *
     * @param tpf time per frame
     * @param rotationRate the rate of rotation around the x-axis
     * @param translationRate the rate of translation along the z-axis
     */
    private void rollCube(float tpf, float rotationRate, float translationRate) {
        cubeGeometry.rotate(rotationRate * tpf, 0f, 0f);
        cubeGeometry.move(0f, 0f, translationRate * tpf);
    }
}
