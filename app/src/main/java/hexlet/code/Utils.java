package hexlet.code;

public class Utils {
    // returns pseudorandom integer number between the bounds of the interval defined by the arguments
    public static int generateNumber(int lowBoundOfInterval, int upperBoundOfInterval) {
        return (int) Math.floor(Math.random() * (upperBoundOfInterval - lowBoundOfInterval + 1)) + lowBoundOfInterval;
    }
}
