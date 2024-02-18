package com.gotreaux.aoc.puzzles.year2015.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

@ShellPuzzle(year = 2015, day = 1, title = "Not Quite Lisp")
public class ApartmentFloorPuzzle extends Puzzle {

    public ApartmentFloorPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, NoSuchElementException {
        int floor = 0;
        int positionBasementReached = Integer.MAX_VALUE;

        String input = getInputProvider().getInputString();
        for (int i = 0; i < input.length(); i++) {
            Instruction instruction = Instruction.fromLabel(input.charAt(i));
            switch (instruction) {
                case UP -> floor++;
                case DOWN -> floor--;
            }
            if (positionBasementReached == Integer.MAX_VALUE && floor < 0) {
                positionBasementReached = i + 1;
            }
        }

        return new PuzzleOutput<>(floor, positionBasementReached);
    }
}
