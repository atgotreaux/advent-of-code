package com.gotreaux.aoc.puzzles.year2023.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.number.NumberUtils;
import com.gotreaux.aoc.utils.regex.PatternUtils;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class WaitForItPuzzle extends Puzzle {

    private static final String TIME_PREFIX = "Time:";
    private static final String DISTANCE_PREFIX = "Distance:";

    public WaitForItPuzzle() {
        super(2023, 6);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var times =
                input.stream()
                        .filter(line -> line.startsWith(TIME_PREFIX))
                        .findFirst()
                        .map(line -> line.replace(TIME_PREFIX, "").trim())
                        .map(line -> NumberUtils.collect(line, PatternUtils.ANY_WHITESPACE))
                        .orElseThrow();

        var recordDistances =
                input.stream()
                        .filter(line -> line.startsWith(DISTANCE_PREFIX))
                        .findFirst()
                        .map(line -> line.replace(DISTANCE_PREFIX, "").trim())
                        .map(line -> NumberUtils.collect(line, PatternUtils.ANY_WHITESPACE))
                        .orElseThrow();

        if (times.size() != recordDistances.size()) {
            throw new IllegalArgumentException(
                    "The number of times and record distances must be equal");
        }

        var productOfPossibleWins =
                IntStream.range(0, times.size())
                        .mapToObj(index -> new Race(times.get(index), recordDistances.get(index)))
                        .mapToLong(Race::getWaysToWin)
                        .reduce(1L, Math::multiplyExact);

        var kerningRace =
                new Race(NumberUtils.concatenate(times), NumberUtils.concatenate(recordDistances));

        return new PuzzleOutput<>(productOfPossibleWins, kerningRace.getWaysToWin());
    }
}
