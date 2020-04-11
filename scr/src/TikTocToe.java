import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * this class will perform all the operation in tic-toc-toe table.
 */
public class TikTocToe {
    //this will be the static character type array as it store only X,O value in it and this is static as it can easly change in hole program.
    private static char[][] ticTocToe = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};
    //comeOut is the globle variable as the condition get check that how wins the game again -again then if any of the condition get satisfied then the program will ent at tha time.
    private static boolean comeOut = false;
    // oldChance is the global character variable which store previous insert value
    // by default it on O as the game start with X in this program.
    private static char oldChance = 'O';

    // main function will maintaine the hole flow of the program.
    public static void main(String[] args) {
        int threeComplete = 0;
        showTicTocToeTake();
        while (!comeOut) {
            userInput();
            showTicTocToeTake();
            if (threeComplete >= ticTocToe.length) {
                checkResult();
            }
            threeComplete++;
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
        } else if (ticTocToe[0][0] == ' ' || ticTocToe[0][2] == ' ') {
            if (ticTocToe[0][0] == ticTocToe[1][1] && ticTocToe[2][2] == ticTocToe[1][1]) {
                System.out.println("Impossible");
                comeOut = true;
            }
            if (ticTocToe[0][1] == ticTocToe[1][1] && ticTocToe[1][1] == ticTocToe[2][0]) {
                System.out.println("Impossible");
                comeOut = true;
            }
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
        int count4 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTocToe[i][j] != ' ') {
                    count4 += 1;
                }
            }
        }
        if (count4 == 9) {
            System.out.println("Draw");
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
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            userInput();
        }


    }

    private static void inTicTokToe(int row, int column) {

        if (ticTocToe[row][column] == ' ') {
            ticTocToe[row][column] = (oldChance == 'O') ? 'X' : 'O';
            oldChance = ticTocToe[row][column];
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            userInput();
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
