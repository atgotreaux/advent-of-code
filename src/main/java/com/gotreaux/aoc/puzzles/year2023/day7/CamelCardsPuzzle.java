package com.gotreaux.aoc.puzzles.year2023.day7;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

@ShellPuzzle(year = 2023, day = 7, title = "Camel Cards")
public class CamelCardsPuzzle extends Puzzle {

    public CamelCardsPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        List<Hand> hands = new ArrayList<>();
        List<Hand> jokerHands = new ArrayList<>();

        for (String line : getInputProvider().getInputList()) {
            Scanner scanner = new Scanner(line);
            String cardLabels = scanner.next();
            int bid = scanner.nextInt();
            scanner.close();

            List<Card> cards = new ArrayList<>();
            List<Card> jokerCards = new ArrayList<>();
            for (int i = 0; i < cardLabels.length(); i++) {
                cards.add(Card.fromLabel(cardLabels.charAt(i), Card.JOKER));
                jokerCards.add(Card.fromLabel(cardLabels.charAt(i), Card.JACK));
            }

            hands.add(new Hand(cards, bid));
            jokerHands.add(new Hand(jokerCards, bid));
        }

        Collections.sort(hands);
        Collections.sort(jokerHands);

        return new PuzzleOutput<>(calculateWinnings(hands), calculateWinnings(jokerHands));
    }

    private int calculateWinnings(List<Hand> processingHands) {
        return IntStream.range(1, processingHands.size() + 1)
                .map(rank -> rank * processingHands.get(rank - 1).getBid())
                .sum();
    }
}
