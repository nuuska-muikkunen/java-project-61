package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class Even {
    public static final int UPPER_BOUND_OF_INTERVAL = 100;
    public static final int LOW_BOUND_OF_INTERVAL = 0;
    public static final int AMOUNT_OF_QUESTIONS = 3;
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    public static String[] generateQuestion() {
        String[] questionsAndAnswers = new String[2];
        int randomNumberToAsk = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        questionsAndAnswers[0] = String.format("%d", randomNumberToAsk);
        questionsAndAnswers[1] = isEven(randomNumberToAsk) ? "yes" : "no";
        return questionsAndAnswers;
    }
    public static void askQuestions() {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_QUESTIONS][2];
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers,
                    "Answer 'yes' if the number is even, otherwise answer 'no'.");

    }
}
