package com.gotreaux.aoc.puzzles.year2020.day2;

public record OccurrencePasswordPolicy(int min, int max, char target) implements PasswordPolicy {
    public OccurrencePasswordPolicy {
        if (min < 0 || max <= 0) {
            throw new IllegalArgumentException("Password policy should define a positive range!");
        }
    }

    @Override
    public boolean passes(String password) {
        long occurrences =
                password.chars()
                        .mapToObj(c -> Character.toString(c).charAt(0))
                        .filter(character -> character == target)
                        .count();

        return min <= occurrences && occurrences <= max;
    }
}
