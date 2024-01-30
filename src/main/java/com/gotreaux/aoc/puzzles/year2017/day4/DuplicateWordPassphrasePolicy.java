package com.gotreaux.aoc.puzzles.year2017.day4;

import java.util.Arrays;

class DuplicateWordPassphrasePolicy implements PassphrasePolicy {
    @Override
    public boolean passes(String[] passphrase) {
        return passphrase.length == Arrays.stream(passphrase).distinct().count();
    }
}
