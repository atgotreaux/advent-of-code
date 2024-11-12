package com.gotreaux.aoc.puzzles.year2023.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class SeedLocationPuzzle extends Puzzle {

    public SeedLocationPuzzle() {
        super(2023, 5);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader)
            throws IOException, URISyntaxException {
        Collection<Long> seeds = new ArrayList<>();
        Collection<SeedRange> seedRanges = new ArrayList<>();

        Collection<List<AlmanacRange>> maps = new ArrayList<>();
        List<AlmanacRange> map = new ArrayList<>();

        for (String line : inputReader.getInputList()) {
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
