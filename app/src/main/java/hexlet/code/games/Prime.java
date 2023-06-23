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
        int amountsOfAttempts = 3;
        int upperBound = 100;
        int randomNumberToAsk;
        int countCorrectAnswers = 0;
        String correctAnswer = "";
        String gamerAnswer = "";
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (countCorrectAnswers < amountsOfAttempts && gamerAnswer.equals(correctAnswer)) {
            randomNumberToAsk = Engine.generateNumber(0, upperBound);
            correctAnswer = isPrime(randomNumberToAsk) ? "yes" : "no";
            System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
            countCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countCorrectAnswers, amountsOfAttempts, gamerName);
        }
    }
}
