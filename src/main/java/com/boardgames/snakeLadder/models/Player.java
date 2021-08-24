package com.boardgames.snakeLadder.models;

/**
 * A class that models a player
 */
public class Player {

    private final String name;
    private int position;

    public Player(String name) {
       this.name = name;
       this.position = 0;
    }

    /**
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * @return position of the player on board
     */
    public int getPosition() {
        return position;
    }

    /**
     * Updates the position of the player on board
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }



}
