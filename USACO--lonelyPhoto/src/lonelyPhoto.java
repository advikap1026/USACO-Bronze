import java.util.*;
import java.io.*;
public class lonelyPhoto {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        //System.out.println(n);
        //System.out.println(line);
        int finalCount = 0;
        char[] cowArray = line.toCharArray();
        //size of group
        for (int groupSize = 3; groupSize <= cowArray.length; groupSize++) {
            char[] picDestGroup = new char[groupSize];

            for (int cowSrcIndex = 0; cowSrcIndex <= cowArray.length - groupSize; cowSrcIndex++) {

                for (int cowDestIndex = 0; cowDestIndex < groupSize; cowDestIndex++) {
                    picDestGroup[cowDestIndex] = cowArray[cowSrcIndex + cowDestIndex];

                   // System.out.println("picGroup arr at " + cowDestIndex + " : " +picDestGroup[cowDestIndex] );
                }
                //System.out.println("----");

                int numG = 0;
                int numH = 0;
                for (int thruDestGroup = 0; thruDestGroup < picDestGroup.length; thruDestGroup++) {

                    if (picDestGroup[thruDestGroup] == 'G') {
                        numG++;
                    } else if (picDestGroup[thruDestGroup] == 'H') {
                        numH++;
                    }
                }
                if (numG == 1 || numH == 1) {
                    finalCount++;
                }

                //System.out.println ("Group Size = " + groupSize + " Final Count = " + finalCount);
            }

        }
        System.out.println(finalCount);

    }
}

