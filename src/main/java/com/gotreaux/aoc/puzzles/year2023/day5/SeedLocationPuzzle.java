package com.gotreaux.aoc.puzzles.year2023.day5;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

@ShellPuzzle(year = 2023, day = 5, title = "If You Give A Seed A Fertilizer")
public class SeedLocationPuzzle extends Puzzle {

    private final List<Long> seeds = new ArrayList<>();
    private final List<SeedRange> seedRanges = new ArrayList<>();
    private final List<AlmanacRange> seedToSoil = new ArrayList<>();
    private final List<AlmanacRange> soilToFertilizer = new ArrayList<>();
    private final List<AlmanacRange> fertilizerToWater = new ArrayList<>();
    private final List<AlmanacRange> waterToLight = new ArrayList<>();
    private final List<AlmanacRange> lightToTemperature = new ArrayList<>();
    private final List<AlmanacRange> temperatureToHumidity = new ArrayList<>();
    private final List<AlmanacRange> humidityToLocation = new ArrayList<>();
    private AlmanacSection section;

    public SeedLocationPuzzle(InputProvider inputProvider) throws Exception {
        super(inputProvider);

        prepare();
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(
                    line -> {
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
                        } else if (line.startsWith("seed-to-soil map:")) {
                            section = AlmanacSection.SEED_TO_SOIL;
                        } else if (line.startsWith("soil-to-fertilizer map")) {
                            section = AlmanacSection.SOIL_TO_FERTILIZER;
                        } else if (line.startsWith("fertilizer-to-water map")) {
                            section = AlmanacSection.FERTILIZER_TO_WATER;
                        } else if (line.startsWith("water-to-light map:")) {
                            section = AlmanacSection.WATER_TO_LIGHT;
                        } else if (line.startsWith("light-to-temperature map:")) {
                            section = AlmanacSection.LIGHT_TO_TEMPERATURE;
                        } else if (line.startsWith("temperature-to-humidity map:")) {
                            section = AlmanacSection.TEMPERATURE_TO_HUMIDITY;
                        } else if (line.startsWith("humidity-to-location map:")) {
                            section = AlmanacSection.HUMIDITY_TO_LOCATION;
                        } else if (!line.isEmpty() && Character.isDigit(line.charAt(0))) {
                            Scanner scanner = new Scanner(line);
                            long destinationRangeStart = scanner.nextLong();
                            long sourceRangeStart = scanner.nextLong();
                            long rangeLength = scanner.nextLong();
                            scanner.close();

                            AlmanacRange range =
                                    new AlmanacRange(
                                            destinationRangeStart, sourceRangeStart, rangeLength);

                            switch (section) {
                                case SEED_TO_SOIL -> seedToSoil.add(range);
                                case SOIL_TO_FERTILIZER -> soilToFertilizer.add(range);
                                case FERTILIZER_TO_WATER -> fertilizerToWater.add(range);
                                case WATER_TO_LIGHT -> waterToLight.add(range);
                                case LIGHT_TO_TEMPERATURE -> lightToTemperature.add(range);
                                case TEMPERATURE_TO_HUMIDITY -> temperatureToHumidity.add(range);
                                case HUMIDITY_TO_LOCATION -> humidityToLocation.add(range);
                                default -> throw new RuntimeException("Unexpected section!");
                            }
                        }
                    });
        }
    }

    public Long getPartOne() throws NoSuchElementException {
        return seeds.stream().map(this::getLocation).min(Long::compare).orElseThrow();
    }

    public Long getPartTwo() {
        final long[] lowestLocation = {Long.MAX_VALUE};

        for (SeedRange seedRange : seedRanges) {
            seedRange
                    .range()
                    .forEach(
                            seed ->
                                    lowestLocation[0] =
                                            Math.min(lowestLocation[0], getLocation(seed)));
        }

        return lowestLocation[0];
    }

    private long getLocation(long seed) {
        long value = seed;

        for (AlmanacRange range : seedToSoil) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlmanacRange range : soilToFertilizer) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlmanacRange range : fertilizerToWater) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlmanacRange range : waterToLight) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlmanacRange range : lightToTemperature) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlmanacRange range : temperatureToHumidity) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlmanacRange range : humidityToLocation) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }

        return value;
    }
}
