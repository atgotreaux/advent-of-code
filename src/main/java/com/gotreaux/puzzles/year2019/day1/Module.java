package com.gotreaux.puzzles.year2019.day1;

public record Module(long mass) {
    public Module {
        if (mass <= 0) {
            throw new IllegalArgumentException("Module mass must be greater than 0!");
        }
    }

    public long getFuelRequirement() {
        return (mass / 3) - 2;
    }

    public long getAdditionalFuelRequirement() {
        long fuel = getFuelRequirement();
        if (fuel <= 0) {
            return 0;
        }

        Module module = new Module(fuel);
        return fuel + module.getAdditionalFuelRequirement();
    }
}
