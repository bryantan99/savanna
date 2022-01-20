package com.example.savanna.animal;

import com.example.savanna.util.Constant;

public class AnimalFactory {

    public static Integer id = 0;

    public Animal createAnimal(String type) {
        return switch (type) {
            case Constant.LEOPARD -> new Leopard();
            case Constant.LION -> new Lion();
            case Constant.GIRAFFE -> new Giraffe();
            case Constant.ZEBRA -> new Zebra();
            case Constant.EAGLE -> new Eagle();
            case Constant.SPARROW -> new Sparrow();
            case Constant.OSTRICH -> new Ostrich();
            default -> null;
        };
    }

}
