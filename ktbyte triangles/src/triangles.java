import java.util.*;
import java.io.*;
public class triangles {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("triangles.in"));
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i<n; i++){
            x[i] = in.nextInt();
            //System.out.println("x at " + i + ": " + x[i]);
            y[i] = in.nextInt();
            //System.out.println("y at " + i + ": " + y[i]);
        }
        /*System.out.println("x array: ");
        for(int i = 0; i<x.length; i++ ){
            System.out.print(x[i] + " ");
        }

        System.out.println("y array: ");
        for(int i = 0; i<y.length; i++){
            System.out.print(y[i] + " ");
        }
        System.out.println();*/
        in.close();

        int maxArea = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<n; k++){

                    if(y[i] == y[j] && x[i] == x[k]){
                        //System.out.println("p1: (" + x[i] + ", " + y[i]);
                        int area = Math.abs((x[j] - x[i]) * ((y[k] - y[i])));
                        if(area > maxArea){

                            maxArea = area;
                        }
                       // System.out.println("area: " + area);
                        //System.out.println("max area: " + maxArea);
                    }
                }
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        pw.println(maxArea);
        pw.close();
        System.out.println(maxArea);

    }
}

