package com.gotreaux.aoc.puzzles.year2015.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class FireHazardPuzzle extends Puzzle<Long, Integer> {

    private static final int GRID_DIMENSION = 1000;

    public FireHazardPuzzle() {
        super(2015, 6);
    }

    @Override
    public Long solvePartOne(InputReader inputReader) {
        var lightGrid = new boolean[GRID_DIMENSION][GRID_DIMENSION];

        inputReader
                .getInputStream()
                .map(Instruction::of)
                .forEach(instruction -> instruction.apply(lightGrid));

        return Arrays.stream(lightGrid)
                .flatMap(row -> IntStream.range(0, GRID_DIMENSION).mapToObj(i -> row[i]))
                .filter(Boolean::booleanValue)
                .count();
    }

    @Override
    public Integer solvePartTwo(InputReader inputReader) {
        var brightnessGrid = new int[GRID_DIMENSION][GRID_DIMENSION];

        inputReader
                .getInputStream()
                .map(Instruction::of)
                .forEach(instruction -> instruction.apply(brightnessGrid));

        return Arrays.stream(brightnessGrid).flatMapToInt(Arrays::stream).sum();
    }
}
