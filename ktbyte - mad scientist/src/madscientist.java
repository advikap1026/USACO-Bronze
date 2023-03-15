import java.util.*;
import java.io.*;
public class madscientist {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("breedflip.in"));
        int numCows = in.nextInt();
        in.nextLine();
        String want = in.nextLine();
        //System.out.println("want: " + want);
        String got = in.nextLine();
        //System.out.println("got: " + got);
        char[] wantArr = want.toCharArray();
        char[] gotArr = got.toCharArray();
        int result = 0;

        for(int i = 0; i<numCows; i++){
            char wantArrCow = wantArr[i];
            char gotArrCow = gotArr[i];

            int startInd;
            int endInd;

            //checking if need to flip
            //finding the range - start index
            if(wantArrCow != gotArrCow){
                startInd = i;
                endInd = startInd;

                //finding the end index
                for(int j = i+1; j<numCows; j++){
                    if(wantArr[j] != gotArr[j]){
                        endInd = j;
                    }
                    else{
                        break;
                    }
                }

                //looping through
                for(int k = startInd; k<=endInd; k++){
                    if(gotArr[k] == 'G'){
                        gotArr[k] = 'H';
                    }
                    else{
                        gotArr[k] = 'G';
                    }
                }
                result++;
                //System.out.println("start ind: " + startInd + " end ind: " + endInd);
                //System.out.println("res: " + result);
            }

        }


        PrintWriter out = new PrintWriter(new File("breedflip.out"));
        System.out.println(result);
        out.println(result);
        in.close();
        out.close();
    }
}
