package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int AMOUNT_OF_ATTEMPTS = 3;
    public static void communicateGamer(String[][] answersAndQuestions, String gamerName) {
        Scanner answerReceiver = new Scanner(System.in);
        for (int i = 0; i < AMOUNT_OF_ATTEMPTS; i++) {
            System.out.print(answersAndQuestions[i][0]); // display question line
            String gamerAnswer = answerReceiver.next();
            if (gamerAnswer.equals(answersAndQuestions[i][1])) {
                System.out.println("Correct!");
                if (i == AMOUNT_OF_ATTEMPTS - 1) {
                    System.out.println("Congratulations, " + gamerName + "!");
                }
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!%n",
                        gamerAnswer, answersAndQuestions[i][1], gamerName);
                break;
            }
        }
    }
}
