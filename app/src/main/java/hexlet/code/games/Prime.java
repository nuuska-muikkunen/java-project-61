package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final int UPPER_BOUND = 100;
    public static final int AMOUNT_OF_QUESTIONS = 3;

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static String[] generateQuestion() {
        int randomNumberToAsk;
        String[] questionsAndAnswers = new String[2];
        randomNumberToAsk = Utils.generateNumber(0, UPPER_BOUND);
        questionsAndAnswers[0] = "Question: " + randomNumberToAsk + "\nYou answer: ";
        questionsAndAnswers[1] = isPrime(randomNumberToAsk) ? "yes" : "no";
        return questionsAndAnswers;
    }
    public static void askQuestions(String gamerName) {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_QUESTIONS][2];
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, gamerName);
    }
}
