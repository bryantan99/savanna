package com.example.savanna.animal;

import com.example.savanna.util.Constant;

public class Sparrow extends Animal {
    public Sparrow() {
        super(Constant.IMAGE_SPARROW, AnimalFactory.id++);
        setFly(true);
        adjustPositionYAccordingToIsFly();
    }
}
