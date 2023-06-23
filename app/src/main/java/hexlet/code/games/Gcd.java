package hexlet.code.games;

import hexlet.code.Engine;
public class Gcd {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int amountOfAttempts = 3;
        int lowBoundOfInterval = 0;
        int upperBoundOfInterval = 100;
        String correctAnswer = "";
        String gamerAnswer = "";
        int firstArgument;
        int secondArgument;
        System.out.println("Find the greatest common divisor of given numbers.");
        while (countsCorrectAnswers < amountOfAttempts && gamerAnswer.equals(correctAnswer)) {
            firstArgument = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            secondArgument = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            correctAnswer = String.valueOf(gcd(firstArgument, secondArgument));
            System.out.print("Question: " + firstArgument + " " + secondArgument + "\nYou answer: ");
            countsCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, amountOfAttempts, gamerName);
        }
    }
}
