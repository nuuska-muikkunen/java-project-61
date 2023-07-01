package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class Gcd {
    public static final int UPPER_BOUND_OF_INTERVAL = 100;
    public static final int LOW_BOUND_OF_INTERVAL = 0;
    public static final int AMOUNT_OF_QUESTIONS = 3;
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static String[] generateQuestion() {
        int firstArgument;
        int secondArgument;
        String[] questionsAndAnswers = new String[2];
        firstArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        secondArgument = Utils.generateNumber(LOW_BOUND_OF_INTERVAL, UPPER_BOUND_OF_INTERVAL);
        questionsAndAnswers[0] = String.format("Question: %d %d \nYou answer: ", firstArgument, secondArgument);
        questionsAndAnswers[1] = String.valueOf(gcd(firstArgument, secondArgument));
        return questionsAndAnswers;
    }
    public static void askQuestions(String gamerName) {
        String[][] questionsAndCorrectAnswers = new String[AMOUNT_OF_QUESTIONS][2];
        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < AMOUNT_OF_QUESTIONS; i++) {
            questionsAndCorrectAnswers[i] = generateQuestion();
        }
        Engine.communicateGamer(questionsAndCorrectAnswers, gamerName);
    }
}
