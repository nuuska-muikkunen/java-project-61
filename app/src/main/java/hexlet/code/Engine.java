package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int AMOUNT_OF_ATTEMPTS = 3;
    public static void communicateGamer(String[][] answersAndQuestions, String gameQuestion, String gamerName) {
        Scanner answerReceiver = new Scanner(System.in);
        System.out.println(gameQuestion);
        for (int i = 0; i < AMOUNT_OF_ATTEMPTS; i++) {
            System.out.print("Question: " + answersAndQuestions[i][0] + "\nYou answer: ");
            String gamerAnswer = answerReceiver.next();
            if (gamerAnswer.equals(answersAndQuestions[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!%n",
                        gamerAnswer, answersAndQuestions[i][1], gamerName);
                return;
            }
        }
        System.out.println("Congratulations, " + gamerName + "!");
    }
}
