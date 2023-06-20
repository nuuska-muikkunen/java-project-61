package hexlet.code;

import java.util.Scanner;

// returns "true" if the argument is even number, otherwise return "false"
public class EvenGame {
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // returns pseudorandom integer number between the bounds of the interval defined by the arguments
    public static int generateNumber(int lowBoundOfInterval, int upperBoundOfInterval) {
        return (int) Math.floor(Math.random() * (upperBoundOfInterval - lowBoundOfInterval + 1)) + lowBoundOfInterval;
    }

    // main cycle of the questions to the Gamer
    // until target amount of the consecutive correct answers achieved or the incorrect answer is given
    public static void askQuestions() {
        int countsCorrectAnswers = 0;
        boolean isCorrectAnswer = true;
        int randomNumberToAsk;
        int targetAmountOfAttempts = 3;
        int lowBoundOfInterval = 0;
        int upperBoundOfInterval = 100;
        String correctAnswer;
        String gamerName = Cli.greetGamer();
        Scanner answerResiver = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (countsCorrectAnswers < targetAmountOfAttempts && isCorrectAnswer) {
            randomNumberToAsk = generateNumber(lowBoundOfInterval, upperBoundOfInterval);
            correctAnswer = isEven(randomNumberToAsk) ? "yes" : "no";
            System.out.print("Question: " + randomNumberToAsk + "\nYou answer: ");
            String answerString = answerResiver.next();
            if (answerString.equals(correctAnswer)) {
                System.out.println("Correct!");
                countsCorrectAnswers += 1;
                if (countsCorrectAnswers == targetAmountOfAttempts) {
                    System.out.println("Congratulations, " + gamerName + "!");
                }
            } else {
                System.out.println("'" + answerString + "'" + " is wrong answer ;(. "
                                   + "Correct answer was " + "'" + correctAnswer + "'" + ".\n"
                                   + "Let's try again, " + gamerName + "!");
                isCorrectAnswer = false;
            }
        }
    }
}

