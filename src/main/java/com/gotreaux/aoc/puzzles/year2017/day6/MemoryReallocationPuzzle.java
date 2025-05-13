package com.gotreaux.aoc.puzzles.year2017.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class MemoryReallocationPuzzle extends Puzzle {

    public MemoryReallocationPuzzle() {
        super(2017, 6);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var input = inputReader.getInputString();

        var scanner = new Scanner(input);
        List<Integer> banks = new ArrayList<>();
        while (scanner.hasNextInt()) {
            banks.add(scanner.nextInt());
        }
        scanner.close();

        Map<List<Integer>, Integer> distributions = new HashMap<>();
        int cycleSize;
        var cycles = 1;
        while (true) {
            var maxIndex = banks.indexOf(banks.stream().max(Integer::compareTo).orElseThrow());
            int max = banks.set(maxIndex, 0);

            while (max > 0) {
                maxIndex = (maxIndex + 1) % banks.size();
                banks.set(maxIndex, banks.get(maxIndex) + 1);
                max--;
            }

            if (distributions.containsKey(banks)) {
                cycleSize = cycles - distributions.get(banks);
                break;
            }
            distributions.put(banks, cycles);
            cycles++;
        }

        return new PuzzleOutput<>(cycles, cycleSize);
    }
}
