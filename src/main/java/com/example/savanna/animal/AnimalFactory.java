package com.example.savanna.animal;

/**
 * @Author Tan Jia Qin (17142247/1)
 * @Date 05-Jan-22 10:18 PM
 * @Version 1.0
 */
public class AnimalFactory {

    public static final String LEOPARD = "leopard";
    public static final String LION = "lion";
    public static final String GIRAFFE = "giraffe";
    public static final String ZEBRA = "zebra";
    public static final String EAGLE = "eagle";
    public static final String SPARROW = "sparrow";
    public static final String OSTRICH = "ostrich";

    public Animal createAnimal(String type) {
        switch (type) {
            case LEOPARD:
                return new Leopard();
            case LION:
                return new Lion();
            case GIRAFFE:
                return new Giraffe();
            case ZEBRA:
                return new Zebra();
            case EAGLE:
                return new Eagle();
            case SPARROW:
                return new Sparrow();
            case OSTRICH:
                return new Ostrich();
            default:
                return null;
        }
    }

}
