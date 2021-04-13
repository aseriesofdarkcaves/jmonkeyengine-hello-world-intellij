package com.asodc.jme3.example.input;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

// TODO: complete the exercises
public class HelloInput extends SimpleApplication {
    private Geometry cube;

    private boolean isRunning = true;

    public static void main(String... args) {
        new HelloInput().start();
    }

    @Override
    public void simpleInitApp() {
        initCube();
        initKeybindings();
    }

    private void initCube() {
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Blue);

        Box boxMesh = new Box(1f, 1f, 1f);

        cube = new Geometry("Player", boxMesh);
        cube.setMaterial(material);

        rootNode.attachChild(cube);
    }

    /**
     * Custom Keybinding: Map named actions to inputs.
     */
    private void initKeybindings() {
        // You can map one or several inputs to one named action
        inputManager.addMapping("Pause", new KeyTrigger(KeyInput.KEY_P));
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_J));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_K));
        inputManager.addMapping("Rotate", new KeyTrigger(KeyInput.KEY_SPACE), new MouseButtonTrigger(MouseInput.BUTTON_LEFT));

        final ActionListener actionListener = (name, keyPressed, tpf) -> {
            if (name.equals("Pause") && !keyPressed) {
                isRunning = !isRunning;
            }
        };

        final AnalogListener analogListener = (name, value, tpf) -> {
            if (isRunning) {
                if (name.equals("Rotate")) {
                    cube.rotate(0, value * speed, 0);
                }
                if (name.equals("Right")) {
                    Vector3f v = cube.getLocalTranslation();
                    cube.setLocalTranslation(v.x + value * speed, v.y, v.z);
                }
                if (name.equals("Left")) {
                    Vector3f v = cube.getLocalTranslation();
                    cube.setLocalTranslation(v.x - value * speed, v.y, v.z);
                }
            } else {
                System.out.println("Press P to unpause.");
            }
        };

        inputManager.addListener(actionListener, "Pause");
        inputManager.addListener(analogListener, "Left", "Right", "Rotate");
    }
}
