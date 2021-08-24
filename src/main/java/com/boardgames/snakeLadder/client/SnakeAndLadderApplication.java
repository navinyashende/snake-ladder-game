package com.boardgames.snakeLadder.client;

import com.boardgames.snakeLadder.models.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to Snakes and Ladders");
            System.out.println("Enter your name:");
            String playerName = reader.readLine();
            Player player = new Player(playerName);
            Dice dice = new CrookedDice();
            Game game = new GameBuilder().withPlayer(player).withDice(dice).withRounds(10).buildGame();
            game.play();
        } catch (Exception e) {
            System.out.println("An error occurred. Details = " + e.getMessage());
            System.exit(0);
        }

    }
}
