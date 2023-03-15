import java.util.*;
import java.io.*;

public class backforth {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("backforth.in"));
        PrintWriter out = new PrintWriter(new File("backforth.out"));

        int[] a = new int[10];
        int[] b = new int[11];
        for(int i = 0; i < 10; i++) {
            a[i] = in.nextInt();
        }
        for(int i = 0; i < 10; i++) {
            b[i] = in.nextInt();
        }

        //          t = 3
        // A: 1 1 1 1 1 1 1 1 1 2

        // lower bound of reading in A: 800
        // upper bound of reading in A: 1200

        // mark reading[x] as true when we encounter
        // a reading of x
        boolean[] readings = new boolean[1200];

        // t is the index chosen for Tuesday
        for(int t = 0; t < 10; t++) {
            b[10] = a[t];
            int T = a[t];

            for(int w = 0; w < 11; w++) {
                a[t] = b[w];
                int W = b[w];

                for(int h = 0; h < 10; h++) {
                    b[w] = a[h];
                    int H = a[h];

                    for(int f = 0; f < 11; f++) {
                        a[h] = b[f];
                        int F = b[f];

                        int reading = 1000 - T + W - H + F;
                        readings[reading] = true;

                        b[f] = a[h];
                    }
                    a[h] = b[w];
                }
                b[w] = a[t];
            }
            a[t] = b[10];
        }

        int answer = 0;
        for(boolean bb : readings) {
            if(bb) {
                answer++;
            }
        }

        out.println(answer);

        in.close();
        out.close();
    }
}