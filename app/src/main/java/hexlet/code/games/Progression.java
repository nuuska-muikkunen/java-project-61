package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.AMOUNT_OF_ATTEMPTS;

public class Progression {
    public static final int AMOUNT_OF_NUMBERS = 10;
    public static final int MAX_STEP = 10;
    public static final int MAX_FIRST_ELEMENT = 100;
    public static final String GAME_RULES = "What number is missing in the progression?";
    public static String[] getNumbers(int firstProgressionElement, int progressionStep, int amountOfElements) {
        String[] numbers = new String[amountOfElements];
        for (int i = 0; i < amountOfElements; i++) {
            numbers[i] = Integer.toString(firstProgressionElement + i * progressionStep);
        }
        return numbers;
    }
    public static String[] roundData() {
        String[] questionsAndAnswers = new String[2];
        int firstProgressionElement = Utils.generateNumber(1, MAX_FIRST_ELEMENT);
        int progressionStep = Utils.generateNumber(1, MAX_STEP);
        String[] numbers = getNumbers(firstProgressionElement, progressionStep, AMOUNT_OF_NUMBERS);
        int hiddenInx = Utils.generateNumber(0, AMOUNT_OF_NUMBERS - 1);
        numbers[hiddenInx] = "..";
        questionsAndAnswers[0] = String.join(" ", numbers);
        questionsAndAnswers[1] = String.valueOf(firstProgressionElement + hiddenInx * progressionStep);
        return questionsAndAnswers;
    }
    public static void askQuestions(String gamerName) {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_ATTEMPTS][2];
        for (int i = 0; i < AMOUNT_OF_ATTEMPTS; i++) {
            questionsAndCorrectAnswers[i] = roundData();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, GAME_RULES, gamerName);
    }
}

