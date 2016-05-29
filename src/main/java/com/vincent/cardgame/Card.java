package com.vincent.cardgame;

/**
 * Created by Vincent on 16-5-28.
 */
public class Card implements Comparable<Card> {
    private String type;
    private int point;

    public Card(String type, int point) {
        this.type = type;
        this.point = point;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.point, card.point);
    }
}
