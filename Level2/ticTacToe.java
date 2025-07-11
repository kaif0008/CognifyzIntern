import java.util.Scanner;

public class ticTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain;

        do {
            initializeBoard();
            char player = 'X';
            boolean gameEnded = false;

            while (!gameEnded) {
                printBoard();
                System.out.println("Player " + player + "'s turn:");
                int row, col;

                while (true) {
                    System.out.print("Enter row (0, 1, 2): ");
                    row = sc.nextInt();
                    System.out.print("Enter column (0, 1, 2): ");
                    col = sc.nextInt();

                    if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                        if (board[row][col] == ' ') {
                            board[row][col] = player;
                            break;
                        } else {
                            System.out.println("That cell is already occupied. Try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter values between 0 and 2.");
                    }
                }

                // Check for win
                if (checkWin(player)) {
                    printBoard();
                    System.out.println("Player " + player + " wins!");
                    gameEnded = true;
                } else if (isDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    // Switch player
                    player = (player == 'X') ? 'O' : 'X';
                }
            }

            // Play again?
            System.out.print("Do you want to play again? (y/n): ");
            sc.nextLine(); // consume leftover newline
            playAgain = sc.nextLine().equalsIgnoreCase("y");

        } while (playAgain);

        sc.close();
        System.out.println("Thanks for playing!");
    }

    // Initialize the board with empty spaces
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the board
    public static void printBoard() {
        System.out.println("\n  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i);
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
                if (j < 2) System.out.print(" |");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
    }

    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player &&
                 board[i][1] == player &&
                 board[i][2] == player) || 
                (board[0][i] == player &&
                 board[1][i] == player &&
                 board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) ||
               (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player);
    }

    // Check for a draw
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
