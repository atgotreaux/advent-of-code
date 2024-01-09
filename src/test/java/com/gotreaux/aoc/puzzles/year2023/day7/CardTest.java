package com.gotreaux.aoc.puzzles.year2023.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void parseJoker() {
        assertEquals(Card.JOKER, Card.fromLabel('J', Card.JACK));
    }

    @Test
    void parseTwo() {
        assertEquals(Card.TWO, Card.fromLabel('2'));
    }

    @Test
    void parseThree() {
        assertEquals(Card.THREE, Card.fromLabel('3'));
    }

    @Test
    void parseFour() {
        assertEquals(Card.FOUR, Card.fromLabel('4'));
    }

    @Test
    void parseFive() {
        assertEquals(Card.FIVE, Card.fromLabel('5'));
    }

    @Test
    void parseSix() {
        assertEquals(Card.SIX, Card.fromLabel('6'));
    }

    @Test
    void parseSeven() {
        assertEquals(Card.SEVEN, Card.fromLabel('7'));
    }

    @Test
    void parseEight() {
        assertEquals(Card.EIGHT, Card.fromLabel('8'));
    }

    @Test
    void parseNine() {
        assertEquals(Card.NINE, Card.fromLabel('9'));
    }

    @Test
    void parseTen() {
        assertEquals(Card.TEN, Card.fromLabel('T'));
    }

    @Test
    void parseJack() {
        assertEquals(Card.JACK, Card.fromLabel('J', Card.JOKER));
    }

    @Test
    void parseQueen() {
        assertEquals(Card.QUEEN, Card.fromLabel('Q'));
    }

    @Test
    void parseKing() {
        assertEquals(Card.KING, Card.fromLabel('K'));
    }

    @Test
    void parseAce() {
        assertEquals(Card.ACE, Card.fromLabel('A'));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Card.fromLabel('X'));
    }
}
