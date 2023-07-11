package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int AMOUNT_OF_ATTEMPTS = 3;

    public static String greetGamer() {
        Scanner gamerInput = new Scanner(System.in);
        System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
        String gamerName = gamerInput.next();
        System.out.println("Hello, " + gamerName + "!");
        return gamerName;
    }
    public static void communicateGamer(String[][] answersAndQuestions, String gameQuestion) {
        Scanner answerReceiver = new Scanner(System.in);
        String gamerName = greetGamer();
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
