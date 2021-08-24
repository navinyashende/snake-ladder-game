package com.boardgames.snakeLadder.models;

import com.boardgames.snakeLadder.exceptions.GameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private Board board;
    private Player player;
    private Dice dice;
    private int rounds;

    private Boolean testMode;

    final BufferedReader reader;

    public Game(GameBuilder gameBuilder) {
        player = gameBuilder.getPlayer();
        board = gameBuilder.getBoard();
        dice = gameBuilder.getDice();
        rounds = gameBuilder.getRounds();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

    public Dice getDice() {
        return dice;
    }

    public int getRounds() {
        return rounds;
    }

    /**
     * Method to play the game
     * @throws IOException
     */
    public void play() throws GameException {
        try {
            int counter = 0;
            while(counter < rounds) {
                System.out.println("Press any key to roll the dice");
                reader.readLine();
                int diceRollResult = dice.roll();
                System.out.println("You have got " + diceRollResult + " on dice");
                if(diceRollResult < 6) {
                    counter++;
                }
                else {
                    System.out.println("Congratulations! You have got one free round");
                }
                if(player.getPosition() + diceRollResult > board.getBoardSize()) {
                    System.out.println("Oops! You cannot move from your position. Please try rolling the dice again");
                    continue;
                }
                updatePlayerPositionOnBoard(player, diceRollResult);
                if(hasPlayerWon(player)) {
                    System.out.println("Congratulations!!! You have won the game");
                    return;
                }
            }
            System.out.println("Out of moves. Better luck next time!!");
        }
        catch (Exception e) {
            throw new GameException(e.getMessage());
        }
    }


    /**
     * Method to exit the game
     */
    public void exit() {
        System.out.println("Exiting the game");
        System.exit(0);
    }
    /**
     * Method to update the player position on the board
     * @param player
     * @param diceRollResult
     */
    public void updatePlayerPositionOnBoard(Player player, int diceRollResult) {
        int newPosition = player.getPosition() + diceRollResult;
        System.out.println("Moving player " + player.getName() + " from " + player.getPosition() + " to " + newPosition);
        player.setPosition(newPosition);
        for(Snake snake : board.getSnakes()) {
            if(snake.getStartPosition() == newPosition) {
                System.out.println("Oops! You have been bitten by snake");
                newPosition = snake.getEndPosition();
                System.out.println("Moving player " + player.getName() + " from " + player.getPosition() + " to " + newPosition);
                player.setPosition(newPosition);
            }
        }
    }

    /**
     *  Method to check if the player has won
     * @param player
     * @return
     */
    private boolean hasPlayerWon(Player player) {
        if(player.getPosition() == board.getBoardSize()) {
            return true;
        }
        return false;
    }


}
