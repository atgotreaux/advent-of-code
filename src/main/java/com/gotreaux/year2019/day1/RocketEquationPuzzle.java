package com.gotreaux.year2019.day1;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;
import java.util.stream.Stream;

public class RocketEquationPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        RocketEquationPuzzle puzzle = new RocketEquationPuzzle();

        puzzle.solve();
    }

    public RocketEquationPuzzle() {
        super();
    }

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
