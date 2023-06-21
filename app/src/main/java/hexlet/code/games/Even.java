package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class Even {
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
            countsCorrectAnswers += 1;
            Engine.correctInformation(gamerAnswer, correctAnswer, countsCorrectAnswers, gamerName);
        }
    }
}
