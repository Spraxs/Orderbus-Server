package com.spraxs.js.framework;

/**
 * Created by Spraxs
 * Date: 26-9-2018
 */

public abstract class Module {

    public Module() {
        onEnable();
    }

    public abstract void onEnable();

}
