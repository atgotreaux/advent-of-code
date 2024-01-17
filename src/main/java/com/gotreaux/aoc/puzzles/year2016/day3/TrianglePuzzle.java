package com.gotreaux.aoc.puzzles.year2016.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@ShellPuzzle(year = 2016, day = 3, title = "Squares With Three Sides")
public class TrianglePuzzle extends Puzzle {

    public TrianglePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        Collection<String> input = getInputProvider().getInputList();
        Collection<Triangle> rowTriangles = new ArrayList<>(input.size());

        List<Integer> colOne = new ArrayList<>(input.size());
        List<Integer> colTwo = new ArrayList<>(input.size());
        List<Integer> colThree = new ArrayList<>(input.size());

        for (String line : input) {
            Scanner scanner = new Scanner(line);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            scanner.close();

            rowTriangles.add(new Triangle(a, b, c));

            colOne.add(a);
            colTwo.add(b);
            colThree.add(c);
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
