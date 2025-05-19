package com.gotreaux.aoc.puzzles.year2021.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BinaryDiagnosticPuzzle extends Puzzle {

    public BinaryDiagnosticPuzzle() {
        super(2021, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var input = inputReader.getInputList();
        var bitLength = input.getFirst().length();

        var gamma = 0;
        var epsilon = 0;
        List<String> oxygenCandidates = new ArrayList<>(input);
        List<String> co2Candidates = new ArrayList<>(input);
        for (var i = 0; i < bitLength; i++) {
            var position = i;
            var shift = 1 << Math.abs(i - bitLength + 1);
            if (getMostCommonBit(input, i) == 0) {
                epsilon |= shift;
            } else {
                gamma |= shift;
            }

            if (oxygenCandidates.size() > 1) {
                var oxyBit = getMostCommonBit(oxygenCandidates, i);
                oxygenCandidates.removeIf(s -> Character.digit(s.charAt(position), 10) != oxyBit);
            }
            if (co2Candidates.size() > 1) {
                var co2Bit = getMostCommonBit(co2Candidates, i);
                co2Candidates.removeIf(s -> Character.digit(s.charAt(position), 10) == co2Bit);
            }
        }

        var powerConsumption = gamma * epsilon;

        var oxygenGeneratorRating = Integer.parseInt(oxygenCandidates.getFirst(), 2);
        var co2ScrubberRating = Integer.parseInt(co2Candidates.getFirst(), 2);
        var lifeSupportRating = oxygenGeneratorRating * co2ScrubberRating;

        return new PuzzleOutput<>(powerConsumption, lifeSupportRating);
    }

    private static int getMostCommonBit(Collection<String> numbers, int position) {
        var comparator =
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
