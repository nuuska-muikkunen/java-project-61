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
        int randomNumberToAsk;
        String[] questionsAndAnswers = new String[2];
        randomNumberToAsk = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        questionsAndAnswers[0] = String.format("Question: %d \nYou answer: ", randomNumberToAsk);
        questionsAndAnswers[1] = isEven(randomNumberToAsk) ? "yes" : "no";
        //System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
        return questionsAndAnswers;
    }
    public static void askQuestions(String gamerName) {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_QUESTIONS][2];
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, gamerName);
    }
}
