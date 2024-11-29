package com.gotreaux.aoc.puzzles.year2019.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class RocketEquationPuzzle extends Puzzle {

    public RocketEquationPuzzle() {
        super(2019, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        int sumOfFuelRequirements = 0;
        int sumOfAdditionalFuelRequirements = 0;

        for (String line : inputReader.getInputList()) {
            Module module = new Module(Integer.parseInt(line));

            sumOfFuelRequirements += module.getFuelRequirement();
            sumOfAdditionalFuelRequirements += module.getAdditionalFuelRequirement();
        }

        return new PuzzleOutput<>(sumOfFuelRequirements, sumOfAdditionalFuelRequirements);
    }
}
