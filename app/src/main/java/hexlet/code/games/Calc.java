package hexlet.code.games;

import java.util.Scanner;
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
                System.out.println("Incorrect operation!");
                return -10000;
        }
    }
    public static void askQuestions(String gamerName) {
        // common games' parameters - varies by types
        Scanner answerReceiver = new Scanner(System.in);
        int countsCorrectAnswers = 0;
        int targetAmountOfAttempts = 3;
        int lowBoundOfInterval = 0;
        int upperBoundOfInterval = 100;
        int correctAnswer = 0;
        int gamerAnswer = 0;
        // specific games parameters
        String[] operationsList = {"+", "-", "*"};
        int amountOfOperations = operationsList.length;
        int firstArgument;
        int secondArgument;
        int operationIndex;
        // Specific question
        System.out.println("What is the result of the expression?");
        while (countsCorrectAnswers < targetAmountOfAttempts && gamerAnswer == correctAnswer) {
            // generation of the random parameters
            operationIndex = Engine.generateNumber(0, amountOfOperations - 1);
            firstArgument = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            secondArgument = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            // calculate correct answer for comparison and display question content for Gamer
            correctAnswer = calculation(firstArgument, secondArgument, operationsList[operationIndex]);
            System.out.print("Question: " + firstArgument + " " + operationsList[operationIndex]
                              + " " + secondArgument + "\nYou answer: ");
            // receive the answer from Gamer
            gamerAnswer = answerReceiver.nextInt();
            if (gamerAnswer == correctAnswer) {
                System.out.println("Correct!");
                countsCorrectAnswers += 1;
                if (countsCorrectAnswers == targetAmountOfAttempts) {
                    System.out.println("Congratulations, " + gamerName + "!");
                }
            } else {
                System.out.println(String.format("'%d' is wrong answer ;(. " + "Correct answer was '%d'.\n"
                                               + "Let's try again %s!", gamerAnswer, correctAnswer, gamerName));
            }
        }
    }
}
