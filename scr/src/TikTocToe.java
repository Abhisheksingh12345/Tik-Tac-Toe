import java.util.InputMismatchException;
import java.util.Scanner;

public class TikTocToe {
    private static char[][] ticTocToe = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};
    private static boolean comeOut = false;

    public static void main(String[] args) {
        int threeComplete = 0;
        showTicTocToeTake();
        while (!comeOut) {
            userInput();
            if (threeComplete >= ticTocToe.length) {
                checkResult();
            }

        }

    }

    private static void checkResult() {
        int count1 = 0;
        int count2 = 0;
        char index = 'X';
        if (ticTocToe[0][0] != ' ' && ticTocToe[0][0] == ticTocToe[1][1] && ticTocToe[2][2] == ticTocToe[1][1]) {
            System.out.println(ticTocToe[1][1] + " wins");
            comeOut = true;
        } else if (ticTocToe[0][1] != ' ' && ticTocToe[0][1] == ticTocToe[1][1] && ticTocToe[1][1] == ticTocToe[2][0]) {
            System.out.println(ticTocToe[1][1] + " wins");
            comeOut = true;
        } else if (ticTocToe[0][0] == ' ' || ticTocToe[0][1] == ' ' && ticTocToe[0][0] == ticTocToe[1][1]
                && ticTocToe[2][2] == ticTocToe[1][1] || ticTocToe[0][1] == ticTocToe[1][1] && ticTocToe[1][1] == ticTocToe[2][0]) {
            System.out.println("Impossible");
            comeOut = true;
        }
        for (int i = 0; i < ticTocToe.length; i++) {
            if (ticTocToe[i][0] != ' ' && ticTocToe[i][0] == ticTocToe[i][1] && ticTocToe[i][1] == ticTocToe[i][2]) {
                count1 += 1;
                if (count1 == 1) {
                    index = ticTocToe[i][0];
                }
            }
            if (ticTocToe[0][i] != ' ' && ticTocToe[0][i] == ticTocToe[1][i] && ticTocToe[1][i] == ticTocToe[2][i]) {
                count2 += 1;
                if (count2 == 1) {
                    index = ticTocToe[0][i];
                }
            }
        }
        if (count1 > 0 || count2 > 0) {
            System.out.println(index + " wins");
            comeOut = true;


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
            System.out.print("Enter the coordinates: ");
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
            //  indexColumn = 0;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 1 && column == 2) {
            indexRow = 1;
            // indexColumn = 0;
            inTicTokToe(indexRow, indexColumn);
        } else if (row == 1 && column == 3) {
            // indexRow = 0;
            // indexColumn = 0;
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
            // indexRow = 0;
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
            // indexRow = 0;
            indexColumn = 2;
            inTicTokToe(indexRow, indexColumn);
        }


    }

    private static char oldChance = 'O';

    private static void inTicTokToe(int row, int column) {
        if (row > 3 || column > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            userInput();
        } else {
            for (char[] rowwise : ticTocToe) {
                for (char h : rowwise) {
                    if (ticTocToe[row][column] == ' ') {
                        ticTocToe[row][column] = (oldChance == 'O') ? 'X' : 'O';
                        oldChance = ticTocToe[row][column];
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        userInput();
                    }
                }
            }
        }

    }

    private static void showTicTocToeTake() {
        System.out.println("----------");
        for (char[] row : ticTocToe) {
            System.out.print("|" + " ");
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println(" |");
        }
        System.out.println("----------");
    }
}
