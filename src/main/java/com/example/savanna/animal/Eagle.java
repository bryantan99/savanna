package com.example.savanna.animal;

import com.example.savanna.util.Constant;

public class Eagle extends Animal {
    public Eagle() {
        super(Constant.IMAGE_EAGLE, AnimalFactory.id++);
        setFly(true);
        adjustPositionYAccordingToIsFly();
    }
}
