package com.gotreaux.aoc.puzzles.year2023.day7;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Card {
    JOKER('J'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private final char label;

    Card(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

    static Card fromLabel(char label, Card... cardsToExclude) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(card -> !Arrays.asList(cardsToExclude).contains(card))
                .filter(card -> card.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }
}
