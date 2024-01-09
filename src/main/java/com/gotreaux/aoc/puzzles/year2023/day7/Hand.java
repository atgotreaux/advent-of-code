package com.gotreaux.aoc.puzzles.year2023.day7;

import java.util.Comparator;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;
    private final long bid;
    private final HandType handType;

    public Hand(List<Card> cards, long bid) {
        this.cards = cards;
        this.bid = bid;
        this.handType = HandType.fromCards(cards);
    }

    public Card getFirstCard() {
        return cards.getFirst();
    }

    public Card getSecondCard() {
        return cards.get(1);
    }

    public Card getThirdCard() {
        return cards.get(2);
    }

    public Card getFourthCard() {
        return cards.get(3);
    }

    public Card getFifthCard() {
        return cards.get(4);
    }

    public long getBid() {
        return this.bid;
    }

    public HandType getHandType() {
        return this.handType;
    }

    @Override
    public int compareTo(Hand other) {
        return Comparator.comparing(Hand::getHandType)
                .thenComparing(Hand::getFirstCard)
                .thenComparing(Hand::getSecondCard)
                .thenComparing(Hand::getThirdCard)
                .thenComparing(Hand::getFourthCard)
                .thenComparing(Hand::getFifthCard)
                .compare(this, other);
    }
}
