package com.gotreaux.aoc.puzzles.year2022.day1;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CalorieCountingPuzzle extends Puzzle {

    public CalorieCountingPuzzle() {
        super(2022, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException, NumberFormatException {
        int elfIndex = 0;
        Map<Integer, Integer> elfCalorieCarriage = new HashMap<>();

        for (String line : inputProvider.getInputList()) {
            if (line.isBlank()) {
                elfIndex++;
            } else {
                int calories = Integer.parseInt(line);
                elfCalorieCarriage.merge(elfIndex, calories, Integer::sum);
            }
        }

        int mostCalories = elfCalorieCarriage.values().stream().max(Integer::compare).orElseThrow();

        int highestThreeCalories =
                elfCalorieCarriage.values().stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(3L)
                        .reduce(0, Integer::sum);

        return new PuzzleOutput<>(mostCalories, highestThreeCalories);
    }
}
