package com.gotreaux.aoc.puzzles.year2017.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DuplicateWordPassphrasePolicyTest {
    @ParameterizedTest
    @MethodSource("providePasses")
    void passes(String[] passphrase, boolean expected) {
        PassphrasePolicy duplicateWordPolicy = new DuplicateWordPassphrasePolicy();

        assertEquals(expected, duplicateWordPolicy.passes(passphrase));
    }

    private static Stream<Arguments> providePasses() {
        return Stream.of(
                Arguments.of(new String[] {"aa", "bb", "cc", "dd", "ee"}, true),
                Arguments.of(new String[] {"aa", "bb", "cc", "dd", "aa"}, false),
                Arguments.of(new String[] {"aa", "bb", "cc", "dd", "aaa"}, true));
    }
}
