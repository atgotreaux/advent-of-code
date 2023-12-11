package com.gotreaux.twentythree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Day5 {
    private final List<Long> seeds = new ArrayList<>();
    private final List<SeedRange> seedRanges = new ArrayList<>();
    private final List<AlamanacRange> seedToSoil = new ArrayList<>();
    private final List<AlamanacRange> soilToFertilizer = new ArrayList<>();
    private final List<AlamanacRange> fertilizerToWater = new ArrayList<>();
    private final List<AlamanacRange> waterToLight = new ArrayList<>();
    private final List<AlamanacRange> lightToTemperature = new ArrayList<>();
    private final List<AlamanacRange> temperatureToHumidity = new ArrayList<>();
    private final List<AlamanacRange> humidityToLocation = new ArrayList<>();

    private enum AlmanacSection {
        SEED_TO_SOIL,
        SOIL_TO_FERTILIZER,
        FERTILIZER_TO_WATER,
        WATER_TO_LIGHT,
        LIGHT_TO_TEMPERATURE,
        TEMPERATURE_TO_HUMIDITY,
        HUMIDITY_TO_LOCATION,
    }

    private record SeedRange(long seedStart, long rangeLength) {
        public LongStream range() {
            return LongStream.range(seedStart, seedStart + rangeLength);
        }
    }

    private record AlamanacRange(long destinationRangeStart, long sourceRangeStart, long rangeLength) {
        public boolean isWithinRange(long sourceValue) {
            return sourceValue >= sourceRangeStart && sourceValue < (sourceRangeStart + rangeLength);
        }
        public long getDestinationValue(long sourceValue) {
            long offset = sourceValue - sourceRangeStart;
            if (offset >= 0 && offset < rangeLength) {
                return destinationRangeStart + offset;
            }
            return sourceValue;
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = Day5.class.getClassLoader().getResource("com/gotreaux/twentythree/5.txt");
        if (resource == null) {
            System.out.println("Could not find input file");
            return;
        }

        Path path = Path.of(resource.toURI());

        Day5 day5 = new Day5(path);
        System.out.println(day5.lowestLocationNumber());
        System.out.println(day5.lowestLocationNumberInRange());
    }

    public Day5(Path path) throws IOException {
        AtomicReference<AlmanacSection> section = new AtomicReference<>();

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                if (line.startsWith("seeds")) {
                    String[] lineSeeds = line.split(": ")[1].split(" ");
                    for (int i = 0; i < lineSeeds.length; i+= 2) {
                        long seedStart = Long.parseLong(lineSeeds[i]);
                        long rangeLength = Long.parseLong(lineSeeds[i + 1]);
                        seeds.add(seedStart);
                        seeds.add(rangeLength);
                        seedRanges.add(new SeedRange(seedStart, rangeLength));
                    }
                } else if (line.startsWith("seed-to-soil map:")) {
                    section.set(AlmanacSection.SEED_TO_SOIL);
                } else if (line.startsWith("soil-to-fertilizer map")) {
                    section.set(AlmanacSection.SOIL_TO_FERTILIZER);
                } else if (line.startsWith("fertilizer-to-water map")) {
                    section.set(AlmanacSection.FERTILIZER_TO_WATER);
                } else if (line.startsWith("water-to-light map:")) {
                    section.set(AlmanacSection.WATER_TO_LIGHT);
                } else if (line.startsWith("light-to-temperature map:")) {
                    section.set(AlmanacSection.LIGHT_TO_TEMPERATURE);
                } else if (line.startsWith("temperature-to-humidity map:")) {
                    section.set(AlmanacSection.TEMPERATURE_TO_HUMIDITY);
                } else if (line.startsWith("humidity-to-location map:")) {
                    section.set(AlmanacSection.HUMIDITY_TO_LOCATION);
                } else if (!line.isEmpty() && Character.isDigit(line.charAt(0))) {
                    String[] lineRange = line.split(" ");
                    long destinationRangeStart = Long.parseLong(lineRange[0]);
                    long sourceRangeStart = Long.parseLong(lineRange[1]);
                    long rangeLength = Long.parseLong(lineRange[2]);
                    AlamanacRange range = new AlamanacRange(destinationRangeStart, sourceRangeStart, rangeLength);

                    switch (section.get()) {
                        case AlmanacSection.SEED_TO_SOIL: seedToSoil.add(range); break;
                        case AlmanacSection.SOIL_TO_FERTILIZER: soilToFertilizer.add(range); break;
                        case AlmanacSection.FERTILIZER_TO_WATER: fertilizerToWater.add(range); break;
                        case AlmanacSection.WATER_TO_LIGHT: waterToLight.add(range); break;
                        case AlmanacSection.LIGHT_TO_TEMPERATURE: lightToTemperature.add(range); break;
                        case AlmanacSection.TEMPERATURE_TO_HUMIDITY: temperatureToHumidity.add(range); break;
                        case AlmanacSection.HUMIDITY_TO_LOCATION: humidityToLocation.add(range); break;
                    }
                }
            });
        }
    }

    public long lowestLocationNumber() {
        long lowestLocation = Long.MAX_VALUE;

        for (long seed : seeds) {
            lowestLocation = Math.min(lowestLocation, getLocation(seed));
        }

        return lowestLocation;
    }

    public long lowestLocationNumberInRange() {
        final long[] lowestLocation = {Long.MAX_VALUE};

        for (SeedRange seedRange : seedRanges) {
            seedRange.range().forEach(seed -> lowestLocation[0] = Math.min(lowestLocation[0], getLocation(seed)));
        }

        return lowestLocation[0];
    }

    private long getLocation(long seed) {
        long value = seed;

        for (AlamanacRange range : seedToSoil) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlamanacRange range : soilToFertilizer) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlamanacRange range : fertilizerToWater) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlamanacRange range : waterToLight) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlamanacRange range : lightToTemperature) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlamanacRange range : temperatureToHumidity) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }
        for (AlamanacRange range : humidityToLocation) {
            if (range.isWithinRange(value)) {
                value = range.getDestinationValue(value);
                break;
            }
        }

        return value;
    }
}
