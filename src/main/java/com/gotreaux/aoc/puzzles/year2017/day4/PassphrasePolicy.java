package com.gotreaux.aoc.puzzles.year2017.day4;

@FunctionalInterface
interface PassphrasePolicy {
    boolean passes(String[] passphrase);
}
