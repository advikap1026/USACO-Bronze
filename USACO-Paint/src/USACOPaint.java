import java.util.*;
import java.io.*;
import java.lang.*;

public class USACOPaint {

    static final String FILE_NAME = "paint";

    public static void main (String[] args) throws FileNotFoundException {
        // INPUT
        int results;
        int[] john = new int[2];
        int[] bessie = new int[2];

        // TODO: Complete this section!

        Scanner in = new Scanner(new File(FILE_NAME + ".in"));

        for (int i = 0; i < 2; i++){
            john[i] = in.nextInt();
        }

        for (int j = 0; j < 2; j++){
            bessie[j]=in.nextInt();
        }
        in.close();
        //System.out.println("John's Array: " + john[0] + " " + john[1]);
        //System.out.println("Bessie's Array: " + bessie[0] + " " + bessie [1]);

        //Calculations
        int result;
        //System.out.println(john[0] + " " + bessie[0]);
        if(john[0] <= bessie[0] && bessie[0]<= john[1]
                || bessie[0] <= john[0] && john[0] <= bessie[1]
                || john[0] <= bessie[1] && bessie[1] <= john[1]
                || bessie[0] <= john[1] && john[1] <= bessie [1] ){
            int smallestNum = john[0];
            if(bessie[0]<smallestNum){
                //System.out.println("coming here");
                smallestNum = bessie[0];
            }
            int biggestNum = john[1];
            if(bessie[1]>biggestNum){
                biggestNum = bessie[1];
            }
            //System.out.println("Smallest num: " + smallestNum + "Biggest num: " + biggestNum);
            result = biggestNum - smallestNum;


        }
        else{
            result = (john[1] - john[0]) + (bessie[1] - bessie[0]);
        }
        PrintWriter out = new PrintWriter(new File(FILE_NAME + ".out"));
        out.println(result);
        System.out.println(result);
        out.close();
        //System.out.println(result);

    }


}


