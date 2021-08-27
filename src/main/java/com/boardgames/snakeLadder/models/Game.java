package com.boardgames.snakeLadder.models;

import com.boardgames.snakeLadder.exceptions.GameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    private Board board;
    private List<Player> players;
    private Dice dice;
    private int rounds;

    private Boolean testMode;

    final BufferedReader reader;

    public Game(GameBuilder gameBuilder) {
        players = gameBuilder.getPlayers();
        board = gameBuilder.getBoard();
        dice = gameBuilder.getDice();
        rounds = gameBuilder.getRounds();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
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
            Queue<Player> playerQueue = new LinkedList<>();
            for(Player player: getPlayers()) {
                playerQueue.add(player);
            }
            Player currPlayer = playerQueue.poll();
            while(currPlayer.getMoves() < rounds) {
               /* System.out.println("Press any key to roll the dice");
                reader.readLine();*/
                int diceRollResult = dice.roll();
                System.out.println("You have got " + diceRollResult + " on dice");
                if(diceRollResult < 6) {
                    currPlayer.setMoves(currPlayer.getMoves() + 1);
                }
                else {
                    System.out.println("Congratulations! You have got one free round");
                }
                if(currPlayer.getPosition() + diceRollResult > board.getBoardSize()) {
                    System.out.println("Oops! You cannot move from your position. Please try rolling the dice again");
                    continue;
                }
                updatePlayerPositionOnBoard(currPlayer, diceRollResult);
                if(hasPlayerWon(currPlayer)) {
                    System.out.println("Congratulations!!! You have won the game");
                    return;
                }
                playerQueue.add(currPlayer);
                currPlayer = playerQueue.poll();
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
