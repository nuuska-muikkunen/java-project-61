package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    // returns "true" if the argument is even number, otherwise return "false"
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    public static void askQuestions(String gamerName) {
        int countsCorrectAnswers = 0;
        int amountOfAttempts = 3;
        int lowBoundOfInterval = 0;
        int upperBoundOfInterval = 100;
        int randomNumberToAsk;
        String correctAnswer = "";
        String gamerAnswer = "";
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        // main cycle of the questions to the Gamer
        // until target amount of the consecutive correct answers achieved or the incorrect answer is given
        while (countsCorrectAnswers < amountOfAttempts && gamerAnswer.equals(correctAnswer)) {
            randomNumberToAsk = Engine.generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            correctAnswer = isEven(randomNumberToAsk) ? "yes" : "no";
            System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
            countsCorrectAnswers += 1;
            // receive and compare the answer from Gamer
            gamerAnswer = Engine.communicateGamer(correctAnswer, countsCorrectAnswers, amountOfAttempts, gamerName);
        }
    }
}
