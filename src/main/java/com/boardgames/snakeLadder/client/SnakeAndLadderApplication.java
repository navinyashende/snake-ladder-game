package com.boardgames.snakeLadder.client;

import com.boardgames.snakeLadder.models.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to Snakes and Ladders");
            System.out.println("Enter your name:");
            String playerName = reader.readLine();
            Player player = new Player(playerName);
            Player computer = new Player("computer");
            List<Player> players = new ArrayList<>();
            players.add(player);
            players.add(computer);
            Dice dice = new CrookedDice();
            GreenSnake greenSnake = new GreenSnake(20,8);
            GreenSnake greenSnake1 = new GreenSnake(22, 14);
            GreenSnake greenSnake2 = new GreenSnake(30, 15);
            GreenSnake greenSnake3 = new GreenSnake(28, 18);
            List<Snake> snakes = new ArrayList<>();
            snakes.add(greenSnake);
            snakes.add(greenSnake1);
            snakes.add(greenSnake2);
            snakes.add(greenSnake3);
            snakes.add(new Snake(14,7));
            Board board = new Board(snakes, 100);
            Game game = new GameBuilder().withPlayers(players).withDice(dice).withBoard(board).withRounds(10).buildGame();
            game.play();
        } catch (Exception e) {
            System.out.println("An error occurred. Details = " + e.getMessage());
            System.exit(0);
        }

    }
}
