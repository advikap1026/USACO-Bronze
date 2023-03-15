import java.util.*;
import java.io.*;

public class revegetate {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("revegetate.in"));
        int numPastures = in.nextInt();
       // System.out.println(numPastures);
        int numCows = in.nextInt();
        //System.out.println(numCows);
        int[] pastures = new int[numPastures]; //filled with teh type of seed in it
        for(int i = 0; i<pastures.length; i++){
            pastures[i] = 0;
        }
        int[][] pairs = new int[numCows][2];
        for(int i = 0; i<pairs.length; i++){
            for(int j = 0; j<pairs[0].length; j++){
                pairs[i][j] = in.nextInt();
                //System.out.print(pairs[i][j] + " ");
            }
            //System.out.println();
        }

        int[][] pasturesAndPairs = new int[numPastures][3];
        //initializing them
        for(int i = 0; i<numPastures; i++){
            for(int j = 0; j<3; j++){
                pasturesAndPairs[i][j] = -1;
            }
        }
        //organizing the array
        int[] nextAvailSpot = new int[pairs.length];
        for(int i = 0; i<nextAvailSpot.length; i++){
            nextAvailSpot[i] = 0;
        }
        //System.out.println("length of pastures and pairs arr: " + pasturesAndPairs.length);
        for(int i = 0; i<pairs.length; i++){
            int pair1 = pairs[i][0];
            int pair2 = pairs[i][1];
            pasturesAndPairs[pair1-1][nextAvailSpot[pair1-1]] = pair2;
            pasturesAndPairs[pair2-1][nextAvailSpot[pair2-1]] = pair1;
            nextAvailSpot[pair1-1] += 1;
            nextAvailSpot[pair2-1] += 1;
        }

        /*for(int i = 0; i<pasturesAndPairs.length; i++){
            for(int j = 0; j<pasturesAndPairs[0].length; j++){
                System.out.print(pasturesAndPairs[i][j] + " ");
            }
            System.out.println();
        }*/

        for(int i = 0; i<pastures.length; i++){
            boolean stillContinue = true;
            int seed = 1;
            while(stillContinue == true) {
                for (int j = 0; j < pasturesAndPairs[i].length; j++) {


                    if(pasturesAndPairs[i][j] == -1){
                        //reached end of pasture pairs
                        stillContinue = false;
                        break; //break out of the pastures for loop
                    }
                    else if (pastures[pasturesAndPairs[i][j] - 1] == seed) {
                        //when pasture already has seed (move on to next seed)
                        //stillContinue = false;
                        break;
                    }
                    else if(j == pasturesAndPairs[i].length -1){
                        stillContinue = false;
                    }
                }

                if(stillContinue == false) {
                    pastures[i] = seed;
                    //stillContinue = false;
                    //break out of while loop

                }
                else{
                    //when still continue = true
                    seed++;
                }
            }

        }
        /*for(int i = 0; i<pastures.length; i++){
            System.out.println(pastures[i]);
        }*/







        String result = "";
        for(int i = 0; i<pastures.length; i++){
            result = result + pastures[i];
        }

        PrintWriter out = new PrintWriter(new File("revegetate.out"));
        System.out.println(result);
        out.println(result);
        in.close();
        out.close();
    }
}