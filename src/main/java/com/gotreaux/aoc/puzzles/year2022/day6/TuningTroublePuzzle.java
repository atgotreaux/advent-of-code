package com.gotreaux.aoc.puzzles.year2022.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class TuningTroublePuzzle extends Puzzle {

    public TuningTroublePuzzle() {
        super(2022, 6);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var input = inputReader.getInputString();

        var startOfPacketMarker =
                IntStream.range(4, input.length())
                        .filter(i -> input.substring(i - 4, i).chars().distinct().count() == 4L)
                        .findFirst()
                        .orElse(Integer.MAX_VALUE);

        var startOfMessageMarket =
                IntStream.range(14, input.length())
                        .filter(i -> input.substring(i - 14, i).chars().distinct().count() == 14L)
                        .findFirst()
                        .orElse(Integer.MAX_VALUE);

        return new PuzzleOutput<>(startOfPacketMarker, startOfMessageMarket);
    }
}
