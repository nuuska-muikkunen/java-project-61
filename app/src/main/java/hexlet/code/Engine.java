package hexlet.code;

import java.util.Scanner;

public class Engine {
    // returns pseudorandom integer number between the bounds of the interval defined by the arguments
    public static int generateNumber(int lowBoundOfInterval, int upperBoundOfInterval) {
        return (int) Math.floor(Math.random() * (upperBoundOfInterval - lowBoundOfInterval + 1)) + lowBoundOfInterval;
    }

    public static String communicateGamer(String correctAnswer, int countsCorrectAnswers, int amountOfAttempts,
                                          String gamerName) {
        Scanner answerReceiver = new Scanner(System.in);
        String gamerAnswer = answerReceiver.next();
        if (gamerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            if (countsCorrectAnswers == amountOfAttempts) {
                System.out.println("Congratulations, " + gamerName + "!");
            }
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again %s!%n",
                    gamerAnswer, correctAnswer, gamerName);
        }
        return gamerAnswer;
    }
}
