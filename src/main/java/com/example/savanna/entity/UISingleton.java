package com.example.savanna.entity;

import com.example.savanna.environment.EnvironmentSingleton;

public class UISingleton {

    private UISingleton uniqueInstance;
    private EnvironmentSingleton env;

    private UISingleton() {

    }

    public UISingleton getUniqueInstance() {
        return this.uniqueInstance;
    }

    public EnvironmentSingleton getEnv() {
        return env;
    }

    public void setEnv(EnvironmentSingleton env) {
        this.env = env;
    }
}
