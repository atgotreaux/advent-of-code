package com.gotreaux.aoc.puzzles.year2024.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class MullItOverPuzzle extends Puzzle {

    private static final Pattern PATTERN =
            Pattern.compile("(mul)\\((\\d+),(\\d+)\\)|(do|don't)\\(\\)");

    protected MullItOverPuzzle() {
        super(2024, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        String input = inputReader.getInputString();

        boolean enabled = true;
        int sumOfMultiplications = 0, sumOfEnabledMultiplications = 0;

        Matcher matcher = PATTERN.matcher(input);
        while (matcher.find()) {
            if ("mul".equals(matcher.group(1))) {
                int multiplicand = Integer.parseInt(matcher.group(2));
                int multiplier = Integer.parseInt(matcher.group(3));
                sumOfMultiplications += multiplier * multiplicand;
                if (enabled) {
                    sumOfEnabledMultiplications += multiplier * multiplicand;
                }
            } else {
                enabled = "do".equals(matcher.group(4));
            }
        }

        return new PuzzleOutput<>(sumOfMultiplications, sumOfEnabledMultiplications);
    }
}
