package com.asodc.jme3.example.appstates;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;

// TODO: figure out how to use the this class...
//  declare spatials in SimpleApplication class and manipulate them here in this one?
public class BlueBoxState extends BaseAppState {
    @Override
    protected void initialize(Application app) {
        // Called during initialization once the app state is attached and before onEnable() is called.
    }

    @Override
    protected void cleanup(Application app) {
        // Called after the app state is detached or during application shutdown if the state is still attached. onDisable() is called before this cleanup() method if the state is enabled at the time of cleanup.
    }

    @Override
    protected void onEnable() {
        // Called when the state is fully enabled, ie: is attached and isEnabled() is true or when the setEnabled() status changes after the state is attached.
        // TODO: try to make box blue?
        //  how to access the box from SimpleApplication, don't have a ref to app here?
    }

    @Override
    protected void onDisable() {
        // Called when the state was previously enabled but is now disabled either because setEnabled(false) was called or the state is being cleaned up.
    }
}
