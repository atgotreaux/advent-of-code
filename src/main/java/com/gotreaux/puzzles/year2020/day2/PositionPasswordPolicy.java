package com.gotreaux.puzzles.year2020.day2;

public record PositionPasswordPolicy(Long first, Long second, char target)
        implements PasswordPolicy {
    public PositionPasswordPolicy {
        if (first < 0 || second <= 0) {
            throw new IllegalArgumentException("Password policy should define positive position!");
        }
    }

    @Override
    public boolean passes(String password) {
        return password.charAt(first.intValue() - 1) == target
                ^ password.charAt(second.intValue() - 1) == target;
    }
}
