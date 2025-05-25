package com.gotreaux.aoc.puzzles.year2023.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class WaitForItPuzzle extends Puzzle {

    public WaitForItPuzzle() {
        super(2023, 6);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        List<Long> times = new ArrayList<>();
        List<Long> recordDistances = new ArrayList<>();

        for (var line : inputReader.getInputList()) {
            if (line.startsWith("Time:")) {
                var scanner = new Scanner(line.replace("Time:", ""));
                while (scanner.hasNextLong()) {
                    times.add(scanner.nextLong());
                }
                scanner.close();
            } else if (line.startsWith("Distance:")) {
                var scanner = new Scanner(line.replace("Distance:", ""));
                while (scanner.hasNextLong()) {
                    recordDistances.add(scanner.nextLong());
                }
                scanner.close();
            }
        }

        var productOfPossibleWins =
                IntStream.range(0, times.size())
                        .mapToObj(index -> new Race(times.get(index), recordDistances.get(index)))
                        .mapToLong(Race::getWaysToWin)
                        .reduce(1L, Math::multiplyExact);

        var kerningTime = times.stream().map(Object::toString).collect(Collectors.joining());
        var kerningRecordDistance =
                recordDistances.stream().map(Object::toString).collect(Collectors.joining());
        var kerningRace =
                new Race(Long.parseLong(kerningTime), Long.parseLong(kerningRecordDistance));

        return new PuzzleOutput<>(productOfPossibleWins, kerningRace.getWaysToWin());
    }
}
