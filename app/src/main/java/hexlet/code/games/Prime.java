package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.AMOUNT_OF_ATTEMPTS;
public class Prime {
    public static final int UPPER_BOUND = 100;
    public static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static boolean isPrime(int number) {
        if (number == 0) {
            return false;
        }
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
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_ATTEMPTS][2];
        for (int i = 0; i < AMOUNT_OF_ATTEMPTS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, GAME_RULES);
    }
}
