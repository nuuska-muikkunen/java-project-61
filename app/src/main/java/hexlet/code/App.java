package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Gcd;
import hexlet.code.games.Calc;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Progression;

public class App {
    public static void main(String[] args) {
        String gamerName;
        Scanner gamerInput = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n0 - Exit\nYour choice: ");
        int gameNumber = gamerInput.nextInt();
        switch (gameNumber) {
            case 5:
                gamerName = Cli.greetGamer();
                Progression.askQuestions(gamerName);
                break;
            case 4:
                gamerName = Cli.greetGamer();
                Gcd.askQuestions(gamerName);
                break;
            case 3:
                gamerName = Cli.greetGamer();
                Calc.askQuestions(gamerName);
                break;
            case 2:
                gamerName = Cli.greetGamer();
                EvenGame.askQuestions(gamerName);
                break;
            case 1:
                gamerName = Cli.greetGamer();
                break;
            case 0:
                System.out.println("Game over. Good bye!");
                break;
            default:
                System.out.println("Wrong game number. Good bye!");
        }
    }
}
