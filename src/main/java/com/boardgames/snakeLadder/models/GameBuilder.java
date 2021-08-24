package com.boardgames.snakeLadder.models;

import com.boardgames.snakeLadder.exceptions.GameException;

import java.util.ArrayList;
import java.util.List;

import static com.boardgames.snakeLadder.Constants.*;

public class GameBuilder {

    private Player player;
    private Dice dice;
    private Board board;
    private int rounds;

    public GameBuilder() {
        player = new Player("Computer");
        dice = new Dice();
        board = new Board(getDefaultListOfSnakes(), DEFAULT_BOARD_SIZE);
        rounds = DEFAULT_ROUNDS;
    }

    public Player getPlayer() {
        return player;
    }

    public GameBuilder withPlayer(Player player) {
        this.player = player;
        return this;
    }

    public Dice getDice() {
        return dice;
    }

    public GameBuilder withDice(Dice dice) {
        this.dice = dice;
        return this;
    }

    public Board getBoard() {
        return board;
    }

    public GameBuilder withBoard(Board board) {
        this.board = board;
        return this;
    }

    public int getRounds() {
        return rounds;
    }

    public GameBuilder withRounds(int rounds) {
        this.rounds = rounds;
        return this;
    }

    public Game buildGame() throws GameException {
       Game game = new Game(this);
       validateGame(game);
       return game;
    }

    private void validateGame(Game game) {
        Board board = game.getBoard();
        int boardSize = board.getBoardSize();
        if(boardSize < 1 || boardSize > 10000) {
            throw new GameException("Invalid board size");
        }
        for(Snake snake : board.getSnakes()) {
            if(snake.getStartPosition() < snake.getEndPosition()) {
                throw new GameException("Start position should be greater than end position");
            }
        }
    }

    private List<Snake> getDefaultListOfSnakes() {
        List<Snake> snakes = new ArrayList<Snake>();
        Snake snake1 = new Snake(SNAKE1_START_POSITION, SNAKE1_END_POSITION);
        snakes.add(snake1);
        return snakes;
    }

}
