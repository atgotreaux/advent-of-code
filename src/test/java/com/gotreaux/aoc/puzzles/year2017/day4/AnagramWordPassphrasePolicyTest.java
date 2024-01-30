package com.gotreaux.aoc.puzzles.year2017.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnagramWordPassphrasePolicyTest {
    @ParameterizedTest
    @MethodSource("providePasses")
    void passes(String[] passphrase, boolean expected) {
        PassphrasePolicy anagramWordPolicy = new AnagramWordPassphrasePolicy();

        assertEquals(expected, anagramWordPolicy.passes(passphrase));
    }

    private static Stream<Arguments> providePasses() {
        return Stream.of(
                Arguments.of(new String[] {"abcde", "fghij"}, true),
                Arguments.of(new String[] {"abcde", "xyz", "ecdab"}, false),
                Arguments.of(new String[] {"a", "ab", "abc", "abd", "abf", "abj"}, true),
                Arguments.of(new String[] {"iiii", "oiii", "ooii", "oooi", "oooo"}, true),
                Arguments.of(new String[] {"oiii", "ioii", "iioi", "iiio"}, false));
    }
}
