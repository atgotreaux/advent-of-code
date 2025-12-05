package com.gotreaux.aoc.puzzles.year2025.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class CafeteriaPuzzle extends Puzzle {

    private static final Pattern RANGE_PATTERN = Pattern.compile("^\\d+-\\d+$");
    private static final Pattern INGREDIENT_PATTERN = Pattern.compile("^\\d+$");

    public CafeteriaPuzzle() {
        super(2025, 5);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) {
        var rangeManager = new RangeManager();
        Collection<Long> ingredients = new ArrayList<>();

        for (var line : inputReader.getInputList()) {
            if (RANGE_PATTERN.matcher(line).matches()) {
                rangeManager.addRange(Range.of(line));
            } else if (INGREDIENT_PATTERN.matcher(line).matches()) {
                ingredients.add(Long.parseLong(line));
            }
        }

        var ranges = rangeManager.getRanges();

        var numberOfFreshIngredients = 0;
        for (var ingredient : ingredients) {
            if (ranges.stream().anyMatch(range -> range.contains(ingredient))) {
                numberOfFreshIngredients++;
            }
        }

        var totalFreshIngredientSize = ranges.stream().mapToLong(Range::size).sum();

        return new PuzzleOutput<>(numberOfFreshIngredients, totalFreshIngredientSize);
    }
}
