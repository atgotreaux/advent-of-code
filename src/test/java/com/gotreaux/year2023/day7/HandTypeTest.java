package com.gotreaux.year2023.day7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTypeTest {

    @Test
    void test32T3K() {
        List<Card> cards = Arrays.asList(Card.THREE, Card.TWO, Card.TEN, Card.THREE, Card.KING);

        HandType handType = HandType.fromCards(cards);

        assertEquals(HandType.ONE_PAIR, handType);
    }

    @Test
    void testT55Jack5() {
        List<Card> cards = Arrays.asList(Card.TEN, Card.FIVE, Card.FIVE, Card.JACK, Card.FIVE);

        HandType handType = HandType.fromCards(cards);

        assertEquals(HandType.THREE_OF_A_KIND, handType);
    }

    @Test
    void testKK677() {
        List<Card> cards = Arrays.asList(Card.KING, Card.KING, Card.SIX, Card.SEVEN, Card.SEVEN);

        HandType handType = HandType.fromCards(cards);

        assertEquals(HandType.TWO_PAIR, handType);
    }

    @Test
    void testKTJackJackT() {
        List<Card> cards = Arrays.asList(Card.KING, Card.TEN, Card.JACK, Card.JACK, Card.TEN);

        HandType handType = HandType.fromCards(cards);

        assertEquals(HandType.TWO_PAIR, handType);
    }

    @Test
    void testQQQJackA() {
        List<Card> cards = Arrays.asList(Card.QUEEN, Card.QUEEN, Card.QUEEN, Card.JACK, Card.ACE);

        HandType handType = HandType.fromCards(cards);

        assertEquals(HandType.THREE_OF_A_KIND, handType);
    }

    @Test
    void testT55Joker5() {
        List<Card> cards = Arrays.asList(Card.TEN, Card.FIVE, Card.FIVE, Card.JOKER, Card.FIVE);

        HandType handType = HandType.fromCards(cards);

        assertEquals(HandType.FOUR_OF_A_KIND, handType);
    }

    @Test
    void testKTJokerJokerT() {
        List<Card> cards = Arrays.asList(Card.KING, Card.TEN, Card.JOKER, Card.JOKER, Card.TEN);

        HandType handType = HandType.fromCards(cards);

        assertEquals(HandType.FOUR_OF_A_KIND, handType);
    }

    @Test
    void testQQQJokerA() {
        List<Card> cards = Arrays.asList(Card.QUEEN, Card.QUEEN, Card.QUEEN, Card.JOKER, Card.ACE);

        HandType handType = HandType.fromCards(cards);

        assertEquals(HandType.FOUR_OF_A_KIND, handType);
    }
}