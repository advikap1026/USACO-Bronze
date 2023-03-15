import java.util.*;
import java.io.*;
public class leaders2 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        input.nextLine();
        String strCows = input.nextLine();
        char[] cows = strCows.toCharArray();
        //System.out.println(strCows);
        int[] listNums = new int[numCows];
        //System.out.println("numCows: " + numCows);
        for (int i = 0; i < numCows; i++) {
            listNums[i] = input.nextInt();
            //System.out.print(listNums[i]);

        }
        //System.out.println();
        int numG = 0;
        int numH = 0;
        for (int i = 0; i < numCows; i++) {
            if (cows[i] == 'G') {
                numG++;
            } else {
                numH++;
            }
        }

        //System.out.println("numG: " + numG);
        //System.out.println("numH: " + numH);

        int[] possibleGLeaders = new int[numG];
        int[] possibleHLeaders = new int[numH];
        for (int i = 0; i < numG; i++) {
            possibleGLeaders[i] = -1;
        }
        for (int i = 0; i < numH; i++) {
            possibleHLeaders[i] = -1;
        }

        //loop to find all the possible g leaders - has all the gs
        int gLeaderCount = 0;
        int hLeaderCount = 0;
        for (int i = 0; i < numCows; i++) {
            if (cows[i] == 'H') {
                continue;
            } else {
                int count = 0;
                //System.out.println("cowsArr length: " + cowsArr.length);
                int numGInArr = 0;
                for (int j = i; j < listNums[i]; j++) {

                    if (cows[j] == 'G') {
                        numGInArr++;
                    }
                }
               // System.out.println("numGInArr: " + numGInArr);
                if (numG == numGInArr) {
                    possibleGLeaders[gLeaderCount] = i;
                    gLeaderCount++;
                    //System.out.println("Adding count = " + gLeaderCount + " and Printing G Leaders " + Arrays.toString(possibleGLeaders) );
                }
            }
        }

        //loop through all of the hs - check if contains all
        for (int i = 0; i < numCows; i++) {
            if (cows[i] == 'G') {
                continue;
            } else {
                // System.out.println("cowsArr length: " + cowsArr.length);
                int numHInArr = 0;
                for (int j = i; j < listNums[i]; j++) {
                    if (cows[j] == 'H') {
                        numHInArr++;
                    }
                }
                //System.out.println("numH in arr: " + numHInArr);
                if (numH == numHInArr) {
                    possibleHLeaders[hLeaderCount] = i;
                    hLeaderCount++;
                    //System.out.println("Adding Hleaders = " + hLeaderCount + "  and Printing H Leaders " + Arrays.toString(possibleHLeaders));
                }
            }
        }

        //System.out.println("After loop 2  Gcount = " + gLeaderCount + " and Printing G Leaders " + Arrays.toString(possibleGLeaders) );

        //System.out.println("After loop 2 HCount = " + hLeaderCount + "  and Printing H Leaders " + Arrays.toString(possibleHLeaders));



        //fill any G or H that contain the other leader
        for(int i = 0; i<numCows; i++){
            //check if G cows contain an H leader
            if(cows[i] == 'G'){
                int theirList = listNums[i]-1;
                boolean isGAlreadyLeader = false;
                for(int j = 0; j<gLeaderCount; j++){
                    if(i == possibleGLeaders[j]){
                        //System.out.println ("G already in leader at index " + i);
                        isGAlreadyLeader=true;
                        break;
                    }
                }

                if(isGAlreadyLeader)
                    continue;


                for(int j = 0; j<hLeaderCount; j++){
                    if(possibleHLeaders[j] >= i &&  possibleHLeaders[j] <= theirList){
                        possibleGLeaders[gLeaderCount] = i;
                        gLeaderCount++;
                        //System.out.println("Adding count = " + gLeaderCount + " and Printing G Leaders " + Arrays.toString(possibleGLeaders) );

                    }
                }

            } else{
                //check H leaders
                int theirList = listNums[i]-1;
                boolean isHAlreadyLeader=false;
                for(int j = 0; j<possibleHLeaders.length; j++){
                    if(i== possibleHLeaders[j]){
                       //System.out.println ("H already in leader at index " + i);
                        isHAlreadyLeader = true;
                        break;
                    }
                }

                if (isHAlreadyLeader)
                    continue;


                for(int j = 0; j<possibleGLeaders.length; j++){
                    if(possibleGLeaders[j] >= i && possibleGLeaders[j] <= theirList){
                        possibleHLeaders[hLeaderCount] = i;
                        hLeaderCount++;
                       // System.out.println("Adding Hleaders = " + hLeaderCount + "  and Printing H Leaders " + Arrays.toString(possibleHLeaders));

                    }
                }
            }

        }

        //System.out.println("After loop 4  Gcount = " + gLeaderCount + " and Printing G Leaders " + Arrays.toString(possibleGLeaders) );

        //System.out.println("After loop 4 HCount = " + hLeaderCount + "  and Printing H Leaders " + Arrays.toString(possibleHLeaders));

         /*
        int finalNumG = 0;
        int finalNumH = 0;


        for(int i = 0; i<possibleGLeaders.length; i++){
            if(possibleGLeaders[i] != -1){
                finalNumG++;
            }
        }
        for(int i = 0; i<possibleHLeaders.length; i++){
            if(possibleHLeaders[i] != -1){
                finalNumH++;
            }
        }
        */


        System.out.println(gLeaderCount * hLeaderCount);


    }

}