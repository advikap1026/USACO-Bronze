import java.io.*;
import java.util.*;
public class outofplace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numLength = Integer.parseInt(st.nextToken());
        //System.out.println("length of array: " + numLength);
        int[] cows = new int[numLength];
        for(int i = 0; i<numLength; i++){
            cows[i] = Integer.parseInt(br.readLine()); //Integer.parseInt(st.nextToken());
           // System.out.println(cows[i]);
        }

        boolean isSorted = false;
        int count = 0;
        for(int i = 0; i< cows.length; i++){
            int minInd = i;
            for(int j = i+1; j<cows.length; j++){
                if(cows[i] > cows[j] && cows[j] <= cows[minInd]){
                        minInd = j;
                }
            }
            int temp = cows[minInd];
            cows[minInd] = cows[i];
            cows[i] = temp;
            //System.out.println("i: " + i + " minInd: " + minInd);
            if(minInd != i){
               count++;
            }
            //System.out.println("count: " + count);
        }


        pw.println(count);
        pw.close();
        System.out.println(count);

    }
}
