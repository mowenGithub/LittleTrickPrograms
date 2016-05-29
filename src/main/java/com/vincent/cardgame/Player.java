package com.vincent.cardgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 16-5-29.
 * 玩家类
 */
public class Player {
    private String name;
    private List<Card> handCards;

    public Player(String name) {
        this.name = name;
        handCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(List<Card> cards) {
        this.handCards = cards;
    }

    public List<Card> getHandCards() {
        return handCards;
    }
}
