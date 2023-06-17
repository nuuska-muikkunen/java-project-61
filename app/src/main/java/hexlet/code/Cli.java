package hexlet.code;

import java.util.Scanner;

public class Cli {
    static public void greetGamer () {
        Scanner playerInput = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String playerName = playerInput.next();
        System.out.println("Hello, " + playerName + "!");
    }
}
