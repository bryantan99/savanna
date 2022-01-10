package com.example.savanna.animal;

import com.example.savanna.util.Constant;

public class Leopard extends Animal {
    public Leopard() {
        super(Constant.IMAGE_LEOPARD, AnimalFactory.id++);
        setFly(false);
        adjustPositionYAccordingToIsFly();
    }
}
