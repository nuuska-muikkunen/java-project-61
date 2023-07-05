package hexlet.code.games;
import hexlet.code.Utils;
import hexlet.code.Engine;
public class Calc {
    public static final int UPPER_BOUND_OF_INTERVAL = 100;
    public static final int LOW_BOUND_OF_INTERVAL = 0;
    public static final int AMOUNT_OF_QUESTIONS = 3;
    public static final String[] OPERATIONS_LIST = new String[]{"+", "-", "*"};

    public static int calculation(int firstArgument, int secondArgument, String operation) {
        switch (operation) {
            case "+":
                return firstArgument + secondArgument;
            case "-":
                return firstArgument - secondArgument;
            case "*":
                return firstArgument * secondArgument;
            default:
                return firstArgument/0;
        }
    }
    public static String[] generateQuestion() {
        int amountOfOperations = OPERATIONS_LIST.length;
        String[] questionsAndAnswers = new String[2];
        int operationIndex = Utils.generateNumber(0, amountOfOperations - 1);
        int firstArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        int secondArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        questionsAndAnswers[0] = String.format("%d %s %d",
                                               firstArgument, OPERATIONS_LIST[operationIndex], secondArgument);
        questionsAndAnswers[1] = String.valueOf(calculation(firstArgument, secondArgument,
                                                 OPERATIONS_LIST[operationIndex]));
        return questionsAndAnswers;
    }
    public static void askQuestions() {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_QUESTIONS][2];
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, "What is the result of the expression?");
    }
}
