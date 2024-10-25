package com.gotreaux.aoc.puzzles.year2019.day1;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.stereotype.Component;

@Component
public class RocketEquationPuzzle extends Puzzle {

    public RocketEquationPuzzle() {
        super(2019, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException, NumberFormatException {
        int sumOfFuelRequirements = 0;
        int sumOfAdditionalFuelRequirements = 0;

        for (String line : inputProvider.getInputList()) {
            Module module = new Module(Integer.parseInt(line));

            sumOfFuelRequirements += module.getFuelRequirement();
            sumOfAdditionalFuelRequirements += module.getAdditionalFuelRequirement();
        }

        return new PuzzleOutput<>(sumOfFuelRequirements, sumOfAdditionalFuelRequirements);
    }
}
