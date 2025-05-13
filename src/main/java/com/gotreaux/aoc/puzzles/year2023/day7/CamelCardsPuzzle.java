package com.gotreaux.aoc.puzzles.year2023.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class CamelCardsPuzzle extends Puzzle {

    public CamelCardsPuzzle() {
        super(2023, 7);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        Collection<String> input = inputReader.getInputList();

        List<Hand> hands = new ArrayList<>(input.size());
        List<Hand> jokerHands = new ArrayList<>(input.size());

        for (var line : input) {
            var scanner = new Scanner(line);
            var cardLabels = scanner.next();
            var bid = scanner.nextInt();
            scanner.close();

            List<Card> cards = new ArrayList<>(cardLabels.length());
            List<Card> jokerCards = new ArrayList<>(cardLabels.length());
            for (var i = 0; i < cardLabels.length(); i++) {
                cards.add(Card.of(cardLabels.charAt(i), Card.JOKER));
                jokerCards.add(Card.of(cardLabels.charAt(i), Card.JACK));
            }

            hands.add(new Hand(cards, bid));
            jokerHands.add(new Hand(jokerCards, bid));
        }

        Collections.sort(hands);
        Collections.sort(jokerHands);

        return new PuzzleOutput<>(calculateWinnings(hands), calculateWinnings(jokerHands));
    }

    private static int calculateWinnings(List<Hand> processingHands) {
        return IntStream.range(1, processingHands.size() + 1)
                .map(rank -> rank * processingHands.get(rank - 1).getBid())
                .sum();
    }
}
