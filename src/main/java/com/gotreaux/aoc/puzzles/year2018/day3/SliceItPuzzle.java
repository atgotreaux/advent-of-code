package com.gotreaux.aoc.puzzles.year2018.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class SliceItPuzzle extends Puzzle {

    public SliceItPuzzle() {
        super(2018, 3);
    }

    @Override
    public PuzzleOutput<Long, Integer> solve(InputReader inputReader) throws Exception {
        Map<Point, Collection<Integer>> fabricClaims = new HashMap<>();
        Collection<Integer> claimIds = new ArrayList<>();

        for (String line : inputReader.getInputList()) {
            String[] claim = line.replace(":", "").split(" ");

            int claimID = Integer.parseInt(claim[0].substring(1));
            claimIds.add(claimID);

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
                    fabricClaims.merge(
                            point,
                            List.of(claimID),
                            (w, v) -> Stream.concat(w.stream(), v.stream()).toList());
                }
            }
        }

        long overlapArea = fabricClaims.values().stream().filter(list -> list.size() > 1).count();

        List<Integer> overlappingClaims =
                fabricClaims.values().stream()
                        .filter(list -> list.size() > 1)
                        .flatMap(Collection::stream)
                        .toList();

        int intactClaim =
                claimIds.stream()
                        .filter(id -> !overlappingClaims.contains(id))
                        .findFirst()
                        .orElseThrow();

        return new PuzzleOutput<>(overlapArea, intactClaim);
    }
}
