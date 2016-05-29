package com.vincent.cardgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 16-5-29.
 * 扑克牌
 */
public class AddBambooPorkCard extends Card {

    private static final String PORK_TYPE_A = "A";
    private static final String PORK_TYPE_J = "J";
    private static final String PORK_TYPE_Q = "Q";
    private static final String PORK_TYPE_K = "K";
    private static final String PORK_TYPE_BLACK_JOKER = "BLACK_JOKER";
    private static final String PORK_TYPE_RED_JOKER = "RED_JOKER";

    private static final String[] typeArray = {"黑桃", "红桃", "梅花", "方块"};
    private static final int[] pointArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public AddBambooPorkCard(String type, int point) {
        super(type, point);
    }

    public static List<Card> init54Card() {
        List<Card> cards = new ArrayList<>();
        for(String type : typeArray) {
            for(int point : pointArray) {
                cards.add(new AddBambooPorkCard(type, point));
            }
        }

//        cards.add(new AddBambooPorkCard(PORK_TYPE_BLACK_JOKER, Integer.MAX_VALUE - 1));
//        cards.add(new AddBambooPorkCard(PORK_TYPE_RED_JOKER, Integer.MAX_VALUE));
        return cards;
    }

    @Override
    public String toString() {
        if(getPoint() > 1 && getPoint() < 11) {
            return getType() + getPoint();
        } else {
            switch (super.getPoint()) {
                case 1: return getType() + PORK_TYPE_A;
                case 11: return getType() + PORK_TYPE_J;
                case 12: return getType() + PORK_TYPE_Q;
                case 13: return getType() + PORK_TYPE_K;
                case Integer.MAX_VALUE - 1: return PORK_TYPE_BLACK_JOKER;
                case Integer.MAX_VALUE: return PORK_TYPE_RED_JOKER;
                default: return null;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddBambooPorkCard)) return false;

        AddBambooPorkCard card = (AddBambooPorkCard) o;

        if((getType().equals(PORK_TYPE_BLACK_JOKER) || getType().equals(PORK_TYPE_RED_JOKER)) && (card.getType().equals(PORK_TYPE_BLACK_JOKER) || card.getType().equals(PORK_TYPE_RED_JOKER))) {
            return true;
        }
        return card.getPoint() == getPoint();
    }


}
