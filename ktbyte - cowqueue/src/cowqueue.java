import java.util.*;
import java.io.*;

public class cowqueue {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("cowqueue.in"));
        int n = in.nextInt();
        in.nextLine();
        Cow[] cows = new Cow[n];
        for(int i = 0; i<n; i++){
            int arriveTime = in.nextInt();
            int dur = in.nextInt();
            Cow aCow = new Cow(arriveTime, dur);
            cows[i] = aCow;
        }

        Arrays.sort(cows);
       /* for(int i = 0; i<n; i++){
            System.out.println(cows[i]);
        }*/

        int result = 0;
        for(int i = 0; i<n; i++){
            if(cows[i].getArriveTime() < result){
                result += cows[i].getDuration();
            }
            else{
                result = cows[i].getArriveTime() + cows[i].getDuration();
            }
        }

        PrintWriter out = new PrintWriter(new File("cowqueue.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }

    static class Cow implements Comparable<Cow> {
        // TODO: add helpful instance variables here!
        public int arrivalTime;
        public int timeTook;
        // OPTIONAL: add a helpful constructor!
        public Cow(int arriveTime, int timeLength){
            arrivalTime = arriveTime;
            timeTook = timeLength;
        }
        public int getArriveTime(){
            return arrivalTime;
        }
        public int getDuration(){
            return timeTook;
        }
        public int compareTo(Cow other) {
            // TODO: return:

            //   x<0 if this should sort BEFORE the other
            if(other.getArriveTime() < arrivalTime){
                return 1;
            }
            //   x>0 if this should sort AFTER the other
            else if(other.getArriveTime() > arrivalTime){
                return -1;
            }
            //   0 if they are equivalent for sorting
            else{
                return 0;
            }
            // where x is any number meeting the condition
        }
        public String toString(){
            return "arrival time: " + arrivalTime + " duration: " + timeTook;
        }
    }
}