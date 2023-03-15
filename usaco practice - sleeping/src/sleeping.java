import java.util.*;
import java.io.*;
public class sleeping {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for(int cases = 0; cases < numCases; cases++) {
            int numClasses = input.nextInt();
            ArrayList<Integer> classes = new ArrayList<Integer>();
            for (int i = 0; i < numClasses; i++) {
                classes.add(input.nextInt());
            }
            int ans = 0;
            boolean isEqual = false;
            while (!isEqual) {
                //System.out.println("coming here");
                int count = 0;
                // finding max
                int max = classes.get(0);
                for (int i = 0; i < classes.size(); i++) {
                    if (classes.get(i) > max) {
                        max = classes.get(i);
                    }
                }
                //System.out.println("max: " + max);
                for (int i = 0; i < classes.size() - 1; i++) {
                    //System.out.println(i + " " + (i+1));
                    if (i + 1 > classes.size() - 1) {
                        break;
                    }
                    //System.out.println(classes);


                    if ((classes.get(i) < max && classes.get(i + 1) < max) || (classes.size() == 2 && classes.get(0) != classes.get(1))) {
                        ans++;
                        count++;
                        int temp = classes.get(i);
                        classes.set(i, temp + classes.get(i + 1));
                        classes.remove(i + 1);
                    }
                }
                if (count == 0) {
                    isEqual = true;
                }
            }
            System.out.println(ans);
        }
    }
}
