package com.boardgames.snakeLadder.models;

import java.util.Collections;
import java.util.List;

/**
 * A class that models a board in the snake ladder game
 * Board will have default size as 100 and a snake at random position
 */
public class Board {

    private static final int DEFAULT_BOARD_SIZE = 100;

    /*
    Make snakes and boardsize final so that no one should be able to change it after initialization.
     */
    private final List<Snake> snakes;
    private final int boardSize;

    /**
     * This constructor provides a way to initialize custom list of snakes as well as board size
     * @param snakes
     * @param boardSize
     */
    public Board(List<Snake> snakes, int boardSize) {
        this.snakes = snakes;
        this.boardSize = boardSize;
    }

    /**
     * @return List of snakes
     */
    public List<Snake> getSnakes() {
        return Collections.unmodifiableList(snakes);
    }

    /**
     * @return board size
     */
    public int getBoardSize() {
        return boardSize;
    }

}
