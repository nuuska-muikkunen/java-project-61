package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

import static hexlet.code.Engine.AMOUNT_OF_ATTEMPTS;

public class Even {
    public static final int UPPER_BOUND_OF_INTERVAL = 100;
    public static final int LOW_BOUND_OF_INTERVAL = 0;
    public static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    public static String[] roundData() {
        String[] questionsAndAnswers = new String[2];
        int randomNumberToAsk = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        questionsAndAnswers[0] = String.format("%d", randomNumberToAsk);
        questionsAndAnswers[1] = isEven(randomNumberToAsk) ? "yes" : "no";
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
