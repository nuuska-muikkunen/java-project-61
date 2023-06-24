package hexlet.code.games;
import hexlet.code.Engine;
public class Calc {

    public static final int AMOUNT_OF_ATTEMPTS = 3;
    public static final int UPPER_BOUND_OF_INTERVAL = 100;

    public static int calculation(int firstArgument, int secondArgument, String operation) {
        switch (operation) {
            case "+":
                return firstArgument + secondArgument;
            case "-":
                return firstArgument - secondArgument;
            case "*":
                return firstArgument * secondArgument;
            default:
                return 10001; //exceeds maximum expected possible result of calculation
        }
    }
    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int lowBoundOfInterval = 0;
        String correctAnswer = "";
        String gamerAnswer = "";
        String[] operationsList = {"+", "-", "*"};
        int amountOfOperations = operationsList.length;
        int firstArgument;
        int secondArgument;
        int operationIndex;
        System.out.println("What is the result of the expression?");
        while (countsCorrectAnswers < AMOUNT_OF_ATTEMPTS && gamerAnswer.equals(correctAnswer)) {
            operationIndex = Engine.generateNumber(0, amountOfOperations - 1);
            firstArgument = Engine.generateNumber(lowBoundOfInterval, UPPER_BOUND_OF_INTERVAL);
            secondArgument = Engine.generateNumber(lowBoundOfInterval, UPPER_BOUND_OF_INTERVAL);
            correctAnswer = String.valueOf(calculation(firstArgument, secondArgument, operationsList[operationIndex]));
            System.out.print("Question: " + firstArgument + " " + operationsList[operationIndex]
                    + " " + secondArgument + "\nYou answer: ");
            countsCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, AMOUNT_OF_ATTEMPTS, gamerName);
        }
    }
}
