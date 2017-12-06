package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AlignedGaps {

    private static boolean areGapsAligned(double coordinates_x[], double coordinates_y[], double coordinates_z[], int cases) {
		/* ------------------- INSERT CODE HERE ---------------------*/

		/*
		 * coordinates_x[i], coordinates_y[i], coordinates_z[i] denote the x-y-z coordinates of the i'th gap in the asteroid field.
		 *
		 * Your code should return true if all the gaps are aligned, i.e., they all lie on a single line.
		 *
		 */


		/* -------------------- END OF INSERTION --------------------*/

        /*
        Must work for any number of cases [3,100]
            Will always be true for 2 or fewer cases
         */

        double xDiff = coordinates_x[1] - coordinates_x[0];
        double yDiff = coordinates_y[1] - coordinates_y[0];
        double zDiff = coordinates_z[1] - coordinates_z[0];
        double r;
        final double EPSILON = 0.00001;
        boolean collinear = false;




        if (cases <= 2) {
            collinear = true;
        }

        else{
            for (int i = 2; i < cases; i++){
                if ((Math.abs(xDiff) > Math.abs(yDiff) && Math.abs(xDiff) > Math.abs(zDiff)) || (Math.abs(xDiff) == Math.abs(yDiff) && Math.abs(xDiff) == Math.abs(yDiff))){
                    r = (coordinates_x[i] - coordinates_x[0])/xDiff;

                    if (Math.abs((coordinates_y[i]-coordinates_y[0]) - (r*yDiff)) < EPSILON   &&
                            Math.abs((coordinates_z[i]-coordinates_z[0]) - (r*zDiff)) < EPSILON){

                        collinear = true;
                    }
                    else{
                        collinear = false;                          //The points cannot be collinear if any one is not collinear with the rest
                        break;
                    }
                }

                if (Math.abs(yDiff) > Math.abs(xDiff) && Math.abs(yDiff) > Math.abs(zDiff)){
                    r = (coordinates_y[i] - coordinates_y[0])/yDiff;

                    if (Math.abs((coordinates_x[i]-coordinates_x[0]) - (r*xDiff)) < EPSILON  &&
                            Math.abs((coordinates_z[i]-coordinates_z[0]) - (r*zDiff)) < EPSILON){
                        collinear = true;
                    }
                    else{
                        collinear = false;
                        break;
                    }
                }

                if (Math.abs(zDiff) > Math.abs(xDiff) && Math.abs(zDiff) > Math.abs(yDiff)){
                    r = (coordinates_z[i] - coordinates_z[0])/zDiff;

                    if (Math.abs((coordinates_x[i]-coordinates_x[0]) - (r*xDiff)) < EPSILON  &&
                            Math.abs((coordinates_y[i]-coordinates_y[0]) - (r*yDiff)) < EPSILON){
                        collinear = true;
                    }
                    else{
                        collinear = false;
                        break;
                    }
                }
            }
        }

        return collinear;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("01.in"));

        int numCases = sc.nextInt();

        for(int n = 0; n < numCases; n++)
        {
            int num = sc.nextInt();
            double[] coordinates_x = new double[num];
            double[] coordinates_y = new double[num];
            double[] coordinates_z = new double[num];
            for(int i = 0; i < num; i++) {
                coordinates_x[i] = sc.nextDouble();
                coordinates_y[i] = sc.nextDouble();
                coordinates_z[i] = sc.nextDouble();
            }

            if(areGapsAligned(coordinates_x, coordinates_y, coordinates_z, num)) {
                System.out.println("Gaps are aligned.");
            } else {
                System.out.println("Gaps are NOT aligned.");
            }
        }

        sc.close();
    }
}
/*

 */
