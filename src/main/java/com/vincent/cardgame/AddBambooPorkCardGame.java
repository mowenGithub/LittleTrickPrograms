package com.vincent.cardgame;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vincent on 16-5-29.
 * 接竹竿游戏
 * 规则：
 * 1.指定玩家
 * 2.向各个玩家发牌
 * 3.依次进行接牌
 * 4.直到有点数相同的牌就将其之间的牌收回到最后接的那个玩家，并且其玩家洗牌继续接牌,并且大小Jack是相同点数
 * 5.直到只有一个玩家有牌为止为赢家
 */
public class AddBambooPorkCardGame extends CardGame {
    private List<Player> players;
    private List<Card> deskCards;
    //该第几个play出牌
    private int indexPlayer;

    public AddBambooPorkCardGame(List<Player> players, List<Card> deskCards) {
        if((players == null || players.size() == 0) || (deskCards == null || deskCards.size() == 0)) {
            throw new IllegalArgumentException();
        }
        this.players = players;
        this.deskCards = deskCards;
    }

    @Override
    public void prepareCardGame() {
        System.out.println("shuffle before: " + deskCards);
        shuffle(deskCards);
        System.out.println("shuffle after: " + deskCards);

        handOutCards();

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + " : " + players.get(i).getHandCards());
        }

        indexPlayer = 0;
    }

    @Override
    public void beginCardGame() {
        while (true) {
            deskCards.add(players.get(indexPlayer).getHandCards().remove(0));
            int indexStart = shouldGetCardsFromDesk();
            if(indexStart != -1) {
                getCardsFromDesk(indexStart, deskCards.size());
                shuffle(players.get(indexPlayer).getHandCards());
            } else {
                if(players.get(indexPlayer).getHandCards().size() == 0) {
                    players.remove(indexPlayer);
                    indexPlayer = indexPlayer % players.size();
                    if(players.size() == 1) {
                        printHandCardsAndDeskCards();
                        return;
                    }
                } else {
                    indexPlayer = ++indexPlayer % players.size();
                }
            }

            printHandCardsAndDeskCards();
        }
    }

    @Override
    public Player getWinner() {
        return players.get(0);
    }

    /**
     * 洗牌
     * @param cards
     */
    private void shuffle(List<Card> cards) {
        Collections.shuffle(cards);
    }

    /**
     * 发牌
     */
    private void handOutCards() {
        Iterator<Card> iterator = deskCards.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            players.get(index).getHandCards().add(iterator.next());
            iterator.remove();
            index = ++index % players.size();
        }
    }

    private int shouldGetCardsFromDesk() {
        Card lastCard = deskCards.get(deskCards.size() - 1);
        for(int i = deskCards.size() - 2; i >= 0; i--) {
            if(lastCard.compareTo(deskCards.get(i)) == 0) {
                return i;
            }
        }
        return -1;
    }

    private void getCardsFromDesk(int indexStart, int indexEnd) {
        List<Card> shouldGetCards = deskCards.subList(indexStart, indexEnd);
        players.get(indexPlayer).getHandCards().addAll(shouldGetCards);
        deskCards.removeAll(shouldGetCards);
    }

    private void printHandCardsAndDeskCards() {
        System.out.println("****************Cards Info*********************");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + " : " + players.get(i).getHandCards());
        }
        System.out.println("DeskCards : " + deskCards);
    }
}
