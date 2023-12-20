package com.gotreaux.year2019.day1;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;

import java.util.stream.Stream;

public class RocketEquationPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        RocketEquationPuzzle puzzle = new RocketEquationPuzzle();

        puzzle.solve();
    }

    private long sumOfFuelRequirements;
    private long sumOfAdditionalFuelRequirements;

    public RocketEquationPuzzle() {
        super();
    }

    public RocketEquationPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                long mass = Long.parseLong(line);

                sumOfFuelRequirements += getFuelRequirement(mass);
                sumOfAdditionalFuelRequirements += getAdditionalFuelRequirement(mass);
            });
        }
    }

    @Override
    public Long getPartOne() {
        return sumOfFuelRequirements;
    }

    @Override
    public Long getPartTwo() {
        return sumOfAdditionalFuelRequirements;
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
