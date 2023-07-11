package hexlet.code.games;
import hexlet.code.Utils;
import hexlet.code.Engine;

import static hexlet.code.Engine.AMOUNT_OF_ATTEMPTS;

public class Calc {
    public static final int UPPER_BOUND_OF_INTERVAL = 100;
    public static final int LOW_BOUND_OF_INTERVAL = 0;
    public static final String[] OPERATIONS = new String[]{"+", "-", "*"};
    public static final String GAME_RULES = "What is the result of the expression?";
    public static int calculation(int firstArgument, int secondArgument, String operation) throws RuntimeException {
        switch (operation) {
            case "+":
                return firstArgument + secondArgument;
            case "-":
                return firstArgument - secondArgument;
            case "*":
                return firstArgument * secondArgument;
            default:
                throw new RuntimeException("no such operation!");
        }
    }
    public static String[] generateQuestion() {
        int amountOfOperations = OPERATIONS.length;
        String[] questionsAndAnswers = new String[2];
        int operationIndex = Utils.generateNumber(0, amountOfOperations - 1);
        int firstArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        int secondArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        questionsAndAnswers[0] = String.format("%d %s %d",
                                               firstArgument, OPERATIONS[operationIndex], secondArgument);
        questionsAndAnswers[1] = String.valueOf(calculation(firstArgument, secondArgument,
                                                 OPERATIONS[operationIndex]));
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
