import java.util.InputMismatchException;
import java.util.Scanner;

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

    private static void userInput() {
        int row = 0;
        int column = 0;
        int indexRow = 0;
        int indexColumn = 0;
        Scanner tell = new Scanner(System.in);
        boolean comeOut = false;
        while (!comeOut) {
            System.out.println("Enter the coordinates: ");
            try {
                row = tell.nextInt();
                column = tell.nextInt();
                comeOut = true;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates: ");
                tell.nextLine();
            }
        }
        if (row == 1 && column == 1) {
            indexRow = 2;
            indexColumn = 0;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 1 && column == 2) {
            indexRow = 1;
            indexColumn = 0;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 1 && column == 3) {
            indexRow = 0;
            indexColumn = 0;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 2 && column == 1) {
            indexRow = 2;
            indexColumn = 1;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 2 && column == 2) {
            indexRow = 1;
            indexColumn = 1;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 2 && column == 3) {
            indexRow = 0;
            indexColumn = 1;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 3 && column == 1) {
            indexRow = 2;
            indexColumn = 2;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 3 && column == 2) {
            indexRow = 1;
            indexColumn = 2;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 3 && column == 3) {
            indexRow = 0;
            indexColumn = 2;
            inTicTokToe(indexRow, indexColumn);
        }


    }
}

}
