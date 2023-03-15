import java.util.*;
import java.io.*;
public class lonelyPhoto {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        long n = input.nextInt();
        input.nextLine();
        String cows = input.next();
        char[] cowArr = cows.toCharArray();
        long numG = 0;
        long numH = 0;
        long count = 0;
        for(int i = 0; i<cowArr.length; i++){
            numG = 0;
            numH = 0;
            /*if(cowArr[i] == 'G'){
                numG++;
            }
            else{
                numH++;
            }*/
            for(int j = i/*+1*/; j<cowArr.length; j++){

                if(cowArr[j] == 'G'){
                    numG++;
                }
                else{
                    numH++;
                }
                //System.out.println("i: " + i);
                //System.out.println("j = " + j + " G: " + numG + " h: " + numH);
                if(numG + numH >= 3 && (numG == 1 || numH == 1)){

                    count++;
                }
                //System.out.println("count: " + count);
                /*if(numG > 1 && numH >1){
                    break;
                }*/
            }
        }
        System.out.println(count);
    }
}
