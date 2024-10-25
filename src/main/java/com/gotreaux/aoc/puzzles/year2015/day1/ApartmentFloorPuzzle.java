package com.gotreaux.aoc.puzzles.year2015.day1;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
public class ApartmentFloorPuzzle extends Puzzle {

    public ApartmentFloorPuzzle() {
        super(2015, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException, NoSuchElementException {
        int floor = 0;
        int positionBasementReached = Integer.MAX_VALUE;

        String input = inputProvider.getInputString();
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
