package com.gotreaux.aoc.puzzles.year2025.day3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

record BatteryBank(List<Integer> joltages) {

    static BatteryBank of(CharSequence line) {
        if (!line.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Battery bank must contain only digits");
        }

        var joltages = line.chars().mapToObj(Character::getNumericValue).toList();

        return new BatteryBank(joltages);
    }

    BatteryBank {
        if (joltages.size() < 2) {
            throw new IllegalArgumentException("Battery bank must have at least two batteries");
        }
    }

    long getMaximumOutputJoltage(int batteryCount) {
        Collection<Integer> digits = new ArrayList<>(batteryCount);

        var cursor = 0;
        while (digits.size() < batteryCount) {
            var remainingDigits = batteryCount - digits.size();
            var searchBoundary = joltages.size() - remainingDigits + 1;

            var nextDigit =
                    IntStream.range(cursor, searchBoundary).map(joltages::get).max().orElseThrow();

            digits.add(nextDigit);

            cursor =
                    IntStream.range(cursor, searchBoundary)
                                    .filter(i -> joltages.get(i) == nextDigit)
                                    .findFirst()
                                    .orElseThrow()
                            + 1;
        }

        return Long.parseLong(digits.stream().map(Object::toString).collect(Collectors.joining()));
    }
}
