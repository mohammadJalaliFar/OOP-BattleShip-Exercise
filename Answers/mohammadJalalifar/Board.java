package Answers.mohammadJalalifar;

public class Board {

        private char[][] grid;
        private int size;


        // Constructor to initialize the grid with the given size
        public Board(int size) {
            this.size = size;
            this.grid = new char[size][size];
            initializeGrid();
        }

        public int getSize() {
            return size;
        }

        // Initializes the grid with water ('~')
        private void initializeGrid() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    grid[i][j] = '~'; // Empty water
                }
            }
        }

        // Method to place a ship on the grid at the specified position
        public boolean placeShip(Ship ship, int row, int col, boolean horizontal) {
            if (horizontal) {
                if (col + ship.getSize() > size) return false;
                for (int i = 0; i < ship.getSize(); i++) {
                    if (grid[row][col + i] != '~') return false;
                }
                for (int i = 0; i < ship.getSize(); i++) {
                    grid[row][col + i] = 'S'; // Place ship part
                }
            } else {
                if (row + ship.getSize() > size) return false;
                for (int i = 0; i < ship.getSize(); i++) {
                    if (grid[row + i][col] != '~') return false;
                }
                for (int i = 0; i < ship.getSize(); i++) {
                    grid[row + i][col] = 'S'; // Place ship part
                }
            }
            return true;
        }

        // Method to shoot at the specified position
        public boolean shootAt(int row, int col) {
            if (grid[row][col] == 'S') {
                grid[row][col] = 'X'; // Hit
                return true;
            } else if (grid[row][col] == '~') {
                grid[row][col] = 'O'; // Miss
            }
            return false;
        }

        // Checks if all ships are sunk
        public boolean allShipsSunk() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (grid[i][j] == 'S') return false;
                }
            }
            return true;
        }

        // Method to print the current state of the board
        public void printBoard() {
            for (int i = 1; i <= size; i++) {
                System.out.print("  " + i);
            }
            System.out.println();

            for (int row = 0; row < size; row++) {
                System.out.print((char) ('A' + row) + "  ");
                for (int col = 0; col < size; col++) {
                    System.out.print(grid[row][col] + "  ");
                }
                System.out.println();
            }
        }
    }
