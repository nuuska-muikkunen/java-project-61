package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greetGamer() {
        System.out.println("\nWelcome to the Brain Games!");
        Scanner playerInput = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String playerName = playerInput.next();
        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }
    public static int getGamerInput() {
        Scanner gamerInput = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n2 - Even\n3 - Calc\n0 - Exit\nYour choice: ");
        int inputNumber = gamerInput.nextInt();
        return inputNumber;
    }
}
