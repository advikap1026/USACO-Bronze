import java.util.*;
import java.io.*;
public class stampGrid {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int numTestCases = Integer.parseInt(input.nextLine());

        String[] answers = new String[numTestCases];
        for(int cases = 0; cases<numTestCases; cases++) {
            input.nextLine();

            int desiredCanvasGridNum = Integer.parseInt(input.nextLine());
            //System.out.println("desired canvas size : " + desiredCanvasGridNum);

            char[][] desiredCanvas = new char[desiredCanvasGridNum][desiredCanvasGridNum];
            for (int i = 0; i < desiredCanvasGridNum; i++) {

                String line = input.nextLine();
                //System.out.println("line: " + line);
                desiredCanvas[i] = line.toCharArray();
                //System.out.println("Desired Canvas Input " + i + " = " + Arrays.toString(desiredCanvas[i]));
            }


            int stampGridNum = Integer.parseInt(input.nextLine());
            //System.out.println ("Stamp Grid Size = " + stampGridNum);
            char[][] stamp = new char[stampGridNum][stampGridNum];
            for (int i = 0; i < stampGridNum; i++) {
                //System.out.println("line: " + line);
                stamp[i] = input.nextLine().toCharArray();
                //System.out.println("Stamp Grid Input " + i + " = " + Arrays.toString(stamp[i]));
            }
            //System.out.println();

            char[][] workingCanvas = new char[desiredCanvasGridNum][desiredCanvasGridNum];
            for(int i = 0; i<desiredCanvasGridNum; i++){
                for(int j = 0; j<desiredCanvasGridNum; j++){
                    workingCanvas[i][j] = '.';
                }
            }

            //starting the problem
            for (int l = 0; l < desiredCanvasGridNum; l++) {
                //System.out.println("desired canvas check avail");
                for (int m = 0; m < stampGridNum; m++) {
                    //System.out.println("stamp grid check avail");
                    if (l + stampGridNum < desiredCanvasGridNum && m + stampGridNum < desiredCanvasGridNum) {
                        //System.out.println("stamp fits");
                        for (int bI = 1; bI <= (desiredCanvasGridNum - stampGridNum + 1); bI++) {
                            //System.out.println("walking through bessie's i ");

                            for (int bJ = 1; bJ <= (desiredCanvasGridNum - stampGridNum + 1); bJ++) {
                                //System.out.println("walking through bessie's j ");

                                for (int _i = 1; _i <= stampGridNum; _i++) {
                                    for (int _j = 1; _j <= stampGridNum; _j++) {
                                        //System.out.println("walking through bessiess  i and j");
                                        int workCanvasI = bI + _i - 1;
                                        int workCanvasJ = bJ + _j - 1;

                                        char[][] rotatingStamp = new char[stampGridNum][stampGridNum];
                                        //System.out.println("Print Default rotating stamp");
                                        for (int i = 0; i < stampGridNum; i++) {
                                           // System.out.println();
                                            for (int j = 0; j < stampGridNum; j++) {
                                                rotatingStamp[i][j] = stamp[i][j];
                                               // System.out.print("[" + rotatingStamp[i][j] + "]");
                                            }
                                        }
                                       // System.out.println();

                                        for (int rotate = 0; rotate < 4; rotate++) {
                                            //System.out.println("in rotating loop");

                                            if (rotate != 0) { // 90 degrees
                                                for (int i = 0; i < stampGridNum / 2; i++) {
                                                    for (int j = i; j < stampGridNum - i - 1; j++) {

                                                        // Swap elements of each cycle
                                                        // in clockwise direction
                                                        char temp = rotatingStamp[i][j];
                                                        rotatingStamp[i][j] = rotatingStamp[stampGridNum - 1 - j][i];
                                                        rotatingStamp[stampGridNum - 1 - j][i] = rotatingStamp[stampGridNum - 1 - i][stampGridNum - 1 - j];
                                                        rotatingStamp[stampGridNum - 1 - i][stampGridNum - 1 - j] = rotatingStamp[j][stampGridNum - 1 - i];
                                                        rotatingStamp[j][stampGridNum - 1 - i] = temp;
                                                    }
                                                }
                                            } //after rotate

                                           // System.out.println("Rotate Number " + rotate );
                                            for (int i = 0; i < stampGridNum; i++) {
                                                //System.out.println();
                                                for (int j = 0; j < stampGridNum; j++) {
                                                    //System.out.print("[" + rotatingStamp[i][j] + "]");
                                                }
                                            }
                                            //System.out.println();

                                            //System.out.println("Print Variables _i-1=" + (_i-1) + " _j-1=" + (_j-1) + " workCanvasI-1=" + (workCanvasI-1) + " workCanvasJ-1=" + (workCanvasJ-1));

                                            //update desired canvas
                                            if ((rotatingStamp[_i-1][_j-1] == '*') && desiredCanvas[workCanvasI-1][workCanvasJ-1] == '*') {
                                                workingCanvas[workCanvasI-1][workCanvasJ-1] = '*';
                                            }
                                            //print working canvas
                                            //System.out.println("Printing Working Canvas");
                                            for (int i = 0; i < desiredCanvasGridNum; i++) {
                                                //System.out.println();
                                                for (int j = 0; j < desiredCanvasGridNum; j++) {
                                                    //System.out.print("[" + workingCanvas[i][j] + "]");
                                                }
                                            }
                                           // System.out.println();

                                        } // rotate end

                                    }

                                }
                            }
                        }
                    }
                }
            }//end of calculation
           answers[cases] = "YES";
            for(int i = 0; i<desiredCanvasGridNum; i++){
               // System.out.println();
                for(int j = 0; j< desiredCanvasGridNum; j++){
                   // System.out.print("[" + desiredCanvas[i][j] + ":" + workingCanvas[i][j] + "] ");

                    if(desiredCanvas[i][j] != workingCanvas[i][j]){
                        answers[cases] = "NO";
                        //break;
                    }
                }
            }

        } // end of num cases
        for(int i = 0; i<numTestCases; i++){
            System.out.println(answers[i]);
        }
    }
}
