package com.boardgames.snakeLadder.models;

public class GreenSnake extends Snake{

    private boolean hasBitten;

    public GreenSnake(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }

    public boolean hasBitten() {
        return hasBitten;
    }

    public GreenSnake setHasBitten(boolean hasBitten) {
        this.hasBitten = hasBitten;
        return this;
    }

    @Override
    public void bite(Player player) {
        if(!this.hasBitten) {
            System.out.println("You have been bitten by snake. Moving player " + player.getName() + " from " + player.getPosition() + " to " + getEndPosition());
            player.setPosition(this.getEndPosition());
            this.hasBitten = true;
        }
    }
}
