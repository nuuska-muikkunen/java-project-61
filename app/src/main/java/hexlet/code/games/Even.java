package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    public static final int AMOUNT_OF_ATTEMPTS = 3;
    public static final int UPPER_BOUND_OF_INTERVAL = 100;

    // returns "true" if the argument is even number, otherwise return "false"
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int lowBoundOfInterval = 0;
        int randomNumberToAsk;
        String correctAnswer = "";
        String gamerAnswer = "";
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        // main cycle of the questions to the Gamer
        // until target amount of the consecutive correct answers achieved or the incorrect answer is given
        while (countsCorrectAnswers < AMOUNT_OF_ATTEMPTS && gamerAnswer.equals(correctAnswer)) {
            randomNumberToAsk = Engine.generateNumber(lowBoundOfInterval, UPPER_BOUND_OF_INTERVAL);
            correctAnswer = isEven(randomNumberToAsk) ? "yes" : "no";
            System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
            countsCorrectAnswers += 1;
            // receive and compare the answer from Gamer
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, AMOUNT_OF_ATTEMPTS, gamerName);
        }
    }
}
