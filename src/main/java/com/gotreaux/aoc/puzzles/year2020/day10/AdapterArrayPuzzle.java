package com.gotreaux.aoc.puzzles.year2020.day10;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class AdapterArrayPuzzle extends Puzzle {

    public AdapterArrayPuzzle() {
        super(2020, 10);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) {
        var adapters = inputReader.getInputList().stream().map(Integer::valueOf).sorted().toList();

        var jolts = 0;
        var oneJoltDifferences = 0;
        var threeJoltDifferences = 1;
        for (var adapter : adapters) {
            var diff = adapter - jolts;
            if (diff == 1) {
                oneJoltDifferences++;
            } else if (diff == 3) {
                threeJoltDifferences++;
            }
            jolts = adapter;
        }
        var productOfDifferences = oneJoltDifferences * threeJoltDifferences;

        var joltageChain =
                Stream.concat(
                                Stream.concat(Stream.of(0), adapters.stream()),
                                Stream.of(adapters.getLast() + 3))
                        .toList();

        Map<Integer, Long> arrangements = new HashMap<>(joltageChain.size());
        arrangements.put(0, 1L);
        for (var i = 1; i < joltageChain.size(); i++) {
            var joltage = joltageChain.get(i);
            var count = 0L;
            count += arrangements.getOrDefault(joltage - 1, 0L);
            count += arrangements.getOrDefault(joltage - 2, 0L);
            count += arrangements.getOrDefault(joltage - 3, 0L);
            arrangements.put(joltage, count);
        }
        var numberOfArrangements = arrangements.get(joltageChain.getLast());

        return new PuzzleOutput<>(productOfDifferences, numberOfArrangements);
    }
}
