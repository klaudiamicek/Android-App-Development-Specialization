package mooc.vandy.java4android.buildings.logic;

import java.io.FileNotFoundException;

import mooc.vandy.java4android.buildings.ui.OutputInterface;

/**
 * This Neighborhood utility class provides static helper methods the
 * print a Building List and calculate the area of a Building list.
 * A utility class in Java should always be final and have a private
 * constructor.
 */
public final class Neighborhood {

    // TODO - Put your code here.
    //takes as an input parameter an array of polymorphic Building objects
    public static void print(Building[] buildings, String header, OutputInterface out) {

    }

    public static int calcArea(Building[] buildings) {
        int totalLotArea = 0;
        for(int i = 0; i < buildings.length; i++) {
            totalLotArea += buildings[i].calcLotArea();
        }
        //returns the total lot area of the objects in the array
        return totalLotArea;
    }

}
