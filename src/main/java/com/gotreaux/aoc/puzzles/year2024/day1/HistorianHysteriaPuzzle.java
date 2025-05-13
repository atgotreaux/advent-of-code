package com.gotreaux.aoc.puzzles.year2024.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class HistorianHysteriaPuzzle extends Puzzle {

    public HistorianHysteriaPuzzle() {
        super(2024, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var input = inputReader.getInputList();

        List<Integer> first = new ArrayList<>(input.size());
        List<Integer> second = new ArrayList<>(input.size());
        Map<Integer, Integer> countMapping = new HashMap<>();

        for (var line : input) {
            var scanner = new Scanner(line);
            first.add(scanner.nextInt());

            var secondValue = scanner.nextInt();
            second.add(secondValue);
            countMapping.merge(secondValue, 1, Integer::sum);

            scanner.close();
        }

        Collections.sort(first);
        Collections.sort(second);

        var sumOfDistances =
                IntStream.range(0, first.size())
                        .map(i -> Math.abs(first.get(i) - second.get(i)))
                        .sum();

        var sumOfSimilarityScores =
                first.stream().mapToInt(i -> i * countMapping.getOrDefault(i, 0)).sum();

        return new PuzzleOutput<>(sumOfDistances, sumOfSimilarityScores);
    }
}
