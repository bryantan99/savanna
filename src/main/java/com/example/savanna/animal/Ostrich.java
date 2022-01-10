package com.example.savanna.animal;

import com.example.savanna.util.Constant;

public class Ostrich extends Animal {
    public Ostrich() {
        super(Constant.IMAGE_OSTRICH, AnimalFactory.id++);
        setFly(false);
        adjustPositionYAccordingToIsFly();
    }
}
