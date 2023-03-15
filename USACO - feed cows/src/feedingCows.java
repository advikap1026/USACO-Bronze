import java.util.*;
import java.io.*;
public class feedingCows {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        //for(int i = 0; i<numCases; i++){
            int numCows = scanner.nextInt();
            int numMoves = scanner.nextInt();
            scanner.nextLine();
            String cowLine = scanner.nextLine();
            char[] charCows = cowLine.toCharArray();
            int numG = 0;
            int numH = 0;
            for(int j = 0; j< charCows.length; j++){
                if(charCows[j] == 'G'){
                    numG ++;
                }
                if(charCows[j] == 'H'){
                    numH ++;
                }
            }
            int[] gCowIndex = new int[numG];
            int gCount = 0;
            int[] hCowIndex = new int[numH];
            int hCount = 0;
            for(int j = 0; j<charCows.length; j++){

                if(charCows[j] == 'G'){
                    gCowIndex[gCount] = j;
                    gCount++;
                }
                if(charCows[j] == 'H'){
                    hCowIndex[hCount] = j;
                    hCount++;
                }
            }
            boolean[][] availForG = new boolean[numG][numCows];
            boolean[][] availForH = new boolean[numH][numCows];
            //inintialize G to false
            for(int j = 0; j<availForG.length; j++){
                for(int k = 0; k<availForG[0].length; k++){
                    availForG[j][k] = false;
                }
            }
            //initilize H to false
            for(int j = 0; j<availForH.length; j++){
                for(int k = 0; k<availForH[0].length; k++){
                    availForH[j][k] = false;
                }
            }

            //checking avail for G
            for(int j = 0; j<gCowIndex.length; j++){
                    availForG[j][gCowIndex[j]] = true;
                    //moving up
                    int colIndUp = gCowIndex[j];
                    for(int l = 1; l<=numMoves; l++){
                         colIndUp++;
                        if(colIndUp < numCows){
                            availForG[j][colIndUp] = true;
                        }
                    }
                    //moving down
                    int colIndDown = gCowIndex[j];
                    for(int l = 1; l<=numMoves; l++){
                        colIndDown--;
                        if(colIndDown >= 0){
                            availForG[j][colIndDown] = true;
                        }
                    }
            }

            //checking avail for H
        for(int j = 0; j<hCowIndex.length; j++){
                System.out.println("H cow index " + hCowIndex[j]);
                availForH[j][hCowIndex[j]] = true;
                //moving up
                int colIndUp = hCowIndex[j];
                for(int l = 1; l<=numMoves; l++){
                    colIndUp++;
                    if(colIndUp < numCows){
                        availForH[j][colIndUp] = true;
                        System.out.println ("Marking true for H at " + colIndUp);
                    }
                }
                //moving down
                int colIndDown = hCowIndex[j];
                for(int l = 1; l<=numMoves; l++){
                    colIndDown--;
                    if(colIndDown >= 0){
                        availForH[j][colIndDown] = true;
                        System.out.println ("Marking true for H at " + colIndDown);

                    }
                }
        }
        System.out.println("g doub arr avail");
        for(int j = 0; j<availForG.length; j++){
            for(int k = 0; k<availForG[0].length; k++){
                System.out.print(availForG[j][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("h doub arr avail");
        for(int j = 0; j<availForH.length; j++){
            for(int k = 0; k<availForH[0].length; k++){
                System.out.print(availForH[j][k] + " ");
            }
            System.out.println();
        }

        //count how many avail G
        int[] numAvailG = new int[numCows];
        for(int l = 0; l<numCows; l++){
            int num = 0;
            for(int k = 0; k<gCowIndex.length; k++){
                if(availForG[k][l] == true){
                    num ++;
                }
            }
            numAvailG[l] = num;
            System.out.print(" " + num + " ");

        }
        System.out.println();
        //count how many avail H
        int[] numAvailH = new int[numCows];

        for(int l = 0; l<numCows; l++){
            int num = 0;
            for(int k = 0; k<hCowIndex.length; k++){
                if(availForG[k][l] == true){
                    num ++;
                }
            }
            numAvailH[l] = num;
            System.out.print(" " + num + " ");
        }





       // }
    }
}

            /*
            System.out.println("G cow index: ");
            for(int j = 0; j<gCowIndex.length; j++){
            }
        System.out.println("H cow index: ");
        for(int j = 0; j<hCowIndex.length; j++){
            System.out.println(hCowIndex[j]);
        }
        System.out.println("g doub arr avail");
        for(int j = 0; j<availForG.length; j++){
            for(int k = 0; k<availForG[0].length; k++){
                System.out.println(availForG[j][k]);
            }
        }
        System.out.println("h doub arr avail");
        for(int j = 0; j<availForH.length; j++){
            for(int k = 0; k<availForH[0].length; k++){
                System.out.println(availForH[j][k]);
            }
        }      System.out.println(gCowIndex[j]);*/
