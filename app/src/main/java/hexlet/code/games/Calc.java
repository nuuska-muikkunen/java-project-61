package hexlet.code.games;
import hexlet.code.Engine;
public class Calc {
    public static int calculation(int firstArgument, int secondArgument, String operation) {
        switch (operation) {
            case "+":
                return firstArgument + secondArgument;
            case "-":
                return firstArgument - secondArgument;
            case "*":
                return firstArgument * secondArgument;
            default:
                return -101;
        }
    }
    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int amountOfAttempts = 3;
        int lowBoundOfInterval = 0;
        int upperBoundOfInterval = 100;
        String correctAnswer = "";
        String gamerAnswer = "";
        String[] operationsList = {"+", "-", "*"};
        int amountOfOperations = operationsList.length;
        int firstArgument;
        int secondArgument;
        int operationIndex;
        System.out.println("What is the result of the expression?");
        while (countsCorrectAnswers < amountOfAttempts && gamerAnswer.equals(correctAnswer)) {
            operationIndex = Engine.generateNumber(0, amountOfOperations - 1);
            firstArgument = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            secondArgument = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            correctAnswer = String.valueOf(calculation(firstArgument, secondArgument, operationsList[operationIndex]));
            System.out.print("Question: " + firstArgument + " " + operationsList[operationIndex]
                    + " " + secondArgument + "\nYou answer: ");
            countsCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, amountOfAttempts, gamerName);
        }
    }
}
