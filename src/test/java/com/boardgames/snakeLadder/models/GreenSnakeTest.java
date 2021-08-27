package com.boardgames.snakeLadder.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreenSnakeTest {


    @Test
    public void testGreenSnakeBite() {
        Player player = new Player("TestPlayer");
        GreenSnake greenSnake = new GreenSnake(20, 8);
        greenSnake.bite(player);
        assertEquals("Player has been bitten first time", 8, player.getPosition());
        player.setPosition(20);
        assertEquals("Player has not been bitten second time", 20, player.getPosition());
    }
}