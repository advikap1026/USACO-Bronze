import java.util.*;
import java.io.*;
public class airconditioning {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
       // System.out.println(10);
        int numCows = input.nextInt();
        int numCond = input.nextInt();
        int[][] cows = new int[numCows][3];
        int[][] cond = new int[numCond][4];

        for(int i = 0; i<numCows; i++){
            cows[i][0] = input.nextInt();
            cows[i][1] = input.nextInt();
            cows[i][2] = input.nextInt();
        }

        for(int i = 0; i<numCond; i++){
            cond[i][0] = input.nextInt();
            cond[i][1] = input.nextInt();
            cond[i][2] = input.nextInt();
            cond[i][3] = input.nextInt();
        }

        int[] stalls = new int[cows[numCows-1][1]];
        for(int i = 0; i<stalls.length; i++){
            stalls[i] = 0;
        }
        

    }
}
