package com.gotreaux.aoc.puzzles.year2023.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class CubeConundrumPuzzle extends Puzzle {

    private static final Pattern GAME_LINE_DELIM = Pattern.compile(": ");
    private static final Pattern GAME_EVENT_DELIM = Pattern.compile("; ");
    private static final Pattern CUBE_LIST_DELIM = Pattern.compile(", ");
    private static final int TOTAL_RED_CUBES = 12;
    private static final int TOTAL_GREEN_CUBES = 13;
    private static final int TOTAL_BLUE_CUBES = 14;

    public CubeConundrumPuzzle() {
        super(2023, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var possibleGames = 0;
        var powerOfFewestCubes = 0;

        for (var line : inputReader.getInputList()) {
            Map<CubeColor, Integer> cubeMap = new EnumMap<>(CubeColor.class);
            var possibleGame = true;

            var gameLine = GAME_LINE_DELIM.split(line);

            var gameNumber = Integer.parseInt(gameLine[0].split(" ")[1]);

            for (var gameEvent : GAME_EVENT_DELIM.split(gameLine[1])) {
                for (var cube : CUBE_LIST_DELIM.split(gameEvent)) {
                    var cubeScanner = new Scanner(cube);
                    var cubeCount = cubeScanner.nextInt();
                    var color =
                            CubeColor.valueOf(cubeScanner.next().toUpperCase(Locale.getDefault()));
                    cubeScanner.close();
                    switch (color) {
                        case RED -> {
                            possibleGame &= cubeCount <= TOTAL_RED_CUBES;
                            cubeMap.merge(CubeColor.RED, cubeCount, Math::max);
                        }
                        case GREEN -> {
                            possibleGame &= cubeCount <= TOTAL_GREEN_CUBES;
                            cubeMap.merge(CubeColor.GREEN, cubeCount, Math::max);
                        }
                        case BLUE -> {
                            possibleGame &= cubeCount <= TOTAL_BLUE_CUBES;
                            cubeMap.merge(CubeColor.BLUE, cubeCount, Math::max);
                        }
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
