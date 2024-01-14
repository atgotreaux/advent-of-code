package com.gotreaux.aoc.puzzles.year2019.day1;

record Module(int mass) {

    Module {
        if (mass <= 0) {
            throw new IllegalArgumentException("Module mass must be greater than 0!");
        }
    }

    int getFuelRequirement() {
        return (mass / 3) - 2;
    }

    int getAdditionalFuelRequirement() {
        int fuel = getFuelRequirement();
        if (fuel <= 0) {
            return 0;
        }

        Module module = new Module(fuel);
        return fuel + module.getAdditionalFuelRequirement();
    }
}
