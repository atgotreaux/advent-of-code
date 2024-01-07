package com.gotreaux.puzzles.year2023.day2;

import com.gotreaux.annotations.ShellPuzzle;
import com.gotreaux.input.InputProvider;
import com.gotreaux.puzzles.Puzzle;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

@ShellPuzzle(year = 2023, day = 2, title = "Cube Conundrum")
public class CubeConundrumPuzzle extends Puzzle {

    private long possibleGames;
    private long powerOfFewestCubes;

    public CubeConundrumPuzzle(InputProvider inputProvider) throws Exception {
        super(inputProvider);

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
