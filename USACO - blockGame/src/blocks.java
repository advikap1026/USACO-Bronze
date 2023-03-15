import java.util.*;
import java.io.*;
public class blocks {
    public static void main(String[] args) throws Exception {


        Scanner in = new Scanner(new File("blocks.in"));
        int n = Integer.parseInt(in.nextLine());
        int[] finalCount = new int[26];
        for (int i = 0; i < 26; i++) {
            finalCount[i] = 0;
        }
        for (int i = 0; i < n; i++) {

            //read each line
            String line = in.nextLine();
            //split line into two words
            String[] words = line.split(" ", 2);

            //count first line
            char[] word1Arr = words[0].toCharArray();
            int[] word1Count = new int[26];
            for (int j = 0; j < 26; j++) {
                word1Count[j] = 0;
            }
            for (int k = 0; k < word1Arr.length; k++) {
                word1Count[(int) word1Arr[k] - 97]++;
            }

            //count second line
            //System.out.println("Words at 1: " + words[1]);
            char[] word2Arr = words[1].toCharArray();
            int[] word2Count = new int[26];
            for (int j = 0; j < 26; j++) {
                word2Count[j] = 0;
            }
            for (int k = 0; k < word2Arr.length; k++) {
                word2Count[(int) word2Arr[k] - 97]++;
            }

            //compare two words

            for (int a = 0  ; a < 26; a++) {
                if (word1Count[a] >= word2Count[a]) {
                    finalCount[a] += word1Count[a];
                } else {
                    finalCount[a] += word2Count[a];
                }
            }
        }
        in.close();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        //print the final array count
        for (int j = 0; j < 26; j++) {
            System.out.println(finalCount[j]);
            pw.println(finalCount[j]);
        }
        pw.close();

        for (int i = 0; i < 26; i++) {
            System.out.println(finalCount[i]);
        }

    }
}


