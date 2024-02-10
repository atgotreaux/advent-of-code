package com.gotreaux.aoc.puzzles.year2018.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@ShellPuzzle(year = 2018, day = 3, title = "No Matter How You Slice It")
public class SliceItPuzzle extends Puzzle {
    public SliceItPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Integer> solve() throws IOException, URISyntaxException {
        Map<Point, Integer> fabricClaims = new HashMap<>();
        int intactClaim = Integer.MAX_VALUE;

        for (String line : getInputProvider().getInputList()) {
            String[] claim = line.replace(":", "").split(" ");

            int claimID = Integer.parseInt(claim[0].substring(1));
            boolean intact = true;

            Scanner startPointScanner = new Scanner(claim[2]);
            startPointScanner.useDelimiter(",");
            int startX = startPointScanner.nextInt();
            int startY = startPointScanner.nextInt();
            startPointScanner.close();

            Scanner dimensionScanner = new Scanner(claim[3]);
            dimensionScanner.useDelimiter("x");
            int width = dimensionScanner.nextInt();
            int height = dimensionScanner.nextInt();
            dimensionScanner.close();

            Point position = new Point(startX, startY);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    Point point = new Point(position.x + x, position.y + y);
                    if (fabricClaims.containsKey(point)) {
                        intact = false;
                    }
                    fabricClaims.merge(point, 1, Integer::sum);
                }
            }
            if (intact) {
                intactClaim = claimID;
            }
        }

        long overlapArea = fabricClaims.values().stream().filter(i -> i > 1).count();

        return new PuzzleOutput<>(overlapArea, intactClaim);
    }
}
