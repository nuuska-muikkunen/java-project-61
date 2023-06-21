package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;
public class Gcd {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void askQuestions(String gamerName) {
        // common games' parameters - varies by types
        Scanner answerReceiver = new Scanner(System.in);
        int countsCorrectAnswers = 0;
        int targetAmountOfAttempts = 3;
        int lowBoundOfInterval = 0;
        int upperBoundOfInterval = 100;
        int correctAnswer = 0;
        int gamerAnswer = 0;
        // specific games parameters
        int firstArgument;
        int secondArgument;
        // Specific question
        System.out.println("Find the greatest common divisor of given numbers.");
        while (countsCorrectAnswers < targetAmountOfAttempts && gamerAnswer == correctAnswer) {
            // generation of the random parameters
            firstArgument = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            secondArgument = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            // calculate correct answer for comparison and display question content for Gamer
            correctAnswer = gcd(firstArgument, secondArgument);
            System.out.print("Question: " + firstArgument + " " + secondArgument + "\nYou answer: ");
            // receive the answer from Gamer
            gamerAnswer = answerReceiver.nextInt();
            countsCorrectAnswers += 1;
            Engine.correctInformation(String.valueOf(gamerAnswer), String.valueOf(correctAnswer),
                    countsCorrectAnswers, gamerName);
        }
    }
}
