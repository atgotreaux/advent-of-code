package com.gotreaux.aoc.puzzles.year2023.day7;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ShellPuzzle(year = 2023, day = 7, title = "Camel Cards")
public class CamelCardsPuzzle extends Puzzle {

    private final List<Hand> hands = new ArrayList<>();
    private final List<Hand> jokerHands = new ArrayList<>();

    public CamelCardsPuzzle(InputProvider inputProvider) throws Exception {
        super(inputProvider);

        prepare();
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(
                    line -> {
                        Scanner scanner = new Scanner(line);
                        String cardLabels = scanner.next();
                        long bid = scanner.nextLong();
                        scanner.close();

                        List<Card> cards = new ArrayList<>();
                        List<Card> jokerCards = new ArrayList<>();
                        for (int i = 0; i < cardLabels.length(); i++) {
                            cards.add(Card.fromLabel(cardLabels.charAt(i), Card.JOKER));
                            jokerCards.add(Card.fromLabel(cardLabels.charAt(i), Card.JACK));
                        }

                        hands.add(new Hand(cards, bid));
                        jokerHands.add(new Hand(jokerCards, bid));
                    });
        }

        Collections.sort(hands);
        Collections.sort(jokerHands);
    }

    @Override
    public Long getPartOne() {
        return calculateWinnings(hands);
    }

    @Override
    public Long getPartTwo() {
        return calculateWinnings(jokerHands);
    }

    private long calculateWinnings(List<Hand> processingHands) {
        return IntStream.range(1, processingHands.size() + 1)
                .mapToLong(rank -> rank * processingHands.get(rank - 1).getBid())
                .sum();
    }
}
