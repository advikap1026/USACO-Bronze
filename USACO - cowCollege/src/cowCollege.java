import java.util.*;
import java.io.*;
public class cowCollege {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int[] amtPays = new int[n];
        int finalPay = 0;
        for (int i = 0; i < n; i++) {
            amtPays[i] = input.nextInt();
            //input.next();
           // System.out.println("amt pays at " + i + " "+ amtPays[i]);
        }
        //ArrayList<Integer> amtToPayArr = new ArrayList<>();
        /*int[] amtToPayArr = new int[n];
        for(int i = 0; i<n; i++){
            amtToPayArr[i] = 0;
        }*/
        int count = 0;
        int maxPays = 0;

        for(int i = 0; i<n; i++){

            int amtToPay = amtPays[i];
            int totalPay = 0;

            //System.out.println("max pay: " + maxPays);
            for(int j = 0; j<n; j++){
                //System.out.println("num on " + amtPays[i]);
               // System.out.println("cow on " + amtPays[j]);
                if( amtToPay <= amtPays[j]){
                    //System.out.println("Coming here");

                    totalPay += amtToPay;
                    //System.out.println("Total Pay: " + totalPay);

                }

            }
            if(totalPay>=maxPays){

                if(totalPay == maxPays){
                    if(amtToPay < finalPay){
                        finalPay = amtToPay;
                    }
                    else{
                        finalPay = finalPay;
                    }

                }
                else{
                    finalPay = amtToPay;
                }

                maxPays = totalPay;

            }


        }

        System.out.println(maxPays + " " + finalPay);

    }
}
