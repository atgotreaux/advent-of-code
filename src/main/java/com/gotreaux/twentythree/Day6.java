package com.gotreaux.twentythree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Day6 {
    private final List<Race> races = new ArrayList<>();
    private final Race kerningRace;
    private record Race(long time, long recordDistance) {}
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = Day6.class.getClassLoader().getResource("com/gotreaux/twentythree/6.txt");
        if (resource == null) {
            System.out.println("Could not find input file");
            return;
        }

        Path path = Path.of(resource.toURI());

        Day6 day6 = new Day6(path);

        System.out.println(day6.getWinningRaces());
        System.out.println(day6.getWinningRacesWithKerning());
    }

    public Day6(Path path) throws IOException {
        List<Long> times = new ArrayList<>();
        List<Long> recordDistances = new ArrayList<>();
        AtomicLong kerningTime = new AtomicLong();
        AtomicLong kerningRecordDistance = new AtomicLong();

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                if (line.startsWith("Time:")) {
                    Scanner scanner = new Scanner(line.replace("Time:", ""));
                    while (scanner.hasNextLong()) {
                        times.add(scanner.nextLong());
                    }
                    scanner.close();
                    kerningTime.set(Long.parseLong(line.replace("Time:", "").replace(" ", "")));
                } else if (line.startsWith("Distance:")) {
                    Scanner scanner = new Scanner(line.replace("Distance:", ""));
                    while (scanner.hasNextLong()) {
                        recordDistances.add(scanner.nextLong());
                    }
                    scanner.close();
                    kerningRecordDistance.set(Long.parseLong(line.replace("Distance:", "").replace(" ", "")));
                }
            });
        }

        for (int i = 0; i < times.size(); i++) {
            races.add(new Race(times.get(i), recordDistances.get(i)));
        }

        kerningRace = new Race(kerningTime.get(), kerningRecordDistance.get());
    }

    public long getWinningRaces() {
        long product = 1;

        for (Race race : races) {
            product *= getWaysToWinRace(race);
        }

        return product;
    }

    public long getWinningRacesWithKerning() {
        return getWaysToWinRace(kerningRace);
    }

    private long getWaysToWinRace(Race race) {
        long waysToWinRace = 0;
        for (long hold = 0; hold <= race.time; hold++) {
            long distance = hold * (race.time - hold);
            if (distance > race.recordDistance) {
                waysToWinRace++;
            }
        }
        return waysToWinRace;
    }
}
