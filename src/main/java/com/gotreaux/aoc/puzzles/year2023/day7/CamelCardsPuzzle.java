package com.gotreaux.aoc.puzzles.year2023.day7;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class CamelCardsPuzzle extends Puzzle {

    public CamelCardsPuzzle() {
        super(2023, 7);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException, NoSuchElementException {
        Collection<String> input = inputProvider.getInputList();

        List<Hand> hands = new ArrayList<>(input.size());
        List<Hand> jokerHands = new ArrayList<>(input.size());

        for (String line : input) {
            Scanner scanner = new Scanner(line);
            String cardLabels = scanner.next();
            int bid = scanner.nextInt();
            scanner.close();

            List<Card> cards = new ArrayList<>(cardLabels.length());
            List<Card> jokerCards = new ArrayList<>(cardLabels.length());
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

    private static int calculateWinnings(List<Hand> processingHands) {
        return IntStream.range(1, processingHands.size() + 1)
                .map(rank -> rank * processingHands.get(rank - 1).getBid())
                .sum();
    }
}
