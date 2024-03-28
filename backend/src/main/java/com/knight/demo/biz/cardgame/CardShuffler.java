package com.knight.demo.biz.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardShuffler {

    private List<Card> cardList;

    public List<Card> shuffle(List<Card> cards) {
        ArrayList<Card> shuffledCards = new ArrayList<>(cards);
        Collections.shuffle(shuffledCards);
        return shuffledCards;
    }


}
