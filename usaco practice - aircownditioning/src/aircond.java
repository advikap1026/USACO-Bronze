import java.util.*;
import java.io.*;
public class aircond {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        //setting the arrays
        int[] preferred = new int[numCows];
        int[] current = new int[numCows];

        for(int i = 0; i<numCows; i++){
            preferred[i] = input.nextInt();
        }
        for(int i = 0; i<numCows; i++){
            current[i] = input.nextInt();
        }

        boolean isPreferred = false;
        int startInd = 0;
        int endInd = 0;
        boolean isPositive;
        int total = 0;
        //setting the start index
        while(!isPreferred){
            if(preferred[startInd] - current[startInd] == 0){
                startInd++;
                if(startInd >= numCows){
                    isPreferred = true;
                }
                continue;
            }
            else if(preferred[startInd] - current[startInd] > 0){
                isPositive = true;
            }
            else{
                isPositive = false;
            }
           // System.out.print("start ind: " + startInd + " ");
            //setting end index
            endInd = startInd;

            boolean rangeCont = true;

            while(rangeCont){
                int currentDir = preferred[endInd] - current[endInd];
                if(isPositive) {
                    if (currentDir > 0) {
                        //System.out.println("increasing");
                        endInd++;
                        if (endInd >= numCows) {
                            rangeCont = false;
                        }

                    } else {
                        rangeCont = false;

                    }
                }
                else if(!isPositive) {

                    if (currentDir < 0) {
                       // System.out.println("decreasing");
                        endInd++;
                        if (endInd >= numCows) {
                            rangeCont = false;
                        }


                    } else {
                        rangeCont = false;

                    }
                }

            }
           // System.out.println("end ind: " + endInd);

            //loop through current and update it
            for(int i = startInd; i<endInd; i++){
                if(isPositive){
                    current[i] += 1;
                }
                else if(!isPositive){
                    current[i] -= 1;
                }
            }
            total++;
           // System.out.println("total: " + total);

        }
        System.out.println(total);


    }
}
