package com.example.savanna.animal;

import com.example.savanna.util.Constant;

public class Zebra extends Animal {
    public Zebra() {
        super(Constant.IMAGE_ZEBRA, AnimalFactory.id++);
    }
}
