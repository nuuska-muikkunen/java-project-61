package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class EvenGame {
    // returns "true" if the argument is even number, otherwise return "false"
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    // main cycle of the questions to the Gamer
    // until target amount of the consecutive correct answers achieved or the incorrect answer is given
    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int targetAmountOfAttempts = 3;
        int lowBoundOfInterval = 0;
        int upperBoundOfInterval = 100;
        int randomNumberToAsk;
        String correctAnswer = "";
        String gamerAnswer = "";
        Scanner answerReceiver = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (countsCorrectAnswers < targetAmountOfAttempts && gamerAnswer.equals(correctAnswer)) {
            randomNumberToAsk = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            correctAnswer = isEven(randomNumberToAsk) ? "yes" : "no";
            System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
            gamerAnswer = answerReceiver.next();
            if (gamerAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                countsCorrectAnswers += 1;
                if (countsCorrectAnswers == targetAmountOfAttempts) {
                    System.out.println("Congratulations, " + gamerName + "!");
                }
            } else {
                System.out.println(String.format("'%d' is wrong answer ;(. " + "Correct answer was '%d'.\n"
                                               + "Let's try again %s!", gamerAnswer, correctAnswer, gamerName));
            }
        }
    }
}
