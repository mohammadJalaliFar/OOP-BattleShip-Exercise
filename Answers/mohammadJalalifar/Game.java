package Answers.mohammadJalalifar;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private boolean player1Turn;

    // Constructor to initialize the game
    public Game() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        player1Turn = true;
    }

    // Starts the game
    public void start() {
        System.out.println("Starting the game...");

        // Place ships for both players
        player1.placeShipsRandomly();
        player2.placeShipsRandomly();

        // Game loop
        while (!gameOver()) {
            if (player1Turn) {
                System.out.println("Player 1's turn:");
                player2.getBoard().printBoard();
                playerTurn(player1, player2);
            } else {
                System.out.println("Player 2's turn:");
                player1.getBoard().printBoard();
                playerTurn(player2, player1);
            }
            player1Turn = !player1Turn;
        }

        announceWinner();
        askReplay();
    }

    private void playerTurn(Player currentPlayer, Player opponent) {
        Scanner scanner = new Scanner(System.in);
        boolean validShot = false;
        while (!validShot) {
            System.out.println(currentPlayer.getName() + ", enter a coordinate to attack (e.g., A1):");
            String input = scanner.nextLine().toUpperCase();

            if (InputValidator.isValidCoordinate(input)) {
                Coordinate target = new Coordinate(input);
                if (opponent.getBoard().shootAt(target.getRow(), target.getCol())) {
                    System.out.println("Hit!");
                } else {
                    System.out.println("Miss.");
                }
                validShot = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private boolean gameOver() {
        return player1.isAllShipsSunk() || player2.isAllShipsSunk();
    }

    private void announceWinner() {
        if (player1.isAllShipsSunk()) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Player 1 wins!");
        }
    }

    private void askReplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play again? (yes/no):");
        String response = scanner.nextLine().toLowerCase();
        if (response.equals("yes")) {
            new Game().start();  // Start a new game
        } else {
            System.out.println("Thanks for playing!");
        }
    }
}
