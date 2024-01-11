package com.gotreaux.aoc.puzzles.year2023.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Locale;
import java.util.Scanner;

@ShellPuzzle(year = 2023, day = 2, title = "Cube Conundrum")
public class CubeConundrumPuzzle extends Puzzle {

    public CubeConundrumPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int possibleGames = 0;
        int powerOfFewestCubes = 0;

        for (String line : getInputProvider().getInputList()) {
            int redMax = 0;
            int greenMax = 0;
            int blueMax = 0;
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
                            CubeColor.valueOf(cubeScanner.next().toUpperCase(Locale.getDefault()));
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
        }

        return new PuzzleOutput<>(possibleGames, powerOfFewestCubes);
    }
}
