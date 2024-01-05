package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.AMOUNT_OF_ATTEMPTS;
public class Prime {
    public static final int UPPER_BOUND = 100;
    public static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static String[] roundData() {
        String[] questionsAndAnswers = new String[2];
        int randomNumberToAsk = Utils.generateNumber(-UPPER_BOUND, UPPER_BOUND);
        questionsAndAnswers[0] = String.format("%d", randomNumberToAsk);
        questionsAndAnswers[1] = isPrime(randomNumberToAsk) ? "yes" : "no";
        return questionsAndAnswers;
    }
    public static void askQuestions(String gamerName) {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_ATTEMPTS][2];
        for (int i = 0; i < AMOUNT_OF_ATTEMPTS; i++) {
            questionsAndCorrectAnswers[i] = roundData();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, GAME_RULES, gamerName);
    }
}
