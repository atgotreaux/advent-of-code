package com.gotreaux.aoc.puzzles.year2017.day4;

import java.util.Arrays;
import java.util.function.Function;

class AnagramWordPassphrasePolicy implements PassphrasePolicy {
    @Override
    public boolean passes(String[] passphrase) {
        Function<String, String> sortChars = new SortCharactersFunction();

        return passphrase.length == Arrays.stream(passphrase).map(sortChars).distinct().count();
    }
}
