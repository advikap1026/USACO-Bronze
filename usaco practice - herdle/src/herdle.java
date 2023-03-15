import java.util.*;
import java.io.*;
public class herdle {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        String ansFirstLine = input.nextLine();
        String ansSecondLine = input.nextLine();
        String ansThirdLine = input.nextLine();
        String correctAns = ansFirstLine + ansSecondLine + ansThirdLine;
        char[] answerArr = correctAns.toCharArray();
        boolean[] isAnsFilled = new boolean[9];
        for(int i = 0; i< 9; i++){
            isAnsFilled[i] = false;
        }

        String guessFirstLine = input.nextLine();
        String guessSecondLine = input.nextLine();
        String guessThirdLine = input.nextLine();
        String fullGuess = guessFirstLine + guessSecondLine + guessThirdLine;
        char[] guessArr = fullGuess.toCharArray();
        boolean[] isGuessFilled = new boolean[9];
        for(int i = 0; i< 9; i++){
            isGuessFilled[i] = false;
        }


        int numGreen = 0;
        int numYellow = 0;

        for(int i = 0; i<answerArr.length; i++){
            for(int j = 0; j<guessArr.length; j++){
               // System.out.println("i: " + i + " j: " + j);
                if(answerArr[i] == guessArr[j] && i == j && isAnsFilled[i] == false && !isGuessFilled[j]){
                    numGreen++;
                    isAnsFilled[i] = true;
                    isGuessFilled[j] = true;
                }
                /*if(answerArr[i] == guessArr[j] && i != j && isAnsFilled[i] == false){
                    numYellow++;
                }*/
                //System.out.println("numGreen: " + numGreen + " numYellow: " + numYellow);
                //System.out.println("isAnsFilled: " + isAnsFilled[i]);
            }
        }

        for(int i = 0; i<answerArr.length; i++){
            for(int j = 0; j<guessArr.length; j++){
                //System.out.println("i: " + i + " j: " + j);
                /*if(isAnsFilled[i] || isGuessFilled[j]){
                    break;
                }*/
                /*if(answerArr[i] == guessArr[j] && i == j && isAnsFilled[i] == false){
                    numGreen++;
                }*/
                if(answerArr[i] == guessArr[j] && i != j && isAnsFilled[i] == false && !isGuessFilled[j]){
                    numYellow++;
                    isAnsFilled[i] = true;
                    isGuessFilled[j] = true;
                   // System.out.println("comming in");
                }
                //System.out.println("numGreen: " + numGreen + " numYellow: " + numYellow);
                //System.out.println("isAnsFilled: " + isAnsFilled[i]);
            }
        }

        System.out.println(numGreen);
        System.out.println(numYellow);
    }
}
