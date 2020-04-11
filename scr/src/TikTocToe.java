
public class TikTocToe {
    private static char[][] ticTocToe = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};
    private static boolean comeOut = false;

    public static void main(String[] args) {
        int threeComplete = 0;
        while (!comeOut) {
            userInput();
            if (threeComplete >= ticTocToe.length) {
                checkResult();
            }

        }

    }

}
