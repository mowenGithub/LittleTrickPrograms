package com.vincent.cardgame;

/**
 * Created by Vincent on 16-5-29.
 */
public abstract class CardGame {
    public abstract void prepareCardGame();
    public abstract void beginCardGame();
    public abstract Player getWinner();
}
