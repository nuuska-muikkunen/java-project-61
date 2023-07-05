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
            case "1" -> Engine.greetGamer();
            case "2" -> Even.askQuestions();
            case "3" -> Calc.askQuestions();
            case "4" -> Gcd.askQuestions();
            case "5" -> Progression.askQuestions();
            case "6" -> Prime.askQuestions();
            default -> {
            }
        }
    }
}
