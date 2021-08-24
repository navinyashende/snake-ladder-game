package com.boardgames.snakeLadder.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;

    @Before
    public void setUp() {
        List<Snake> snakes = new ArrayList<Snake>();
        Snake snake = new Snake(8,4);
        snakes.add(snake);
        game = new GameBuilder().withBoard(new Board(snakes,100)).buildGame();
    }


    @Test
    public void testUpdatePositionOnBoard() {
        Player player = new Player("testPlayer");
        player.setPosition(4);
        game.updatePlayerPositionOnBoard(player, 4);
        assertEquals("Player position has been updated as player is bitten by snake", 4, player.getPosition());
    }

}