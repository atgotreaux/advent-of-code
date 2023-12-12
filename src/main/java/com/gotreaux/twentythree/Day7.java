package com.gotreaux.twentythree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day7 {
    private final List<Hand> hands = new ArrayList<>();
    private enum Card {
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

        public static Card fromLabel(char label) {
            for (Card card : Card.values()) {
                if (card.label == label) {
                    return card;
                }
            }
            return null;
        }

        public char getLabel() {
            return this.label;
        }
    }

    private enum HandType {
        HIGH_CARD(cards -> cards.size() == cards.stream().distinct().count()),
        ONE_PAIR(cards -> cards.size() - 1 == cards.stream().distinct().count()),
        TWO_PAIR(cards -> {
            int pairs = 0;

            Map<Character, List<Card>> mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));
            for (Map.Entry<Character, List<Card>> entry : mapping.entrySet()) {
                List<Card> kind = entry.getValue();
                if (kind.size() == 2) {
                    pairs++;
                }
            }

            return pairs == 2;
        }),
        THREE_OF_A_KIND(cards -> {
            Map<Character, List<Card>> mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));
            for (Map.Entry<Character, List<Card>> entry : mapping.entrySet()) {
                List<Card> kind = entry.getValue();
                if (kind.size() == 3) {
                    return true;
                }
            }
            return false;
        }),
        FULL_HOUSE(cards -> {
            boolean foundThreeKind = false;
            boolean foundTwoKind = false;

            Map<Character, List<Card>> mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));
            for (Map.Entry<Character, List<Card>> entry : mapping.entrySet()) {
                List<Card> kind = entry.getValue();
                if (kind.size() == 2) {
                    foundTwoKind = true;
                }
                if (kind.size() == 3) {
                    foundThreeKind = true;
                }
            }

            return foundThreeKind && foundTwoKind;
        }),
        FOUR_OF_A_KIND(cards -> {
            Map<Character, List<Card>> mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));
            for (Map.Entry<Character, List<Card>> entry : mapping.entrySet()) {
                List<Card> kind = entry.getValue();
                if (kind.size() == 4) {
                    return true;
                }
            }
            return false;
        }),
        FIVE_OF_A_KIND(cards -> cards.stream().distinct().count() == 1);

        private final Predicate<List<Card>> criterion;

        HandType(Predicate<List<Card>> criterion) {
            this.criterion = criterion;
        }

        public static HandType fromCards(List<Card> cards) {
            List<HandType> handTypes = Arrays.asList(HandType.values());
            Collections.reverse(handTypes);

            for (HandType hand : handTypes) {
                if (hand.criterion.test(cards)) {
                    return hand;
                }
            }
            return null;
        }
    }

    private record Hand(List<Card> cards, HandType handType, long bid) implements Comparable<Hand> {
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
        @Override
        public int compareTo(Hand other) {
            return Comparator.comparing(Hand::handType)
                    .thenComparing(Hand::getFirstCard)
                    .thenComparing(Hand::getSecondCard)
                    .thenComparing(Hand::getThirdCard)
                    .thenComparing(Hand::getFourthCard)
                    .thenComparing(Hand::getFifthCard)
                    .compare(this, other);
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = Day7.class.getClassLoader().getResource("com/gotreaux/twentythree/7.txt");
        if (resource == null) {
            System.out.println("Could not find input file");
            return;
        }

        Path path = Path.of(resource.toURI());

        Day7 day7 = new Day7(path);

        System.out.println(day7.getWinnings());
    }

    public Day7(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                String[] cardsAndBid = line.split(" ");
                String cardLabels = cardsAndBid[0];
                long bid = Long.parseLong(cardsAndBid[1]);

                List<Card> cards = new ArrayList<>();
                for (Character cardLabel : cardLabels.toCharArray()) {
                    cards.add(Card.fromLabel(cardLabel));
                }

                HandType handType = HandType.fromCards(cards);

                hands.add(new Hand(cards, handType, bid));
            });
        }
    }

    public long getWinnings() {
        long winnings = 0;
        Collections.sort(hands);

        long rank = 1;
        for (Hand hand : hands) {
            winnings += rank * hand.bid;
            rank++;
        }

        return winnings;
    }
}
