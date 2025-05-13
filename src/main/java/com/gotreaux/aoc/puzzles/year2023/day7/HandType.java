package com.gotreaux.aoc.puzzles.year2023.day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

enum HandType {
    HIGH_CARD(
            cards ->
                    cards.size() == Math.toIntExact(cards.stream().distinct().count())
                            && !cards.contains(Card.JOKER)),
    ONE_PAIR(
            cards ->
                    cards.size() - 1 == Math.toIntExact(cards.stream().distinct().count())
                            || cards.contains(Card.JOKER)),
    TWO_PAIR(
            cards -> {
                var pairs = 0;

                var mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));

                for (var entry : mapping.entrySet()) {
                    var kind = entry.getValue();
                    if (kind.size() == 2) {
                        pairs++;
                    }
                }

                if (pairs == 2) {
                    return true;
                }

                var jokerCount =
                        cards.contains(Card.JOKER) ? mapping.get(Card.JOKER.getLabel()).size() : 0;

                return pairs == 1 && jokerCount == 1;
            }),
    THREE_OF_A_KIND(
            cards -> {
                var mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));
                var jokerOffset =
                        cards.contains(Card.JOKER) ? mapping.get(Card.JOKER.getLabel()).size() : 0;

                for (var entry : mapping.entrySet()) {
                    var kind = entry.getValue();
                    if (kind.getFirst() != Card.JOKER && kind.size() == 3 - jokerOffset) {
                        return true;
                    }
                }
                return false;
            }),
    FULL_HOUSE(
            cards -> {
                var foundThreeKind = false;
                var foundTwoKind = false;

                var mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));
                for (var entry : mapping.entrySet()) {
                    var kind = entry.getValue();
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
                var mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));
                var jokerOffset =
                        cards.contains(Card.JOKER) ? mapping.get(Card.JOKER.getLabel()).size() : 0;

                for (var entry : mapping.entrySet()) {
                    var kind = entry.getValue();
                    if (kind.getFirst() != Card.JOKER && kind.size() == 4 - jokerOffset) {
                        return true;
                    }
                }
                return false;
            }),
    FIVE_OF_A_KIND(
            cards -> {
                if (cards.stream().distinct().count() == 1L) {
                    return true;
                }

                var mapping = cards.stream().collect(Collectors.groupingBy(Card::getLabel));
                return mapping.size() == 2 && cards.contains(Card.JOKER);
            });

    @SuppressWarnings("ImmutableEnumChecker")
    private final Predicate<List<Card>> criterion;

    HandType(Predicate<List<Card>> criterion) {
        this.criterion = criterion;
    }

    private Predicate<List<Card>> getCriterion() {
        return criterion;
    }

    static HandType of(List<Card> cards) {
        return Arrays.stream(values())
                .sorted(Collections.reverseOrder())
                .filter(handType -> handType.getCriterion().test(cards))
                .findFirst()
                .orElse(HIGH_CARD);
    }
}
