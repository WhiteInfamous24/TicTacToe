import java.util.Scanner;

public class Game {
    char board[][] = new char[3][3];
    char player;
    int movements;
    boolean finalize;

    public Game() {
        player = 'O';
        movements = 0;
        finalize = false;
        initializeBoard();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        showBoard();
        while(finalize == false) {
            changePlayer();
            askForMovement();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            showBoard();
            if(determineWinner() == true)
                finalize = true;
            movements++;
        }
        System.out.println("GANADOR JUGADOR: " + player + "\n");
    }

    private void showBoard() {
        System.out.println("-------------");
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("------------");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("------------");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("-------------\n");
    }

    private void initializeBoard() {
        board[0][0] = ' ';
        board[0][1] = ' ';
        board[0][2] = ' ';
        board[1][0] = ' ';
        board[1][1] = ' ';
        board[1][2] = ' ';
        board[2][0] = ' ';
        board[2][1] = ' ';
        board[2][2] = ' ';
    }

    private void changePlayer() {
        if(player == 'X')
            player = 'O';
        else
            player = 'X';
    }

    private void askForMovement() {
        boolean valid_movement = false;
        do {
            if(movements <= 6) {
                System.out.print("Seleccionar casilla: ");
                Scanner input = new Scanner(System.in);
                int position = input.nextInt();
                if(position < 10 && position > 0) {
                    if(position == 1 && board[2][0] == ' ') {
                        board[2][0] = player;
                        break;
                    }
                    if(position == 2 && board[2][1] == ' ') {
                        board[2][1] = player;
                        break;
                    }
                    if(position == 3 && board[2][2] == ' ') {
                        board[2][2] = player;
                        break;
                    }
                    if(position == 4 && board[1][0] == ' ') {
                        board[1][0] = player;
                        break;
                    }
                    if(position == 5 && board[1][1] == ' ') {
                        board[1][1] = player;
                        break;
                    }
                    if(position == 6 && board[2][0] == ' ') {
                        board[1][2] = player;
                        break;
                    }
                    if(position == 7 && board[0][0] == ' ') {
                        board[0][0] = player;
                        break;
                    }
                    if(position == 8 && board[0][1] == ' ') {
                        board[0][1] = player;
                        break;
                    }
                    if(position == 9 && board[0][2] == ' ') {
                        board[0][2] = player;
                        break;
                    }
                }
                System.out.println("\nMovimiento invalido, intente nuevamente\n");
            }
        } while(valid_movement == false);
    }

    private boolean determineWinner() {
        if(board[0][0] == player && board[0][1] == player && board[0][2] == player)
            return true;
        if(board[1][0] == player && board[1][1] == player && board[1][2] == player)
            return true;
        if(board[2][0] == player && board[2][1] == player && board[2][2] == player)
            return true;
        if(board[0][0] == player && board[1][0] == player && board[2][0] == player)
            return true;
        if(board[0][1] == player && board[1][1] == player && board[2][1] == player)
            return true;
        if(board[0][2] == player && board[1][2] == player && board[2][2] == player)
            return true;
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if(board[2][0] == player && board[1][1] == player && board[0][2] == player)
            return true;
        return false;
    }
}