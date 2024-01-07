package com.gotreaux.puzzles.year2023.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

public class HandTest {

    @Test
    void jacksOrdering() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Hand handOne =
                new Hand(
                        Arrays.asList(Card.THREE, Card.TWO, Card.TEN, Card.THREE, Card.KING),
                        generator.nextLong());

        Hand handTwo =
                new Hand(
                        Arrays.asList(Card.TEN, Card.FIVE, Card.FIVE, Card.JACK, Card.FIVE),
                        generator.nextLong());

        Hand handThree =
                new Hand(
                        Arrays.asList(Card.KING, Card.KING, Card.SIX, Card.SEVEN, Card.SEVEN),
                        generator.nextLong());

        Hand handFour =
                new Hand(
                        Arrays.asList(Card.KING, Card.TEN, Card.JACK, Card.JACK, Card.TEN),
                        generator.nextLong());

        Hand handFive =
                new Hand(
                        Arrays.asList(Card.QUEEN, Card.QUEEN, Card.QUEEN, Card.JACK, Card.ACE),
                        generator.nextLong());

        List<Hand> hands =
                new ArrayList<>(Arrays.asList(handOne, handTwo, handThree, handFour, handFive));
        Collections.sort(hands);

        assertEquals(handOne, hands.getFirst());
        assertEquals(handFour, hands.get(1));
        assertEquals(handThree, hands.get(2));
        assertEquals(handTwo, hands.get(3));
        assertEquals(handFive, hands.get(4));
    }

    @Test
    void jokersOrdering() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Hand handOne =
                new Hand(
                        Arrays.asList(Card.THREE, Card.TWO, Card.TEN, Card.THREE, Card.KING),
                        generator.nextLong());

        Hand handTwo =
                new Hand(
                        Arrays.asList(Card.TEN, Card.FIVE, Card.FIVE, Card.JOKER, Card.FIVE),
                        generator.nextLong());

        Hand handThree =
                new Hand(
                        Arrays.asList(Card.KING, Card.KING, Card.SIX, Card.SEVEN, Card.SEVEN),
                        generator.nextLong());

        Hand handFour =
                new Hand(
                        Arrays.asList(Card.KING, Card.TEN, Card.JOKER, Card.JOKER, Card.TEN),
                        generator.nextLong());

        Hand handFive =
                new Hand(
                        Arrays.asList(Card.QUEEN, Card.QUEEN, Card.QUEEN, Card.JOKER, Card.ACE),
                        generator.nextLong());

        List<Hand> hands =
                new ArrayList<>(Arrays.asList(handOne, handTwo, handThree, handFour, handFive));
        Collections.sort(hands);

        assertEquals(handOne, hands.getFirst());
        assertEquals(handThree, hands.get(1));
        assertEquals(handTwo, hands.get(2));
        assertEquals(handFive, hands.get(3));
        assertEquals(handFour, hands.get(4));
    }
}
