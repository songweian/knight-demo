package com.knight.demo.biz.cardgame;

import java.util.ArrayList;
import java.util.List;

public class CardMaker {

    private static final String[] NUMBERS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final String[] SYMBOLS = {"@", "#", "^", "*"};


    public List<Card> makeCards() {
        ArrayList<Card> cards = new ArrayList<>(NUMBERS.length * SYMBOLS.length);
        for (String number : NUMBERS) {
            for (String symbol : SYMBOLS) {
                cards.add(new Card(number, symbol));
            }
        }
        return cards;
    }
}
