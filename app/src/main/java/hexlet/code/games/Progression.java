package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final int AMOUNT_OF_NUMBERS = 10;
    public static final int MAX_STEP = 10;
    public static final int MAX_FIRST_ELEMENT = 100;
    public static final int AMOUNT_OF_QUESTIONS = 3;
    public static String[] getNumbers(int firstProgressionElement, int progressionStep) {
        String[] numbers = new String[AMOUNT_OF_NUMBERS];
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            numbers[i] = Integer.toString(firstProgressionElement + i * progressionStep);
        }
        return numbers;
    }
    public static String[] generateQuestion() {
        int firstProgressionElement;
        int progressionStep;
        int hiddenInx;
        String[] numbers;
        String[] questionsAndAnswers = new String[2];
        firstProgressionElement = Utils.generateNumber(1, MAX_FIRST_ELEMENT);
        progressionStep = Utils.generateNumber(1, MAX_STEP);
        numbers = getNumbers(firstProgressionElement, progressionStep);
        hiddenInx = Utils.generateNumber(0, AMOUNT_OF_NUMBERS - 1);
        numbers[hiddenInx] = "..";
        questionsAndAnswers[0] = "Question: " + String.join(" ", numbers) + "\nYou answer: ";
        questionsAndAnswers[1] = String.valueOf(firstProgressionElement + hiddenInx * progressionStep);
        return questionsAndAnswers;
    }
    public static void askQuestions(String gamerName) {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_QUESTIONS][2];
        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, gamerName);
    }
}

