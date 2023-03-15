import java.util.*;
import java.io.*;
public class balancing {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(new File("balancing.in"));
        int numCows = input.nextInt();
        //System.out.println("num cows: " + numCows);
        int gridLength = input.nextInt();
        //System.out.println("grid length: " + gridLength);
        int[] xCor = new int[numCows];
        int[] yCor = new int[numCows];
        for(int i = 0; i<numCows; i++){
            xCor[i] = input.nextInt();
            //System.out.print("xCor: " + xCor[i] + " ");
            yCor[i] = input.nextInt();
            //System.out.println("yCor: " + yCor[i]);
        }

        int ans = numCows;
        for(int xIndex = 0; xIndex < numCows; xIndex++) {
            for(int yIndex = 0; yIndex < numCows; yIndex++) {
                // identify the fence location
                // vertical fence at x=xDiv
                // horizontal fence at y=yDiv
                int xDiv = xCor[xIndex]+1;
                int yDiv = yCor[yIndex]+1;
                int upperLeft = 0;
                int upperRight = 0;
                int lowerLeft = 0;
                int lowerRight = 0;
                // identify which quadrant each cows lands in
                for(int i = 0; i < numCows; i++) {
                    if(xCor[i] < xDiv && yCor[i] < yDiv) {
                        lowerLeft++;
                    }
                    if(xCor[i] < xDiv && yCor[i] > yDiv) {
                        upperLeft++;
                    }
                    if(xCor[i] > xDiv && yCor[i] < yDiv) {
                        lowerRight++;
                    }
                    if(xCor[i] > xDiv && yCor[i] > yDiv) {
                        upperRight++;
                    }
                }
                // figure out which region has the most cows
                int worstRegion = 0;
                if(upperLeft > worstRegion) {
                    worstRegion = upperLeft;
                }
                if(upperRight > worstRegion) {
                    worstRegion = upperRight;
                }
                if(lowerLeft > worstRegion) {
                    worstRegion = lowerLeft;
                }
                if(lowerRight > worstRegion) {
                    worstRegion = lowerRight;
                }
                // determine if we have found a better pair of fences
                if(worstRegion < ans) {
                    ans = worstRegion;
                }
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("balancing.out"));
        out.println(ans);
        System.out.println(ans);
        out.close();
        input.close();
    }
}
