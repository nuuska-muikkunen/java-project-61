package hexlet.code.games;

import hexlet.code.Engine;
public class Progression {
    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int amountOfAttempts = 3;
        int amountOfNumbers = 10;
        int maxFirstElement = 100;
        int firstProgressionElement;
        int maxStep = 10;
        int progressionStep;
        String[] numbers = new String[amountOfNumbers];
        int hiddenInx;
        String correctAnswer = "";
        String gamerAnswer = "";
        System.out.println("What number is missing in the progression?");
        while (countsCorrectAnswers < amountOfAttempts && gamerAnswer.equals(correctAnswer)) {
            firstProgressionElement = Engine.generateNumber(1, maxFirstElement);
            progressionStep = Engine.generateNumber(1, maxStep);
            hiddenInx = Engine.generateNumber(0, amountOfNumbers - 1);
            for (int i = 0; i < amountOfNumbers; i++) {
                numbers[i] = Integer.toString(firstProgressionElement + i * progressionStep);
            }
            numbers[hiddenInx] = "..";
            correctAnswer = String.valueOf(firstProgressionElement + hiddenInx * progressionStep);
            System.out.print("Question: " + String.join(" ", numbers) + "\nYou answer: ");
            countsCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, amountOfAttempts, gamerName);
        }
    }
}

