package hexlet.code;
public class Engine {
    // returns pseudorandom integer number between the bounds of the interval defined by the arguments
    public static int generateNumber(int lowBoundOfInterval, int upperBoundOfInterval) {
        return (int) Math.floor(Math.random() * (upperBoundOfInterval - lowBoundOfInterval + 1)) + lowBoundOfInterval;
    }
    public static void correctInformation(String gamerAnswer, String correctAnswer, int countsCorrectAnswers,
                                          String gamerName) {
        int targetAmountOfAttempts = 3;
        if (gamerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            if (countsCorrectAnswers == targetAmountOfAttempts) {
                System.out.println("Congratulations, " + gamerName + "!");
            }
        } else {
            System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again %s!",
                    gamerAnswer, correctAnswer, gamerName));
        }
    }
    public static void correctInformation(int gamerAnswer, int correctAnswer, int countsCorrectAnswers,
                                          String gamerName) {
        int targetAmountOfAttempts = 3;
        if (gamerAnswer == correctAnswer) {
            System.out.println("Correct!");
            if (countsCorrectAnswers == targetAmountOfAttempts) {
                System.out.println("Congratulations, " + gamerName + "!");
            }
        } else {
            System.out.println(String.format("'%d' is wrong answer ;(. Correct answer was '%d'.\nLet's try again %s!",
                    gamerAnswer, correctAnswer, gamerName));
        }
    }
}
