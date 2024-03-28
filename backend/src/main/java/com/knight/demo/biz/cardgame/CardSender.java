package com.knight.demo.biz.cardgame;

import java.util.List;

public class CardSender {


    public void sendCard(List<Card> cards, List<CardPlayer> cardPlayers) {
        for (int i = 0; i < cards.size(); ) {
            for (CardPlayer player : cardPlayers) {
                int cardIndex = i++;
                player.receiveCard(cards.get(cardIndex));
            }
        }
    }
}
