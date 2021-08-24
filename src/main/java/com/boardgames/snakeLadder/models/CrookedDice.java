package com.boardgames.snakeLadder.models;

/**
 * A crooked dice that always returns an even number
 */
public class CrookedDice extends Dice {

    /**
     * Method to roll the dice
     * @return number on the face of dice
     */
    @Override
    public int roll() {
        return (int) ((Math.random() * 3) + 1) * 2;
    }
}
