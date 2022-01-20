package com.example.savanna.util;

import com.example.savanna.animal.Eagle;
import com.example.savanna.animal.Sparrow;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Constant {
    public static final String BGM_DEFAULT = "sound.mp3";
    public static final String SKY_DEFAULT = "sky.jpg";
    public static final String LAND_DEFAULT = "land.png";

    public static final String LEOPARD = "leopard";
    public static final String LION = "lion";
    public static final String GIRAFFE = "giraffe";
    public static final String ZEBRA = "zebra";
    public static final String EAGLE = "eagle";
    public static final String SPARROW = "sparrow";
    public static final String OSTRICH = "ostrich";

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

    public static final String BOOLEAN_TRUE = "True";
    public static final String BOOLEAN_FALSE = "False";
    public static final List<String> BOOLEAN_DROPDOWN_LIST = Arrays.asList(BOOLEAN_TRUE, BOOLEAN_FALSE);
    public static final String FILE_SEPARATOR = File.separator;

    public static final List<String> FLYABLE_ANIMAL = Arrays.asList(Sparrow.class.getSimpleName(), Eagle.class.getSimpleName());

    public static final List<String> ANIMAL_LIST = Arrays.asList(ZEBRA, GIRAFFE, LION, EAGLE, LEOPARD, OSTRICH, SPARROW);
    public static final double VIEWSCREEN_WIDTH = 852.0;
    public static final double VIEWSCREEN_HEIGHT = 480.0;
}
