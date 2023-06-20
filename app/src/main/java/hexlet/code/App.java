package hexlet.code;

public class App {
    public static void main(String[] args) {
        int gameNumber = Cli.getGamerInput();
        switch (gameNumber) {
            case 2:
                EvenGame.askQuestions();
                break;
            case 1:
                Cli.greetGamer();
                break;
            case 0:
                break;
            default:
        }
    }
}
