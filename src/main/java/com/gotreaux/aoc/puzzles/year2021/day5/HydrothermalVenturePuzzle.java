package com.gotreaux.aoc.puzzles.year2021.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class HydrothermalVenturePuzzle extends Puzzle {

    public HydrothermalVenturePuzzle() {
        super(2021, 5);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) throws Exception {
        Collection<Line> lines = inputReader.getInputStream().map(Line::of).toList();

        var overlappingOrthogonalPoints =
                lines.stream()
                        .filter(line -> line.isHorizontal() || line.isVertical())
                        .map(Line::getPoints)
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values()
                        .stream()
                        .filter(l -> l >= 2L)
                        .count();

        var allOverlappingPoints =
                lines.stream()
                        .map(Line::getPoints)
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values()
                        .stream()
                        .filter(l -> l >= 2L)
                        .count();

        return new PuzzleOutput<>(overlappingOrthogonalPoints, allOverlappingPoints);
    }
}
