package com.gotreaux.twentythree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Day2 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = Day1.class.getClassLoader().getResource("com/gotreaux/twentythree/2.txt");
        if (resource == null) {
            System.out.println("Could not find input file");
            return;
        }

        Path path = Path.of(resource.toURI());

        Day2 day2 = new Day2();

        System.out.println("Part 1: " + day2.possibleGames(path));
        System.out.println("Part 2: " + day2.powerOfFewestCubes(path));
    }

    public int possibleGames(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.mapToInt(line -> {
                String[] gameLine = line.split(": ");
                String gameEvents = gameLine[1];

                for (String gameEvent : gameEvents.split("; ")) {
                    for (String cube : gameEvent.split(", ")) {
                        String[] cubesAndColor = cube.split(" ");
                        int cubeCount = Integer.parseInt(cubesAndColor[0]);
                        String color = cubesAndColor[1];
                        if ((color.equals("red") && cubeCount > 12)
                                || (color.equals("green") && cubeCount > 13)
                                || (color.equals("blue") && cubeCount > 14)
                        ) {
                            return 0;
                        }
                    }
                }

                String gameLabel = gameLine[0];
                String[] gameLabelAndNumber = gameLabel.split(" ");
                return Integer.parseInt(gameLabelAndNumber[1]);
            }).sum();
        }
    }

    public int powerOfFewestCubes(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.mapToInt(line -> {
                int redMax = 0;
                int greenMax = 0;
                int blueMax = 0;
                String[] gameLine = line.split(": ");
                String gameEvents = gameLine[1];

                for (String gameEvent : gameEvents.split("; ")) {
                    for (String cube : gameEvent.split(", ")) {
                        String[] cubesAndColor = cube.split(" ");
                        int cubeCount = Integer.parseInt(cubesAndColor[0]);
                        String color = cubesAndColor[1];
                        switch (color) {
                            case "red" -> redMax = Math.max(redMax, cubeCount);
                            case "green" -> greenMax = Math.max(greenMax, cubeCount);
                            case "blue" -> blueMax = Math.max(blueMax, cubeCount);
                        }
                    }
                }

                return redMax * greenMax * blueMax;
            }).sum();
        }
    }
}
