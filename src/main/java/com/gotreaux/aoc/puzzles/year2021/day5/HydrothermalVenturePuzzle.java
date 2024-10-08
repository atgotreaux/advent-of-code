package com.gotreaux.aoc.puzzles.year2021.day5;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

@ShellPuzzle(year = 2021, day = 5, title = "Hydrothermal Venture")
public class HydrothermalVenturePuzzle extends Puzzle {
    public HydrothermalVenturePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws IOException, URISyntaxException {
        Collection<Line> lines =
                getInputProvider()
                        .getInputStream()
                        .map(HydrothermalVenturePuzzle::parseLine)
                        .toList();

        long overlappingOrthogonalPoints =
                lines.stream()
                        .filter(line -> line.isHorizontal() || line.isVertical())
                        .map(Line::getPoints)
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values()
                        .stream()
                        .filter(l -> l >= 2L)
                        .count();

        long allOverlappingPoints =
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

    static Line parseLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",| -> ");

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        scanner.close();

        return new Line(x1, y1, x2, y2);
    }
}
