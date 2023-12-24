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
            return lines.mapToLong(line -> getFuelRequirement(Long.parseLong(line))).sum();
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(line -> getAdditionalFuelRequirement(Long.parseLong(line))).sum();
        }
    }

    private long getFuelRequirement(long mass) {
        return (mass / 3) - 2;
    }

    private long getAdditionalFuelRequirement(long massOrFuel) {
        long fuel = getFuelRequirement(massOrFuel);
        if (fuel <= 0) {
            return 0;
        }
        return fuel + getAdditionalFuelRequirement(fuel);
    }
}
