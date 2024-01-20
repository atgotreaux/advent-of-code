package com.gotreaux.aoc.puzzles.year2019.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;

@ShellPuzzle(year = 2019, day = 1, title = "The Tyranny of the Rocket Equation")
public class RocketEquationPuzzle extends Puzzle {

    public RocketEquationPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, NumberFormatException {
        int sumOfFuelRequirements = 0;
        int sumOfAdditionalFuelRequirements = 0;

        for (String line : getInputProvider().getInputList()) {
            Module module = new Module(Integer.parseInt(line));

            sumOfFuelRequirements += module.getFuelRequirement();
            sumOfAdditionalFuelRequirements += module.getAdditionalFuelRequirement();
        }

        return new PuzzleOutput<>(sumOfFuelRequirements, sumOfAdditionalFuelRequirements);
    }
}
