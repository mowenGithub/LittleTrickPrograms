package com.vincent.cardgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 16-5-28.
 */
public class Main {

    public static void main(String[] args) {
        Player jack = new Player("Jack");
        Player tom = new Player("Tom");
        Player kate = new Player("kate");
        List<Player> players = new ArrayList<>();
        players.add(jack);
        players.add(tom);
        players.add(kate);

        List<Card> cards = AddBambooPorkCard.init54Card();

        CardGame cardGame = new AddBambooPorkCardGame(players, cards);
        cardGame.prepareCardGame();
        cardGame.beginCardGame();
        System.out.println("The Winner is " + cardGame.getWinner().getName());
    }
}
