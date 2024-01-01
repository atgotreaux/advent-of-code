package com.gotreaux.year2023.day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum HandType {
    HIGH_CARD(
            cards ->
                    cards.size() == cards.stream().distinct().count()
                            && !cards.contains(Card.JOKER)),
    ONE_PAIR(
            cards ->
                    cards.size() - 1 == cards.stream().distinct().count()
                            || cards.contains(Card.JOKER)),
    TWO_PAIR(
            cards -> {
                int pairs = 0;

                Map<Character, List<Card>> mapping =
                        cards.stream().collect(Collectors.groupingBy(Card::getLabel));

                for (Map.Entry<Character, List<Card>> entry : mapping.entrySet()) {
                    List<Card> kind = entry.getValue();
                    if (kind.size() == 2) {
                        pairs++;
                    }
                }

                if (pairs == 2) {
                    return true;
                }

                int jokerCount =
                        cards.contains(Card.JOKER) ? mapping.get(Card.JOKER.getLabel()).size() : 0;

                return pairs == 1 && jokerCount == 1;
            }),
    THREE_OF_A_KIND(
            cards -> {
                Map<Character, List<Card>> mapping =
                        cards.stream().collect(Collectors.groupingBy(Card::getLabel));
                int jokerOffset =
                        cards.contains(Card.JOKER) ? mapping.get(Card.JOKER.getLabel()).size() : 0;

                for (Map.Entry<Character, List<Card>> entry : mapping.entrySet()) {
                    List<Card> kind = entry.getValue();
                    if (kind.getFirst() != Card.JOKER && kind.size() == 3 - jokerOffset) {
                        return true;
                    }
                }
                return false;
            }),
    FULL_HOUSE(
            cards -> {
                boolean foundThreeKind = false;
                boolean foundTwoKind = false;

                Map<Character, List<Card>> mapping =
                        cards.stream().collect(Collectors.groupingBy(Card::getLabel));
                for (Map.Entry<Character, List<Card>> entry : mapping.entrySet()) {
                    List<Card> kind = entry.getValue();
                    if (kind.size() == 2) {
                        foundTwoKind = true;
                    }
                    if (kind.size() == 3) {
                        foundThreeKind = true;
                    }
                }
                if (foundThreeKind && foundTwoKind) {
                    return true;
                }

                return mapping.size() == 3 && cards.contains(Card.JOKER);
            }),
    FOUR_OF_A_KIND(
            cards -> {
                Map<Character, List<Card>> mapping =
                        cards.stream().collect(Collectors.groupingBy(Card::getLabel));
                int jokerOffset =
                        cards.contains(Card.JOKER) ? mapping.get(Card.JOKER.getLabel()).size() : 0;

                for (Map.Entry<Character, List<Card>> entry : mapping.entrySet()) {
                    List<Card> kind = entry.getValue();
                    if (kind.getFirst() != Card.JOKER && kind.size() == 4 - jokerOffset) {
                        return true;
                    }
                }
                return false;
            }),
    FIVE_OF_A_KIND(
            cards -> {
                if (cards.stream().distinct().count() == 1) {
                    return true;
                }

                Map<Character, List<Card>> mapping =
                        cards.stream().collect(Collectors.groupingBy(Card::getLabel));
                return mapping.size() == 2 && cards.contains(Card.JOKER);
            });

    @SuppressWarnings("ImmutableEnumChecker")
    private final Predicate<List<Card>> criterion;

    HandType(Predicate<List<Card>> criterion) {
        this.criterion = criterion;
    }

    public static HandType fromCards(List<Card> cards) throws NoSuchElementException {
        return Arrays.stream(HandType.values())
                .sorted(Collections.reverseOrder())
                .filter(handType -> handType.criterion.test(cards))
                .findFirst()
                .orElseThrow();
    }
}
