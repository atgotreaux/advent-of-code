package com.gotreaux.aoc.puzzles.year2017.day4;

import java.util.Arrays;

class AnagramWordPassphrasePolicy implements PassphrasePolicy {
    @Override
    public boolean passes(String[] passphrase) {
        return passphrase.length
                == Arrays.stream(passphrase)
                        .map(
                                s ->
                                        s.chars()
                                                .sorted()
                                                .collect(
                                                        StringBuilder::new,
                                                        StringBuilder::appendCodePoint,
                                                        StringBuilder::append)
                                                .toString())
                        .distinct()
                        .count();
    }
}
