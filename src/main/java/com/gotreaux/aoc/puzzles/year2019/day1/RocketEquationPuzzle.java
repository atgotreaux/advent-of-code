package com.gotreaux.aoc.puzzles.year2019.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.stream.Stream;

@ShellPuzzle(year = 2019, day = 1, title = "The Tyranny of the Rocket Equation")
public class RocketEquationPuzzle extends Puzzle {

    public RocketEquationPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.map(line -> new Module(Long.parseLong(line)))
                    .mapToLong(Module::getFuelRequirement)
                    .sum();
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.map(line -> new Module(Long.parseLong(line)))
                    .mapToLong(Module::getAdditionalFuelRequirement)
                    .sum();
        }
    }
}
