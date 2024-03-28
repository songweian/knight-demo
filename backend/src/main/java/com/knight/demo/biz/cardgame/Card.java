package com.knight.demo.biz.cardgame;

import lombok.Data;

import java.util.List;

@Data
public class Card implements Comparable<Card> {

    private String number;
    private String symbol;


    public Card(String number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    @Override
    public int compareTo(Card o) {
        // compare number
        // compare symbol
        if (this.number.equals(o.number)) {
            return this.symbol.compareTo(o.symbol);
        }
        return this.number.compareTo(o.number);
    }

    public String toString() {
        return number + symbol + " ";
    }

    public static String toString(List<Card> cards) {
        if (cards == null || cards.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        for (Card card : cards) {
            sb.append(", ").append(card.toString());
        }
        // remove first ','
        sb.deleteCharAt(0);
        sb.append("]");
        return sb.toString();
    }


}
