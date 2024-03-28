package com.knight.demo.biz.cardgame;

import java.util.ArrayList;
import java.util.List;

public class CardPlayer {
    private String playerName;
    private List<Card> cards;

    public CardPlayer(String playerName) {
        this.playerName = playerName;
        this.cards = new ArrayList<>();
    }

    public String toString() {
        return "Player " + this.playerName + " Cards: " + Card.toString(cards);
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public String getPlayerName() {
        return this.playerName;
    }
}
