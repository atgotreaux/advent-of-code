package com.gotreaux.aoc.puzzles.year2020.day2;

record OccurrencePasswordPolicy(int min, int max, char target) implements PasswordPolicy {
    OccurrencePasswordPolicy {
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

        return min <= Math.toIntExact(occurrences) && Math.toIntExact(occurrences) <= max;
    }
}
