import java.util.*;
import java.io.*;
public class feedCows {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        input.nextLine();
        for(int i = 0; i<numCases; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            input.nextLine();
            String cowStr = input.nextLine();
            char[] cows = cowStr.toCharArray();
            int lastG = -k - 1;
            int lastH = -k - 1;
            char[] finalArr = new char[cows.length];
            for(int j = 0; j<cows.length; j++){
                finalArr[j] = '.';
            }
           // System.out.println(finalArr);
            int amtPatches = 0;
            for (int j = k; j < n; j++) {
                if(cows[j-k] == 'G'){
                    if((j-k)-lastG > k){
                        amtPatches++;
                        finalArr[j] = 'G';
                        lastG = j;
                    }
                }
                else{
                    if((j-k)-lastH>k){
                        amtPatches++;
                        finalArr[j] = 'H';
                        lastH = j;
                    }
                }
                //System.out.println(finalArr);
            }
            boolean isaG = false;
            for(int j = n-1; j>=0; j--){

                if(cows[j] == 'G' && j - lastG > k){
                    isaG = true;
                }
            }
            if(isaG) {
                for (int j = n - 1; j >= 0; j--) {
                    if (finalArr[j] == '.') {
                        finalArr[j] = 'G';
                        amtPatches++;
                        break;
                        //lastG = j;
                    }
                }
            }
            boolean isaH = false;
            for(int j = n-1; j>=0; j--){

                if(cows[j] == 'H' && j - lastH > k){
                    isaH = true;
                }
            }
            if(isaH) {
                for (int j = n - 1; j >= 0; j--) {
                    if (finalArr[j] == '.') {
                        finalArr[j] = 'H';
                        amtPatches++;
                        break;
                        //lastH = j;
                    }
                }
            }
            System.out.println(amtPatches);
            System.out.println(finalArr);
        }
    }
}


