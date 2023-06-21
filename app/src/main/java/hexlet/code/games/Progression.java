package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;
public class Progression {
    public static void askQuestions(String gamerName) {
        Scanner answerReceiver = new Scanner(System.in);
        int countsCorrectAnswers = 0;
        int targetAmountOfAttempts = 3;
        int amountOfNumbers = 10;
        int minFirstElement = 1;
        int maxFirstElement = 100;
        int firstProgressionElement;
        int minStep = 1;
        int maxStep = 10;
        int progressionStep;
        String[] numbers = new String[amountOfNumbers];
        int hiddenInx;
        int correctAnswer = 0;
        int gamerAnswer = 0;
        System.out.println("What number is missing in the progression?");
        while (countsCorrectAnswers < targetAmountOfAttempts && gamerAnswer == correctAnswer) {
            firstProgressionElement = Engine.generateNumber(minFirstElement, maxFirstElement);
            progressionStep = Engine.generateNumber(minStep, maxStep);
            hiddenInx = Engine.generateNumber(0, amountOfNumbers - 1);
            for (int i = 0; i < amountOfNumbers; i++) {
                numbers[i] = Integer.toString(firstProgressionElement + i * progressionStep);
            }
            numbers[hiddenInx] = "..";
            correctAnswer = firstProgressionElement + hiddenInx * progressionStep;
            System.out.print("Question: " + String.join(" ", numbers) + "\nYou answer: ");
            gamerAnswer = answerReceiver.nextInt();
            countsCorrectAnswers += 1;
            Engine.correctInformation(String.valueOf(gamerAnswer), String.valueOf(correctAnswer),
                    countsCorrectAnswers, gamerName);
        }
    }
}

