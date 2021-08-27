package com.boardgames.snakeLadder.models;

import com.boardgames.snakeLadder.exceptions.GameException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.boardgames.snakeLadder.Constants.DEFAULT_BOARD_SIZE;
import static com.boardgames.snakeLadder.Constants.DEFAULT_ROUNDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameBuilderTest {

    @Test
    public void testBuildGame() {
        Game game = new GameBuilder().buildGame();
        assertEquals("Board is configured with default size", DEFAULT_BOARD_SIZE, game.getBoard().getBoardSize());
        assertEquals("Game is configured with default rounds", DEFAULT_ROUNDS, game.getRounds());
//        assertEquals("Game has default player as computer", "Computer", game.getPlayers().getName());
    }

    @Test
    public void testCustomGameWithCrookedDice() {
        Game game = new GameBuilder().withDice(new CrookedDice()).buildGame();
        // Roll the dice two times because normal dice can return even number
        assertEquals("Game is configured with crooked dice", 0, game.getDice().roll() % 2 );
        assertTrue("Game is configured with crooked dice",  game.getDice().roll() % 2 ==0 );
    }

    @Test
    public void testCustomGame() {
        Game game = new GameBuilder().withRounds(200).withBoard(new Board(Collections.<Snake>emptyList(), 1000)).withDice(new Dice()).buildGame();
        assertEquals("Board is configured with custom size", 1000, game.getBoard().getBoardSize());
        assertEquals("Game is configured with custom rounds", 200, game.getRounds());
    }

    @Test(expected = GameException.class)
    public void testGameWithInvalidBoardSize() {
        Game game = new GameBuilder().withBoard(new Board(Collections.<Snake>emptyList(), -1)).buildGame();
    }

    @Test(expected = GameException.class)
    public void testGameWithInvalidSnakePositions() {
        List<Snake> snakes = new ArrayList<Snake>();
        Snake snake1 = new Snake(10,20);
        snakes.add(snake1);
        Board board = new Board(snakes, DEFAULT_BOARD_SIZE);
        Game game = new GameBuilder().withBoard(board).buildGame();
    }
}