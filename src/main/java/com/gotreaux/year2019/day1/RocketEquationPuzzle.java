package com.gotreaux.year2019.day1;

import com.gotreaux.Puzzle;

import java.nio.file.Files;
import java.util.stream.Stream;

public class RocketEquationPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        RocketEquationPuzzle puzzle = new RocketEquationPuzzle();

        puzzle.solve();
    }

    private long sumOfFuelRequirements;
    private long sumOfAdditionalFuelRequirements;

    @Override
    public void prepare() throws Exception {
        try (Stream<String> lines = Files.lines(getInput())) {
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
