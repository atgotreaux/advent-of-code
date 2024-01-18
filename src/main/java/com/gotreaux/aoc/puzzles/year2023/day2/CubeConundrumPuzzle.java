package com.gotreaux.aoc.puzzles.year2023.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

@ShellPuzzle(year = 2023, day = 2, title = "Cube Conundrum")
public class CubeConundrumPuzzle extends Puzzle {

    private static final Pattern GAME_LINE_DELIM = Pattern.compile(": ");
    private static final Pattern GAME_EVENT_DELIM = Pattern.compile("; ");
    private static final Pattern CUBE_LIST_DELIM = Pattern.compile(", ");
    private static final int TOTAL_RED_CUBES = 12;
    private static final int TOTAL_GREEN_CUBES = 13;
    private static final int TOTAL_BLUE_CUBES = 14;

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

            String[] gameLine = GAME_LINE_DELIM.split(line);

            String gameLabel = gameLine[0];
            int gameNumber = Integer.parseInt(gameLabel.split(" ")[1]);

            String gameEvents = gameLine[1];
            for (String gameEvent : GAME_EVENT_DELIM.split(gameEvents)) {
                for (String cube : CUBE_LIST_DELIM.split(gameEvent)) {
                    Scanner cubeScanner = new Scanner(cube);
                    int cubeCount = cubeScanner.nextInt();
                    CubeColor color =
                            CubeColor.valueOf(cubeScanner.next().toUpperCase(Locale.getDefault()));
                    cubeScanner.close();
                    switch (color) {
                        case RED:
                            possibleGame &= cubeCount <= TOTAL_RED_CUBES;
                            redMax = Math.max(redMax, cubeCount);
                            break;
                        case GREEN:
                            possibleGame &= cubeCount <= TOTAL_GREEN_CUBES;
                            greenMax = Math.max(greenMax, cubeCount);
                            break;
                        case BLUE:
                            possibleGame &= cubeCount <= TOTAL_BLUE_CUBES;
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
