package com.example.savanna.animal;

public class AnimalFactory {

    public static final String LEOPARD = "leopard";
    public static final String LION = "lion";
    public static final String GIRAFFE = "giraffe";
    public static final String ZEBRA = "zebra";
    public static final String EAGLE = "eagle";
    public static final String SPARROW = "sparrow";
    public static final String OSTRICH = "ostrich";

    public static Integer id = 0;

    public Animal createAnimal(String type) {
        return switch (type) {
            case LEOPARD -> new Leopard();
            case LION -> new Lion();
            case GIRAFFE -> new Giraffe();
            case ZEBRA -> new Zebra();
            case EAGLE -> new Eagle();
            case SPARROW -> new Sparrow();
            case OSTRICH -> new Ostrich();
            default -> null;
        };
    }

}
