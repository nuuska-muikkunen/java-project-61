package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) {
        Scanner gamerInput = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit\nYour choice: ");
        String gameNumber = gamerInput.next();
        switch (gameNumber) {
            case "1" -> greetGamer();
            case "2" -> Even.askQuestions(greetGamer());
            case "3" -> Calc.askQuestions(greetGamer());
            case "4" -> Gcd.askQuestions(greetGamer());
            case "5" -> Progression.askQuestions(greetGamer());
            case "6" -> Prime.askQuestions(greetGamer());
            default -> {
            }
        }
    }
    public static String greetGamer() {
        Scanner gamerInput = new Scanner(System.in);
        System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
        String gamerName = gamerInput.next();
        System.out.println("Hello, " + gamerName + "!");
        return gamerName;
    }
}
