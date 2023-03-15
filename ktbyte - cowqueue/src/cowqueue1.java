import java.util.*;
import java.io.*;

public class cowqueue1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("cowqueue.in"));
        int n = in.nextInt();
        in.nextLine();
        int[] enterTime = new int[n];
        int[] enterTimeLoc = new int[n];
        int[] duration = new int[n];
        //initializing enter time
        for(int i = 0; i<n; i++){
            enterTime[i] = in.nextInt();
            enterTimeLoc[i] = enterTime[i];
            duration[i] = in.nextInt();
            //in.nextLine();

        }
        System.out.println();
        in.close();
        // TODO: use Arrays.sort() on the cows
        Arrays.sort(enterTime);
        int[] finalDuration = new int[n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(enterTime[i] == enterTimeLoc[j]){
                    finalDuration[i] = duration[j];
                    //System.out.println("enter: " + enterTime[i] + " duration: " + finalDuration[i]);
                }
            }
            /*System.out.println("Sorted arr: " + i + ": ");
            System.out.print(enterTime[i] + " ");
            System.out.println(finalDuration[i]);*/
        }
        int result = 0;
        int availTime = 0;
        for(int i = 0; i<n; i++){
            if(enterTime[i] < availTime){

                availTime += finalDuration[i];
            }
            else{
                availTime = enterTime[i] + finalDuration[i];
            }
            //System.out.println(i + " avail time: " + availTime);
        }
        result = availTime;
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
        public int compareTo(Cow other) {
            // TODO: return:

            //   x<0 if this should sort BEFORE the other
            if(other.getArriveTime() < arrivalTime){
                return -1;
            }
            //   x>0 if this should sort AFTER the other
            else if(other.getArriveTime() > arrivalTime){
                return 1;
            }
            //   0 if they are equivalent for sorting
            else{
                return 0;
            }
            // where x is any number meeting the condition
        }
    }
}