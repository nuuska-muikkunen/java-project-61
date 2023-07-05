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
        String[] questionsAndAnswers = new String[2];
        int randomNumberToAsk = Utils.generateNumber(0, UPPER_BOUND);
        questionsAndAnswers[0] = String.format("%d", randomNumberToAsk);
        questionsAndAnswers[1] = isPrime(randomNumberToAsk) ? "yes" : "no";
        return questionsAndAnswers;
    }
    public static void askQuestions() {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_QUESTIONS][2];
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers,
                     "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }
}
