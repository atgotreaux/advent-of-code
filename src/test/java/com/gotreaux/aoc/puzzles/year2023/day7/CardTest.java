package com.gotreaux.aoc.puzzles.year2023.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CardTest {
    @ParameterizedTest
    @MethodSource("provideParseCard")
    void parseCard(char label, Card expectedCard) {
        assertEquals(expectedCard, Card.of(label));
    }

    @Test
    void parseJoker() {
        assertEquals(Card.JOKER, Card.of('J', Card.JACK));
    }

    @Test
    void parseJack() {
        assertEquals(Card.JACK, Card.of('J', Card.JOKER));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Card.of('X'));
    }

    private static Stream<Arguments> provideParseCard() {
        return Stream.of(
                Arguments.of('2', Card.TWO),
                Arguments.of('3', Card.THREE),
                Arguments.of('4', Card.FOUR),
                Arguments.of('5', Card.FIVE),
                Arguments.of('6', Card.SIX),
                Arguments.of('7', Card.SEVEN),
                Arguments.of('8', Card.EIGHT),
                Arguments.of('9', Card.NINE),
                Arguments.of('T', Card.TEN),
                Arguments.of('Q', Card.QUEEN),
                Arguments.of('K', Card.KING),
                Arguments.of('A', Card.ACE));
    }
}
