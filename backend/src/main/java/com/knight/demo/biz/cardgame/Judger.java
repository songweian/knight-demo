package com.knight.demo.biz.cardgame;

import java.util.List;

public class Judger {

    public void judgeWinner(List<CardPlayer> cardPlayers) {
        CardPlayer winner = cardPlayers.get(0);
        for (CardPlayer cardPlayer : cardPlayers) {
            if (cardPlayer.getCards().size() > winner.getCards().size()) {
                winner = cardPlayer;
            }
        }
        System.out.println("Winner is " + winner.getPlayerName());
    }

}
