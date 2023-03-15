import java.util.*;
import java.io.*;
public class drought {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for(int cases = 0; cases < numCases; cases++) {
            int nums = input.nextInt();
            long[] cows = new long[nums];
            for (int i = 0; i < nums; i++) {
                cows[i] = input.nextLong();
                //System.out.println(cows[i]);
            }
            long ans = 0;
            boolean isEqual = false;
            while (!isEqual) {
                int count = 0;
                long min = cows[0];
                for (int j = 0; j < cows.length; j++) {
                    if (cows[j] < min) {
                        min = cows[j];
                    }

                }
                //System.out.println("Min = " + min   );
                //System.out.println("Before : " + Arrays.toString(cows));

                for (int i = 0; i < cows.length - 1; i++) {
                    //find the min in the whole arr
                    /*System.out.println("i: " + i);
                    System.out.println("ind: " + i + ": " + cows[i]);
                    System.out.println("ind: " + (i + 1) + ": " + cows[i + 1]);*/



                    if (cows[i] <= min) {
                        //System.out.println("skip");
                        continue;
                    }
                    long prevValue = cows[i];
                    long diff = cows[i] - min;
                    cows[i] -= diff;
                    cows[i + 1] -= diff;
                    if (cows[i] < 0 || cows[i + 1] < 0) {
                        ans = -1;
                        isEqual = true;
                        break;
                    } else {
                        count++;
                        ans += (diff * 2);
                        //System.out.println("cows: " + cows[i] + " "+cows[i]);
                       /* System.out.println("diff: " + diff);
                        System.out.println("ans: " + ans);

                        System.out.println("after");
                        System.out.println("ind: " + i + ": " + cows[i]);
                        System.out.println("ind: " + (i + 1) + ": " + cows[i + 1]);
                        System.out.println();*/

                    }


                }
                if (count == 0) {
                    isEqual = true;
                }
               // System.out.println("After: " + Arrays.toString(cows));
              //  System.out.println("After Ans = " + ans);
            }
           /* System.out.println("end arr: ");
            for (int n = 0; n < cows.length; n++) {
                System.out.print(cows[n] + " ");
                System.out.println();
            }*/
            if(cows.length == 2 && cows[0] != cows[1]){
                System.out.println(-1);
            }
            else {
                System.out.println(ans);
            }
        }
    }
}
