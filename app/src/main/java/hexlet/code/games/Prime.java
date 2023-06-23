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
        int countCorrectAnswers = 0;
        int amountOfAttempts = 3;
        int lowIntervalBound = 0;
        int upperIntervalBound = 100;
        int randomNumberToAsk;
        String correctAnswer = "";
        String gamerAnswer = "";
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (countCorrectAnswers < amountOfAttempts && gamerAnswer.equals(correctAnswer)) {
            randomNumberToAsk = Engine.generateNumber(lowIntervalBound, upperIntervalBound);
            correctAnswer = isPrime(randomNumberToAsk) ? "yes" : "no";
            System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
            countCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countCorrectAnswers, amountOfAttempts, gamerName);
        }
    }
}
