import java.util.*;
import java.io.*;

public class aircownditioning {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        //System.out.println("n: " + n);
        int[] current = new int[numCows];
        int[] preferred = new int[numCows];
        for(int i = 0; i<numCows; i++){
            preferred[i] = input.nextInt();
            //System.out.print(preferred[i] + " ");
        }
        //System.out.println();
        for(int i = 0; i<numCows; i++){
            current[i] = input.nextInt();
            //System.out.print(current[i] + " ");
        }

        boolean isPreferred = false;
        int startInd = 0;
        int endInd = 0;
        int whichDir;
        int totalCount = 0;

        while(!isPreferred){

            //find startIndex and exit condition
            if(preferred[startInd] - current[startInd] == 0){
                startInd++;
                if (startInd >= numCows){
                    isPreferred = true;
                }
                continue;
            }
            else if(preferred[startInd] - current[startInd] > 0){
                whichDir = 1;
            }
            else{
                whichDir = -1;
            }

            //finding end index
            endInd = startInd;
            //boolean isDecreasing = false;
            boolean rangeCont = true;
           // System.out.println("rangeCount: " + rangeCont);
            while(rangeCont) {
                //System.out.println("end index: " + endInd);
               // System.out.println("which dir: " + whichDir);

                int currentDir = preferred[endInd] - current[endInd];
               // System.out.println("current dir: " + currentDir);
                if (whichDir == 1) {
                    // System.out.println("which direction is 1 ");
                    if (currentDir > 0 ) {
                        endInd++;
                        //System.out.println("increasing endInd = " + endInd);
                        if (endInd >= numCows) rangeCont = false;
                    } else {
                        //System.out.println("stopping and endIndex = " + endInd);
                        rangeCont = false;
                    }
                   // System.out.println("getting out");
                }
                else {
                    //whichDir is -1
                    if (currentDir < 0 ) {
                        endInd++;
                       //System.out.println("Direction is negative and end Index increased to " + endInd);
                        if (endInd >= numCows) rangeCont = false;
                    } else {
                       // System.out.println("stopping decreased range");
                        rangeCont = false;
                        break;
                    }
                }
            }

            //update the temperatures increase the total count
            //System.out.println ("Sending command: " + whichDir + " From: " + startInd + " End: " + endInd);
            for(int i = startInd; i<endInd; i++){
                if(whichDir == 1){
                    current[i] += 1;
                }
                else if(whichDir == -1){
                    current[i] -= 1;
                }
            }
            totalCount++;

            /*System.out.println("is preff: " + isPreferred);
            System.out.println("range count: " + rangeCont);
            System.out.println ("Total Count: " + totalCount);*/
        }
        System.out.println(totalCount);

    }
}
