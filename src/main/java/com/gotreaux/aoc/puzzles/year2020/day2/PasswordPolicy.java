package com.gotreaux.aoc.puzzles.year2020.day2;

@FunctionalInterface
interface PasswordPolicy {

    boolean passes(String password);
}
