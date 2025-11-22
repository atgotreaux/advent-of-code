package com.gotreaux.aoc.puzzles.year2018.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.Coordinate;
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
    public PuzzleOutput<Long, Integer> solve(InputReader inputReader) {
        Map<Coordinate, Collection<Integer>> fabricClaims = new HashMap<>();
        Collection<Integer> claimIds = new ArrayList<>();

        for (var line : inputReader.getInputList()) {
            var claim = line.replace(":", "").split(" ");

            var claimID = Integer.parseInt(claim[0].substring(1));
            claimIds.add(claimID);

            var startPointScanner = new Scanner(claim[2]);
            startPointScanner.useDelimiter(",");
            var startX = startPointScanner.nextInt();
            var startY = startPointScanner.nextInt();
            startPointScanner.close();

            var dimensionScanner = new Scanner(claim[3]);
            dimensionScanner.useDelimiter("x");
            var width = dimensionScanner.nextInt();
            var height = dimensionScanner.nextInt();
            dimensionScanner.close();

            var position = new Coordinate(startX, startY);
            for (var x = 0; x < width; x++) {
                for (var y = 0; y < height; y++) {
                    var point = new Coordinate(position.x() + x, position.y() + y);
                    fabricClaims.merge(
                            point,
                            List.of(claimID),
                            (w, v) -> Stream.concat(w.stream(), v.stream()).toList());
                }
            }
        }

        var overlapArea = fabricClaims.values().stream().filter(list -> list.size() > 1).count();

        var overlappingClaims =
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
