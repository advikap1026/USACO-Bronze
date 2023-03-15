import java.util.*;
import java.io.*;
public class cowCollege {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        long[] amtPays = new long[n];
        long finalPay = 0;
        for (int i = 0; i < n; i++) {
            amtPays[i] = input.nextLong();
            //input.next();
            // System.out.println("amt pays at " + i + " "+ amtPays[i]);
        }

        Arrays.sort(amtPays);
        /*for(int i = 0; i<amtPays.length; i++){
            System.out.println(amtPays[i]);
        }*/
        long maxTotal = 0;
        long amtToPay = 0;
        for(int i = 0; i<amtPays.length; i++){
            long currentTotal = amtPays[i] * (amtPays.length - i);
            if(currentTotal > maxTotal){
                maxTotal = currentTotal;
                amtToPay = amtPays[i];
            }
            else if(currentTotal == maxTotal){
                if(amtToPay > amtPays[i]){
                    amtToPay = amtPays[i];
                }
            }
        }
        System.out.println(maxTotal + " " + amtToPay);

    }
}
