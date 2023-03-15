import java.util.*;
import java.io.*;

public class swap {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("swap.in"));
        int numCows = in.nextInt();
        int repeatProcess = in.nextInt();
        int[] cows = new int[numCows];
        int count = 1;
        //System.out.println("arr: ");
        for (int i = 0; i < numCows; i++) {
            cows[i] = count;
            //System.out.print(cows[i]);
            count++;
        }
        int startSwap1 = in.nextInt();
        int endSwap1 = in.nextInt();

        int startSwap2 = in.nextInt();
        int endSwap2 = in.nextInt();

        for(int i = 0; i<repeatProcess; i++){

            //start swapping
            //first step
            //System.out.println("first step");
            int[] endArr = Arrays.copyOf(cows, numCows);
            //System.out.println("end Arr initialization: " + Arrays.toString(endArr));
            int num = endSwap1;

            for(int j = startSwap1-1; j<=endSwap1-1; j++){
                /*System.out.println("end arr index: " + (num-1));
                System.out.println("j: " + j);
                System.out.println("end arr at index: " + endArr[num-1]);
                System.out.println("cows at j " + cows[j]);*/
                endArr[num-1] = cows[j];
               // endArr[j] = cows[num-1];
                num -= 1;
                //System.out.println("end arr after loop: " + Arrays.toString(endArr));
            }
           // System.out.println("end arr after set: " + Arrays.toString(endArr));

            cows = Arrays.copyOf(endArr, numCows);
            //System.out.println("cows copied: " + Arrays.toString(cows));

            //second step
            endArr = Arrays.copyOf(cows, numCows);
            num = endSwap2;
            for(int j = startSwap2 -1; j<=endSwap2-1; j++){
                endArr[num-1] = cows[j];
                num -= 1;
            }

            cows = Arrays.copyOf(endArr, numCows);

        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        for(int i = 0; i<cows.length; i++){
            pw.println(cows[i]);
            System.out.println(cows[i]);
        }
        pw.close();

    }
}
