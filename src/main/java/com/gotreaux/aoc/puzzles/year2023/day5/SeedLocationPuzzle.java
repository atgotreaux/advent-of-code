package com.gotreaux.aoc.puzzles.year2023.day5;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ShellPuzzle(year = 2023, day = 5, title = "If You Give A Seed A Fertilizer")
public class SeedLocationPuzzle extends Puzzle {

    public SeedLocationPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        List<Long> seeds = new ArrayList<>();
        List<SeedRange> seedRanges = new ArrayList<>();

        List<List<AlmanacRange>> maps = new ArrayList<>();
        List<AlmanacRange> map = new ArrayList<>();

        for (String line : getInputProvider().getInputList()) {
            if (line.startsWith("seeds:")) {
                Scanner scanner = new Scanner(line.replace("seeds: ", ""));
                while (scanner.hasNextLong()) {
                    long seedStart = scanner.nextLong();
                    long rangeLength = scanner.nextLong();
                    seeds.add(seedStart);
                    seeds.add(rangeLength);
                    seedRanges.add(new SeedRange(seedStart, rangeLength));
                }
                scanner.close();
            } else if (line.endsWith("map:")) {
                if (!map.isEmpty()) {
                    maps.add(map);
                    map = new ArrayList<>();
                }
            } else if (!line.isEmpty() && Character.isDigit(line.charAt(0))) {
                Scanner scanner = new Scanner(line);
                long destinationRangeStart = scanner.nextLong();
                long sourceRangeStart = scanner.nextLong();
                long rangeLength = scanner.nextLong();
                scanner.close();

                map.add(new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength));
            }
        }
        maps.add(map);

        Almanac almanac = new Almanac(maps);

        long lowestLocationNumber =
                seeds.stream().map(almanac::convert).min(Long::compare).orElseThrow();

        long lowestLocationNumberInRange =
                seedRanges.stream()
                        .flatMapToLong(SeedRange::range)
                        .map(almanac::convert)
                        .min()
                        .orElseThrow();

        return new PuzzleOutput<>(lowestLocationNumber, lowestLocationNumberInRange);
    }
}
