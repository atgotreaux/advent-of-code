package com.gotreaux.puzzles.year2020.day2;

public record OccurrenceRangePasswordPolicy(Long min, Long max, char target)
        implements PasswordPolicy {
    public OccurrenceRangePasswordPolicy {
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
