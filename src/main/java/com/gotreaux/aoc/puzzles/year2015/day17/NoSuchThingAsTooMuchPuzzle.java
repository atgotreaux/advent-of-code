package com.gotreaux.aoc.puzzles.year2015.day17;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.collection.CombinationsOfSum;
import com.gotreaux.aoc.utils.collection.UniqueCombinationElements;
import com.gotreaux.aoc.utils.collection.VariableCombinationLength;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class NoSuchThingAsTooMuchPuzzle extends Puzzle {

    public NoSuchThingAsTooMuchPuzzle() {
        super(2015, 17);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) throws Exception {
        List<Integer> containers = inputReader.getInputStream().map(Integer::parseInt).toList();

        CombinationsOfSum combinationsOfSum =
                new CombinationsOfSum(
                        150, VariableCombinationLength.YES, UniqueCombinationElements.YES);

        List<List<Integer>> combinations = combinationsOfSum.of(containers);

        int minContainers = combinations.stream().mapToInt(List::size).min().orElseThrow();

        long minContainersCombinations =
                combinations.stream()
                        .filter(combination -> combination.size() == minContainers)
                        .count();

        return new PuzzleOutput<>(combinations.size(), minContainersCombinations);
    }
}
