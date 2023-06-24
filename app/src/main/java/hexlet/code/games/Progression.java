package hexlet.code.games;


import hexlet.code.Engine;

public class Progression {

    public static final int AMOUNT_OF_ATTEMPTS = 3;
    public static final int AMOUNT_OF_NUMBERS = 10;
    public static final int MAX_STEP = 10;
    public static final int MAX_FIRST_ELEMENT = 100;

    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int firstProgressionElement;;
        int progressionStep;
        String[] numbers = new String[AMOUNT_OF_NUMBERS];
        int hiddenInx;
        String correctAnswer = "";
        String gamerAnswer = "";
        System.out.println("What number is missing in the progression?");
        while (countsCorrectAnswers < AMOUNT_OF_ATTEMPTS && gamerAnswer.equals(correctAnswer)) {
            firstProgressionElement = Engine.generateNumber(1, MAX_FIRST_ELEMENT);
            progressionStep = Engine.generateNumber(1, MAX_STEP);
            hiddenInx = Engine.generateNumber(0, AMOUNT_OF_NUMBERS - 1);
            for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
                numbers[i] = Integer.toString(firstProgressionElement + i * progressionStep);
            }
            numbers[hiddenInx] = "..";
            correctAnswer = String.valueOf(firstProgressionElement + hiddenInx * progressionStep);
            System.out.print("Question: " + String.join(" ", numbers) + "\nYou answer: ");
            countsCorrectAnswers += 1;
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, AMOUNT_OF_ATTEMPTS, gamerName);
        }
    }
}

