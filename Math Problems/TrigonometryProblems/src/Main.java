import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

        int trueStatesOfSides = 0;
        int trueStatesOfAngles = 0;

        Scanner skan = new Scanner(System.in);
        String[] sidesLabels = {"side a", "side b", "side c"};
        String[] anglesLabels = {"angle A", "angle B", "angle C"};

        double[] sides = new double[3];
        double[] angles = new double[3];
        boolean[] sidesBool = new boolean[3];
        boolean[] anglesBool = new boolean[3];


        //collect sides
        for (int i = 0; i < 3; ++i) {

            System.out.println("Please enter " + sidesLabels[i] + "\n" + "If side or angle is unknown, enter -1");
            sides[i] = skan.nextDouble();

            if (sides[i] != -1) {
                sidesBool[i] = true;
                trueStatesOfSides++;
            }
        }

        //collect angles
        for (int i = 0; i < 3; ++i) {

            System.out.println("Please enter " + anglesLabels[i] + "\n" + "If side or angle is unknown, enter -1");
            angles[i] = skan.nextDouble();

            if (angles[i] == -1) {
                anglesBool[i] = false;
            } else {
                anglesBool[i] = true;
                trueStatesOfAngles++;
            }
        }

        //convert to radians
        for (int i = 0; i < 3; ++i) {
            angles[i] = Math.toRadians(angles[i]);
        }

        //check if valid triangle
        if (angles[0] + angles[1] + angles[2] > 180) {
            System.out.println("Not a valid triangle.");
            System.exit(0);
        }

        //check if solvable.
        if (trueStatesOfAngles == 0 || trueStatesOfAngles + trueStatesOfSides < 3) {
            System.out.println("Cannot solve.");
            System.exit(0);
        }



        //find missing final angle
        if (trueStatesOfAngles == 2) {

            //if angle A is missing
            if (anglesBool[0] == false) {
                angles[0] = 180 - (angles[1] + angles[2]);
            }
            //if angle B is missing
            if (anglesBool[1] == false) {
                angles[1] = 180 - (angles[0] + angles[2]);
            }
            //if angle C is missing
            if (anglesBool[2] == false) {
                angles[2] = 180 - (angles[0] + angles[1]);
            }
            trueStatesOfAngles++;
        }


        if (trueStatesOfSides == 1) {

            //if we have a
            if (sidesBool[0] == true) {

                //check for compatible angle, otherwise cant solve. (cannot be angle B. Unsolvable)
                if (anglesBool[0] == true || anglesBool[2] == true){

                } else {
                    System.out.println("Cannot solve.");
                    System.exit(0);
                }


                //if we have angle B, preferred angle, find side b
                if (anglesBool[1] == true) {
                    sides[1] = sides[0] * tan(angles[1]);
                    sidesBool[1] = true;
                }
                //if we have angle C, find side b
                if (anglesBool[2] == true) {
                    sides[1] = (sides[0] * cos(angles[2]));
                    sidesBool[1] = true;
                }
            }
            trueStatesOfSides++;
        }

        //solve for remaining side if one is missing
        if (trueStatesOfSides == 2) {

            //if a is missing
            if (sidesBool[0] == false) {
                sides[0] = sqrt(Math.pow(sides[2], 2) - Math.pow(sides[1], 2));
                Math.ceil(sides[0]);
            }
            //if b is missing
            if (sidesBool[1] == false) {
                sides[1] = sqrt(Math.pow(sides[2], 2) - Math.pow(sides[0], 2));
                Math.ceil(sides[1]);
            }
            //if c is missing
            if (sidesBool[2] == false) {
                sides[2] = sqrt(Math.pow(sides[0], 2) + Math.pow(sides[1], 2));
                Math.ceil(sides[2]);
            }
        }

        System.out.println(Arrays.toString(sides));
        System.out.println(Arrays.toString(angles));

    }
}