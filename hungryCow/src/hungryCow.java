import java.util.*;
import java.io.*;
public class hungryCow {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int numDelivDays = input.nextInt();
        //System.out.println("deliv days: " + numDelivDays);
        long totalDays = input.nextLong();
       //System.out.println("total days: " + totalDays);
        long[][] delivDays = new long[numDelivDays][2];
        //System.out.println("delivDays: ");
        for(int i = 0; i<delivDays.length; i++){
            if(i > totalDays){
                break;
            }
            delivDays[i][0] = input.nextLong();
            delivDays[i][1] = input.nextLong();
           // System.out.println(delivDays[i][0] + " " +delivDays[i][1] );
        }

        long day = 1;
        int delivDayInd = 0;
        long finalAns = 0;
        long totalBarrals = 0;

        for(long i = 0; i<totalDays; i++){
            //System.out.println("deliv day ind: " + delivDayInd);
            //System.out.println("day today: " + day);

            if(delivDayInd != delivDays.length) {
                if (day == delivDays[delivDayInd][0]) {
                    //System.out.println("adding barrals ");
                    totalBarrals += delivDays[delivDayInd][1];
                    delivDayInd++;

                }
            }
            //System.out.println("total barrals: " + totalBarrals);
            if(totalBarrals >= totalDays - day + 1){
                //System.out.println("in shortcut - days left: " + (totalDays - day + 1) );

                finalAns += (totalDays- day + 1);
                break;
            }
            if(totalBarrals > 0){
                totalBarrals -= 1;
                finalAns++;
            }

           // System.out.println("final ans: " + finalAns);
            day++;
        }

        System.out.println(finalAns);

    }
}
