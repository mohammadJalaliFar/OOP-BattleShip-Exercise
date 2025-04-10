package Answers.mohammadJalalifar;
import java.util.Scanner;

public class Player {
    private String name;
    private Board board;
    private Ship[] ships;

    // Constructor to initialize player and board
    public Player(String name) {
        this.name = name;
        this.board = new Board(10); // 10x10 grid
        this.ships = new Ship[] {
                new Ship("Aircraft Carrier", 5),
                new Ship("Battleship", 4),
                new Ship("Submarine", 3),
                new Ship("Patrol Boat", 2)
        };
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isAllShipsSunk() {
        return board.allShipsSunk();
    }

    // Method to place ships randomly on the board
    public void placeShipsRandomly() {
        for (Ship ship : ships) {
            ShipPlacer.placeShipRandomly(board, ship);
        }
    }

    // Method to place ships manually on the board
    public void placeShipsManually() {
        Scanner scanner = new Scanner(System.in);
        for (Ship ship : ships) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Enter coordinates to place the " + ship.getName() + " (" + ship.getSize() + " cells):");
                String startCoord = scanner.nextLine().toUpperCase();
                boolean horizontal = askForShipOrientation(scanner);
                Coordinate start = new Coordinate(startCoord);

                if (board.placeShip(ship, start.getRow(), start.getCol(), horizontal)) {
                    placed = true;
                    System.out.println("Placed " + ship.getName());
                } else {
                    System.out.println("Invalid placement. Try again.");
                }
            }
        }
    }

    private boolean askForShipOrientation(Scanner scanner) {
        System.out.println("Enter 'h' for horizontal or 'v' for vertical:");
        char orientation = scanner.nextLine().toLowerCase().charAt(0);
        return orientation == 'h';
    }
}
