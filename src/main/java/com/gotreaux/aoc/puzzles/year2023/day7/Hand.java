package com.gotreaux.aoc.puzzles.year2023.day7;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Hand implements Comparable<Hand> {
    private final List<Card> cards;
    private final int bid;
    private final HandType handType;

    Hand(List<Card> cards, int bid) {
        this.cards = cards;
        this.bid = bid;
        this.handType = HandType.fromCards(cards);
    }

    private Card getFirstCard() {
        return cards.getFirst();
    }

    private Card getSecondCard() {
        return cards.get(1);
    }

    private Card getThirdCard() {
        return cards.get(2);
    }

    private Card getFourthCard() {
        return cards.get(3);
    }

    private Card getFifthCard() {
        return cards.get(4);
    }

    int getBid() {
        return bid;
    }

    private HandType getHandType() {
        return handType;
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

    @Override
    public boolean equals(Object o) {
        return o instanceof Hand && compareTo((Hand) o) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, bid, handType);
    }
}
