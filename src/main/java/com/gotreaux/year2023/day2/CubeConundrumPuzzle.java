package com.gotreaux.year2023.day2;

import com.gotreaux.Puzzle;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class CubeConundrumPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle();

        puzzle.solve();
    }

    private long possibleGames;
    private long powerOfFewestCubes;

    public CubeConundrumPuzzle() throws Exception {
        super();

        prepare();
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(
                    line -> {
                        long redMax = 0;
                        long greenMax = 0;
                        long blueMax = 0;
                        boolean possibleGame = true;

                        String[] gameLine = line.split(": ");

                        String gameLabel = gameLine[0];
                        int gameNumber = Integer.parseInt(gameLabel.split(" ")[1]);

                        String gameEvents = gameLine[1];
                        for (String gameEvent : gameEvents.split("; ")) {
                            for (String cube : gameEvent.split(", ")) {
                                Scanner cubeScanner = new Scanner(cube);
                                int cubeCount = cubeScanner.nextInt();
                                CubeColor color =
                                        CubeColor.valueOf(
                                                cubeScanner
                                                        .next()
                                                        .toUpperCase(Locale.getDefault()));
                                cubeScanner.close();
                                switch (color) {
                                    case RED:
                                        possibleGame &= cubeCount <= 12;
                                        redMax = Math.max(redMax, cubeCount);
                                        break;
                                    case GREEN:
                                        possibleGame &= cubeCount <= 13;
                                        greenMax = Math.max(greenMax, cubeCount);
                                        break;
                                    case BLUE:
                                        possibleGame &= cubeCount <= 14;
                                        blueMax = Math.max(blueMax, cubeCount);
                                }
                            }
                        }

                        if (possibleGame) {
                            possibleGames += gameNumber;
                        }
                        powerOfFewestCubes += redMax * greenMax * blueMax;
                    });
        }
    }

    @Override
    public Long getPartOne() {
        return this.possibleGames;
    }

    @Override
    public Long getPartTwo() {
        return this.powerOfFewestCubes;
    }
}
