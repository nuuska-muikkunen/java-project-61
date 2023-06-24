package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {

    public static final int AMOUNTS_OF_ATTEMPTS = 3;
    public static final int UPPER_BOUND = 100;

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void askQuestions(String gamerName) {
        int randomNumberToAsk;
        int countCorrectAnswers = 0;
        String correctAnswer = "";
        String gamerAnswer = "";
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (countCorrectAnswers < AMOUNTS_OF_ATTEMPTS && gamerAnswer.equals(correctAnswer)) {
            randomNumberToAsk = Engine.generateNumber(0, UPPER_BOUND);
            correctAnswer = isPrime(randomNumberToAsk) ? "yes" : "no";
            System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
            countCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countCorrectAnswers, AMOUNTS_OF_ATTEMPTS, gamerName);
        }
    }
}
