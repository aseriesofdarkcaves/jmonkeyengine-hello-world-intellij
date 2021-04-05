package com.asodc.jme3.example.appstates;

import com.jme3.app.SimpleApplication;
import com.jme3.scene.shape.Box;

public class HelloAppStates extends SimpleApplication {
    public Box box;

    public HelloAppStates() {
        super(new BlueBoxState(), new RedBoxState());
    }

    public static void main(String... args) {
        new HelloAppStates().start();
    }

    @Override
    public void simpleInitApp() {
        // TODO: implement something as an example
    }
}
