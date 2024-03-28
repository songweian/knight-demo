package com.knight.demo.biz.cardgame;

import java.util.ArrayList;
import java.util.List;

public class PlayGround {

    private CardMaker cardMaker;
    private CardSender cardSender;

    private List<Card> cards;

    private CardShuffler cardShuffler;

    private List<CardPlayer> cardPlayers;

    private Judger judger;

    public PlayGround() {
        this.cardMaker = new CardMaker();
        this.cardShuffler = new CardShuffler();
        this.cardSender = new CardSender();
        this.judger = new Judger();
        this.cardPlayers = new ArrayList<>();
        cardPlayers.add(new CardPlayer("A"));
        cardPlayers.add(new CardPlayer("B"));
        cardPlayers.add(new CardPlayer("C"));
        cardPlayers.add(new CardPlayer("D"));
    }

    public void play() {
        System.out.println("------Game Start------");
        printCards();
        printPlayerCards();

        System.out.println("------Game init------");
        initCards();
        printCards();
        printPlayerCards();

        System.out.println("------Game shuffle------");
        shuffleCards();
        printCards();
        printPlayerCards();

        System.out.println("------Game ready------");
        sendCards();
        printCards();
        printPlayerCards();

        System.out.println("------Game judge------");
        judgeWinner();
        printCards();
        printPlayerCards();
    }

    private void printCards() {
        System.out.println("Cards:" + Card.toString(cards));
    }

    public void printPlayerCards() {
        for (CardPlayer cardPlayer : cardPlayers) {
            System.out.println(cardPlayer.toString());
        }
    }

    private void initCards() {
        this.cards = this.cardMaker.makeCards();
    }

    private void shuffleCards() {
        cards = cardShuffler.shuffle(cards);
    }

    private void sendCards() {
        cardSender.sendCard(cards, cardPlayers);
    }

    private void judgeWinner() {
        this.judger.judgeWinner(cardPlayers);
        // judge winner
    }

    public static void main(String[] args) {
        PlayGround playGround = new PlayGround();
        playGround.play();
    }
}
