package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;
public class Progression {
    public static void askQuestions(String gamerName) {
        int i;
        int countsCorrectAnswers = 0;
        int targetAmountOfAttempts = 3;
        int amountOfNumbers = 10;
        int minFirstElement = 1;
        int maxFirstElement = 100;
        int firstProgressionElement = Engine.generateNumber(minFirstElement, maxFirstElement);
        int minStep = 1;
        int maxStep = 10;
        int progressionStep = Engine.generateNumber(minStep, maxStep);
        String[] numbers = new String[amountOfNumbers];
        int hiddenInx = Engine.generateNumber(0, amountOfNumbers - 1);
        int correctAnswer = 0;
        int gamerAnswer = 0;
        Scanner answerReceiver = new Scanner(System.in);
        System.out.println("What number is missing in the progression?");
        while (countsCorrectAnswers < targetAmountOfAttempts && gamerAnswer == correctAnswer) {
            for (i = 0; i < amountOfNumbers; i++) {
                numbers[i] = Integer.toString(firstProgressionElement + i * progressionStep);
            }
            numbers[hiddenInx] = "..";
            correctAnswer = firstProgressionElement + hiddenInx * progressionStep;
            System.out.print("Question: " + String.join(" ", numbers) + "\nYou answer: ");
            gamerAnswer = answerReceiver.nextInt();
            if (gamerAnswer == correctAnswer) {
                System.out.println("Correct!");
                countsCorrectAnswers += 1;
                firstProgressionElement = Engine.generateNumber(minFirstElement, maxFirstElement);
                progressionStep = Engine.generateNumber(minStep, maxStep);
                hiddenInx = Engine.generateNumber(0, amountOfNumbers - 1);
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

