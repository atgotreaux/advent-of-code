package com.gotreaux.aoc.puzzles.year2023.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
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
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, IllegalArgumentException {
        int possibleGames = 0;
        int powerOfFewestCubes = 0;

        for (String line : getInputProvider().getInputList()) {
            Map<CubeColor, Integer> cubeMap = new EnumMap<>(CubeColor.class);
            boolean possibleGame = true;

            String[] gameLine = GAME_LINE_DELIM.split(line);

            int gameNumber = Integer.parseInt(gameLine[0].split(" ")[1]);

            for (String gameEvent : GAME_EVENT_DELIM.split(gameLine[1])) {
                for (String cube : CUBE_LIST_DELIM.split(gameEvent)) {
                    Scanner cubeScanner = new Scanner(cube);
                    int cubeCount = cubeScanner.nextInt();
                    CubeColor color =
                            CubeColor.valueOf(cubeScanner.next().toUpperCase(Locale.getDefault()));
                    cubeScanner.close();
                    switch (color) {
                        case RED:
                            possibleGame &= cubeCount <= TOTAL_RED_CUBES;
                            cubeMap.merge(CubeColor.RED, cubeCount, Math::max);
                            break;
                        case GREEN:
                            possibleGame &= cubeCount <= TOTAL_GREEN_CUBES;
                            cubeMap.merge(CubeColor.GREEN, cubeCount, Math::max);
                            break;
                        case BLUE:
                            possibleGame &= cubeCount <= TOTAL_BLUE_CUBES;
                            cubeMap.merge(CubeColor.BLUE, cubeCount, Math::max);
                    }
                }
            }

            if (possibleGame) {
                possibleGames += gameNumber;
            }
            powerOfFewestCubes += cubeMap.values().stream().reduce(1, Math::multiplyExact);
        }

        return new PuzzleOutput<>(possibleGames, powerOfFewestCubes);
    }
}
