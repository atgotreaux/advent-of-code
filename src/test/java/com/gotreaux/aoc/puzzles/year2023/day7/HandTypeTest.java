package com.gotreaux.aoc.puzzles.year2023.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandTypeTest {
    @ParameterizedTest
    @MethodSource("provideParseType")
    void parseType(Card v, Card w, Card x, Card y, Card z, HandType expectedType) {
        List<Card> cards = List.of(v, w, x, y, z);

        assertEquals(expectedType, HandType.of(cards));
    }

    private static Stream<Arguments> provideParseType() {
        return Stream.of(
                Arguments.of(
                        Card.THREE, Card.TWO, Card.TEN, Card.THREE, Card.KING, HandType.ONE_PAIR),
                Arguments.of(
                        Card.TEN,
                        Card.FIVE,
                        Card.FIVE,
                        Card.JACK,
                        Card.FIVE,
                        HandType.THREE_OF_A_KIND),
                Arguments.of(
                        Card.KING, Card.KING, Card.SIX, Card.SEVEN, Card.SEVEN, HandType.TWO_PAIR),
                Arguments.of(
                        Card.KING, Card.TEN, Card.JACK, Card.JACK, Card.TEN, HandType.TWO_PAIR),
                Arguments.of(
                        Card.QUEEN,
                        Card.QUEEN,
                        Card.QUEEN,
                        Card.JACK,
                        Card.ACE,
                        HandType.THREE_OF_A_KIND),
                Arguments.of(
                        Card.TEN,
                        Card.FIVE,
                        Card.FIVE,
                        Card.JOKER,
                        Card.FIVE,
                        HandType.FOUR_OF_A_KIND),
                Arguments.of(
                        Card.KING,
                        Card.TEN,
                        Card.JOKER,
                        Card.JOKER,
                        Card.TEN,
                        HandType.FOUR_OF_A_KIND),
                Arguments.of(
                        Card.QUEEN,
                        Card.QUEEN,
                        Card.QUEEN,
                        Card.JOKER,
                        Card.ACE,
                        HandType.FOUR_OF_A_KIND));
    }
}
