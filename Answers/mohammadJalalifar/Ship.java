package Answers.mohammadJalalifar;

public class Ship {
    private String name;
    private int size;
    private int health;

    // Constructor to create a ship with its name and size
    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.health = size; // Initially, the ship's health is equal to its size
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getHealth() {
        return health;
    }

    // Reduces the ship's health by 1 (for a hit)
    public void reduceHealth() {
        if (health > 0) health--;
    }

    // Checks if the ship is completely sunk
    public boolean isSunk() {
        return health == 0;
    }
}
