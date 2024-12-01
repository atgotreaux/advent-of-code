package com.gotreaux.aoc.puzzles.year2024.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<Location> first = new ArrayList<>();
        List<Location> second = new ArrayList<>();

        List<String> input = inputReader.getInputList();
        for (String line : input) {
            Scanner scanner = new Scanner(line);
            first.add(new Location(scanner.nextInt()));
            second.add(new Location(scanner.nextInt()));
            scanner.close();
        }

        Collections.sort(first);
        Collections.sort(second);

        int sumOfDistances =
                IntStream.range(0, first.size())
                        .map(i -> Math.abs(first.get(i).id() - second.get(i).id()))
                        .sum();

        int sumOfSimilarityScores =
                first.stream().mapToInt(location -> location.getSimilarityScore(second)).sum();

        return new PuzzleOutput<>(sumOfDistances, sumOfSimilarityScores);
    }
}
