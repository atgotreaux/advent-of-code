package com.gotreaux.aoc.puzzles.year2016.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class TrianglePuzzle extends Puzzle {

    public TrianglePuzzle() {
        super(2016, 3);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) throws Exception {
        Collection<String> input = inputReader.getInputList();
        Collection<Triangle> rowTriangles = new ArrayList<>(input.size());

        List<Integer> colOne = new ArrayList<>(input.size());
        List<Integer> colTwo = new ArrayList<>(input.size());
        List<Integer> colThree = new ArrayList<>(input.size());

        for (String line : input) {
            Scanner scanner = new Scanner(line);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            scanner.close();

            rowTriangles.add(new Triangle(x, y, z));

            colOne.add(x);
            colTwo.add(y);
            colThree.add(z);
        }

        Collection<Triangle> colTriangles = new ArrayList<>(input.size() / 3);
        if (input.size() >= 3) {
            for (int i = 0; i < colOne.size(); i += 3) {
                colTriangles.add(new Triangle(colOne.get(i), colOne.get(i + 1), colOne.get(i + 2)));
                colTriangles.add(new Triangle(colTwo.get(i), colTwo.get(i + 1), colTwo.get(i + 2)));
                colTriangles.add(
                        new Triangle(colThree.get(i), colThree.get(i + 1), colThree.get(i + 2)));
            }
        }

        long validRowTriangles = rowTriangles.stream().filter(Triangle::isValid).count();
        long validColumnTriangles = colTriangles.stream().filter(Triangle::isValid).count();

        return new PuzzleOutput<>(validRowTriangles, validColumnTriangles);
    }
}
