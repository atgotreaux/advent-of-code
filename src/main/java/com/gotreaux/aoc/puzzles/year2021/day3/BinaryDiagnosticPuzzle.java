package com.gotreaux.aoc.puzzles.year2021.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BinaryDiagnosticPuzzle extends Puzzle {

    public BinaryDiagnosticPuzzle() {
        super(2021, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException, NoSuchElementException, NumberFormatException {
        List<String> input = inputReader.getInputList();
        int bitLength = input.getFirst().length();

        int gamma = 0;
        int epsilon = 0;
        List<String> oxygenCandidates = new ArrayList<>(input);
        List<String> co2Candidates = new ArrayList<>(input);
        for (int i = 0; i < bitLength; i++) {
            int position = i;
            int shift = 1 << Math.abs(i - bitLength + 1);
            if (getMostCommonBit(input, i) == 0) {
                epsilon |= shift;
            } else {
                gamma |= shift;
            }

            if (oxygenCandidates.size() > 1) {
                int oxyBit = getMostCommonBit(oxygenCandidates, i);
                oxygenCandidates.removeIf(s -> Character.digit(s.charAt(position), 10) != oxyBit);
            }
            if (co2Candidates.size() > 1) {
                int co2Bit = getMostCommonBit(co2Candidates, i);
                co2Candidates.removeIf(s -> Character.digit(s.charAt(position), 10) == co2Bit);
            }
        }

        int powerConsumption = gamma * epsilon;

        int oxygenGeneratorRating = Integer.parseInt(oxygenCandidates.getFirst(), 2);
        int co2ScrubberRating = Integer.parseInt(co2Candidates.getFirst(), 2);
        int lifeSupportRating = oxygenGeneratorRating * co2ScrubberRating;

        return new PuzzleOutput<>(powerConsumption, lifeSupportRating);
    }

    private static int getMostCommonBit(Collection<String> numbers, int position)
            throws NoSuchElementException {
        Comparator<Map.Entry<Integer, Long>> comparator =
                Map.Entry.<Integer, Long>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey());

        return numbers.stream()
                .mapToInt(s -> Character.digit(s.charAt(position), 10))
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(comparator)
                .orElseThrow()
                .getKey();
    }
}
