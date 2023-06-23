package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int amountOfAttempts = 3;
        int lowBoundOfInterval = 0;
        int upperBoundOfInterval = 100;
        int randomNumberToAsk;
        String correctAnswer = "";
        String gamerAnswer = "";
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (countsCorrectAnswers < amountOfAttempts && gamerAnswer.equals(correctAnswer)) {
            randomNumberToAsk = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            correctAnswer = isPrime(randomNumberToAsk) ? "yes" : "no";
            System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
            countsCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, amountOfAttempts, gamerName);
        }
    }
}
