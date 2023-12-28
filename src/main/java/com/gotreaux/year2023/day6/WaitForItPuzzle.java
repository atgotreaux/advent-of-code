package com.gotreaux.year2023.day6;

import com.gotreaux.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WaitForItPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        puzzle.solve();
    }

    private final List<Race> races = new ArrayList<>();
    private Race kerningRace;

    public WaitForItPuzzle() throws Exception {
        super();

        prepare();
    }

    private void prepare() throws Exception {
        List<Long> times = new ArrayList<>();
        List<Long> recordDistances = new ArrayList<>();

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                if (line.startsWith("Time:")) {
                    Scanner scanner = new Scanner(line.replace("Time:", ""));
                    while (scanner.hasNextLong()) {
                        times.add(scanner.nextLong());
                    }
                    scanner.close();
                } else if (line.startsWith("Distance:")) {
                    Scanner scanner = new Scanner(line.replace("Distance:", ""));
                    while (scanner.hasNextLong()) {
                        recordDistances.add(scanner.nextLong());
                    }
                    scanner.close();
                }
            });
        }

        for (int i = 0; i < times.size(); i++) {
            races.add(new Race(times.get(i), recordDistances.get(i)));
        }

        String kerningTime = times.stream()
                .map(Object::toString)
                .collect(Collectors.joining());

        String kerningRecordDistance = recordDistances.stream()
                .map(Object::toString)
                .collect(Collectors.joining());

        kerningRace = new Race(Long.parseLong(kerningTime), Long.parseLong(kerningRecordDistance));
    }

    @Override
    public Long getPartOne() {
        return races.stream()
                .mapToLong(Race::getWaysToWin)
                .reduce(1, Math::multiplyExact);
    }

    @Override
    public Long getPartTwo() {
        return kerningRace.getWaysToWin();
    }
}
