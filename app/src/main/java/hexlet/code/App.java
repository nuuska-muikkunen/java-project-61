package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Gcd;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Progression;

public class App {
    public static void main(String[] args) {
        Scanner gamerInput = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n0 - Exit\nYour choice: ");
        int gameNumber = gamerInput.nextInt();
        if (gameNumber != 0) {
            System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
            String gamerName = gamerInput.next();
            System.out.println("Hello, " + gamerName + "!");
            switch (gameNumber) {
                case 5:
                    Progression.askQuestions(gamerName);
                    break;
                case 4:
                    Gcd.askQuestions(gamerName);
                    break;
                case 3:
                    Calc.askQuestions(gamerName);
                    break;
                case 2:
                    Even.askQuestions(gamerName);
                    break;
                case 1:
                    break;
                default:
            }
        }
    }
}
