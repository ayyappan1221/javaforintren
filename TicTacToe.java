import java.util.Scanner;

public class TicTacToe {
    static char[] board = new char[9];

    static void initBoard() {
        for (int i = 0; i < 9; i++)
            board[i] = (char) ('1' + i);
    }

    static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean checkWin(char p) {
        return (board[0] == p && board[1] == p && board[2] == p) ||
                (board[3] == p && board[4] == p && board[5] == p) ||
                (board[6] == p && board[7] == p && board[8] == p) ||
                (board[0] == p && board[3] == p && board[6] == p) ||
                (board[1] == p && board[4] == p && board[7] == p) ||
                (board[2] == p && board[5] == p && board[8] == p) ||
                (board[0] == p && board[4] == p && board[8] == p) ||
                (board[2] == p && board[4] == p && board[6] == p);
    }

    static boolean isDraw() {
        for (int i = 0; i < 9; i++) {
            if (board[i] >= '1' && board[i] <= '9')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char playAgain;

        do {
            initBoard();
            char currentPlayer = 'X';

            while (true) {
                printBoard();
                System.out.println("Player " + currentPlayer + " enter position (1-9):");
                int pos = sc.nextInt() - 1;

                if (pos < 0 || pos > 8 || board[pos] == 'X' || board[pos] == 'O') {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }

                board[pos] = currentPlayer;

                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isDraw()) {
                    printBoard();
                    System.out.println("Game Draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

            System.out.println("Play again? (y/n):");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        sc.close();
    }
}
