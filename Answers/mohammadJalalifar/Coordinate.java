package Answers.mohammadJalalifar;

public class Coordinate {
    private int row;
    private int col;

    // Constructor to initialize the coordinate from a string (e.g., "A1", "B5")
    public Coordinate(String position) {
        if (position != null && position.length() == 2) {
            this.row = position.charAt(0) - 'A';
            this.col = Integer.parseInt(position.substring(1)) - 1;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // Validates if the input string is a valid coordinate (e.g., "A1", "B5")
    public static boolean isValidCoordinate(String input) {
//        if (input == null || input.length() != 2) return false;
//        char col = input.charAt(0);
//        char row = input.charAt(1);
//        return (col >= 'A' && col <= 'J') && (row >= 1 && row <= 10);
//    }

        if (input ==null || input.length() < 2 ){
            return false;
        }
        char firstChar = Character.toUpperCase(input.charAt(0));
        if( firstChar < 'A' || firstChar > 'j' ){
            return false;
        }

        try{
            int number = Integer.parseInt(input.substring(1));
            if(number < 1 || number > 10){
                return false;
            }
        }   catch( NumberFormatException e ){
            return false;
        }

        return true;
    }
}