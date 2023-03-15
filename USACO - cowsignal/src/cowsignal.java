import java.util.*;
import java.io.*;
public class cowsignal {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(new File("cowsignal.in"));

        //reading original array and storing it
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        char[][] grid = new char[m][n];
        for(int i = 0; i<m; i++){
            grid[i] = in.next().toCharArray();
            System.out.println(grid[i]);

        }

        //make new array
        char[][] finalArr = new char[m*k][n*k];
        int rowCount = m;
        int colCount = n;
        int count = 0;

        for(int i = 0; i<m*k; i=i+k){
            for(int j = 0; j<n*k; j=j+k){

                for(int l = 0; l<k; l++){
                    for(int p = 0; p<k; p++){
                        finalArr[i+l][j+p] = grid[i/k][j/k];
                    }
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("cowsignal.out"));
        for(int i = (finalArr.length-1); i>=0; i--){
            out.println(finalArr[i]);
        }
        out.close();
        in.close();



    }
}
