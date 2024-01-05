package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.AMOUNT_OF_ATTEMPTS;

public class Gcd {
    public static final int UPPER_BOUND_OF_INTERVAL = 100;
    public static final int LOW_BOUND_OF_INTERVAL = 0;
    public static final String GAME_RULES = "Find the greatest common divisor of given numbers.";
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static String[] roundData() {
        String[] questionsAndAnswers = new String[2];
        int firstArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        int secondArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        questionsAndAnswers[0] = String.format("%d %d", firstArgument, secondArgument);
        questionsAndAnswers[1] = String.valueOf(gcd(firstArgument, secondArgument));
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
