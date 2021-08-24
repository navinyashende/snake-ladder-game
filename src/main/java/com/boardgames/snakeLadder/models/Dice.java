package com.boardgames.snakeLadder.models;

/**
 * A class that models a dice in the game with 6 faces
 */
public class Dice implements Rollable {

    /**
     * Method to roll the dice
     * @return number on the face of dice
     */
    public int roll() {
        return  (int) (Math.random() * 6) + 1;
    }


}
