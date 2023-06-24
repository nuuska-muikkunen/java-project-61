package hexlet.code.games;

import hexlet.code.Engine;
public class Gcd {

    public static final int AMOUNT_OF_ATTEMPTS = 3;
    public static final int UPPER_BOUND_OF_INTERVAL = 100;

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int lowBoundOfInterval = 0;
        String correctAnswer = "";
        String gamerAnswer = "";
        int firstArgument;
        int secondArgument;
        System.out.println("Find the greatest common divisor of given numbers.");
        while (countsCorrectAnswers < AMOUNT_OF_ATTEMPTS && gamerAnswer.equals(correctAnswer)) {
            firstArgument = Engine.generateNumber(lowBoundOfInterval, UPPER_BOUND_OF_INTERVAL);
            secondArgument = Engine.generateNumber(lowBoundOfInterval, UPPER_BOUND_OF_INTERVAL);
            correctAnswer = String.valueOf(gcd(firstArgument, secondArgument));
            System.out.print("Question: " + firstArgument + " " + secondArgument + "\nYou answer: ");
            countsCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, AMOUNT_OF_ATTEMPTS, gamerName);
        }
    }
}
