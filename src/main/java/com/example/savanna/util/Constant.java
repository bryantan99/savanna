package com.example.savanna.util;

import com.example.savanna.animal.AnimalFactory;
import com.example.savanna.animal.Eagle;
import com.example.savanna.animal.Sparrow;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Constant {
    public static final String BGM_DEFAULT = "sound.mp3";
    public static final String SKY_DEFAULT = "sky.jpg";
    public static final String LAND_DEFAULT = "land.png";

    public static final String IMAGE_EAGLE = "eagle.png";
    public static final String IMAGE_EAGLE_FLY = "eagle-fly.png";
    public static final String IMAGE_GIRAFFE = "giraffe.png";
    public static final String IMAGE_LEOPARD = "leopard.png";
    public static final String IMAGE_LION = "lion.png";
    public static final String IMAGE_OSTRICH = "ostrich.png";
    public static final String IMAGE_SPARROW = "sparrow.png";
    public static final String IMAGE_SPARROW_FLY = "sparrow-fly.png";
    public static final String IMAGE_ZEBRA = "zebra.png";

    public static final String MOVE_BEHAVIOR_FLY= "FLY";
    public static final String MOVE_BEHAVIOR_WALK= "WALK";
    public static final String NA= "N/A";

    public static final String FILE_SEPARATOR = File.separator;

    public static final List<String> FLYABLE_ANIMAL = Arrays.asList(Sparrow.class.getSimpleName(), Eagle.class.getSimpleName());

    public static final List<String> ANIMAL_LIST = Arrays.asList(AnimalFactory.ZEBRA, AnimalFactory.GIRAFFE, AnimalFactory.LION, AnimalFactory.EAGLE, AnimalFactory.LEOPARD, AnimalFactory.OSTRICH, AnimalFactory.SPARROW);
    public static final double VIEWSCREEN_WIDTH = 852.0;
}
