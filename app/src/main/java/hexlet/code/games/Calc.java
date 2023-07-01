package hexlet.code.games;
import hexlet.code.Utils;
import hexlet.code.Engine;
public class Calc {
    public static final int UPPER_BOUND_OF_INTERVAL = 100;
    public static final int MAX_EXPECTED_POSSIBLE_RESULT_PLUS_ONE = 10001;
    public static final int LOW_BOUND_OF_INTERVAL = 0;
    public static final int AMOUNT_OF_QUESTIONS = 3;
    public static int calculation(int firstArgument, int secondArgument, String operation) {
        switch (operation) {
            case "+":
                return firstArgument + secondArgument;
            case "-":
                return firstArgument - secondArgument;
            case "*":
                return firstArgument * secondArgument;
            default:
                return MAX_EXPECTED_POSSIBLE_RESULT_PLUS_ONE; //exceeds maximum expected possible result of calculation
        }
    }
    public static String[] generateQuestion() {
        String[] operationsList = {"+", "-", "*"};
        int amountOfOperations = operationsList.length;
        int firstArgument;
        int secondArgument;
        int operationIndex;
        String[] questionsAndAnswers = new String[2];
        operationIndex = Utils.generateNumber(0, amountOfOperations - 1);
        firstArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        secondArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        questionsAndAnswers[0] = String.format("Question: %d %s %d \nYou answer: ",
                                               firstArgument, operationsList[operationIndex], secondArgument);
        questionsAndAnswers[1] = String.valueOf(calculation(firstArgument, secondArgument,
                                                 operationsList[operationIndex]));
        return questionsAndAnswers;
    }
    public static void askQuestions(String gamerName) {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_QUESTIONS][2];
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, gamerName);
    }
}
