import java.util.*;
import java.io.*;
public class leaders {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        input.nextLine();
        String line = input.nextLine();
       // System.out.println(line);
        char[] cows = line.toCharArray();
        //System.out.println(cows.length);
        long[] listNums = new long[numCows];
        for(int i = 0; i<numCows; i++){
            listNums[i] = input.nextLong();
        }
        long possibleLeaders = 0;
        int possibleGLeaders = 0;
        int possibleHLeaders = 0;

        //find total number of each
        long numG = 0;
        long numH = 0;
        for(int i = 0; i<cows.length; i++){
            if(cows[i] == 'G'){
                numG++;
            }
            else{
                numH++;
            }
        }

        for(int i = 0; i<cows.length; i++){
            boolean isG;
            boolean isH;
            if(cows[i] == 'G'){
                isG = true;
                isH = false;
            }
            else{
                isH = true;
                isG = false;
            }
            //create the each cow's list
            char[] list = new char[(int)listNums[i] - i];
            //System.out.println("length: " + list.length);
            long count = 0;
            boolean mightHaveOtherLeader = false;
            long numGInList = 0;
            long numHInList = 0;
            for(int j = i; j<listNums[i]; j++){
                //System.out.println("j: " + j);
                list[(int)count] = cows[j];
                //System.out.println(list[count]);
                if(isG){
                    if(cows[j] == 'H'){
                        mightHaveOtherLeader = true;
                    }
                }
                else{
                    if(cows[j] == 'G'){
                        mightHaveOtherLeader = true;
                    }
                }

                //counting how many G/H in list
                if(cows[j] == 'G'){
                    numGInList ++;
                }
                else{
                    numHInList++;
                }
               // System.out.print(list[(int)count]);
                count++;

            }

            //check if the list meets all of the requirements

                if(isG){
                    if((numGInList == numG && mightHaveOtherLeader) ||(numGInList == numG || mightHaveOtherLeader) ){
                        possibleGLeaders++;
                       // System.out.println("possible leader");
                    }
                }
                else{
                    if((numHInList == numH && mightHaveOtherLeader) || (numHInList == numH || mightHaveOtherLeader)){
                        possibleHLeaders++;
                       // System.out.println("possible leader");
                    }

                }


            //System.out.println();
        }
        //System.out.println(possibleLeaders);
        long finalAns =  possibleGLeaders*possibleHLeaders; //Math.round((double)possibleLeaders/2);
        System.out.println(finalAns);

    }
}
