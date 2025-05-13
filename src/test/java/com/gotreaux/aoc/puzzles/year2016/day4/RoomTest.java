package com.gotreaux.aoc.puzzles.year2016.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RoomTest {
    @ParameterizedTest
    @MethodSource("provideValid")
    void valid(int sectorID, String checksum, String encryptedName, boolean expected) {
        var room = new Room(sectorID, checksum, encryptedName);

        assertEquals(expected, room.isValid());
    }

    @Test
    void decryptName() {
        var room = new Room(343, "", "qzmtzixmtkozyivhz");

        assertEquals("veryencryptedname", room.decryptName());
    }

    private static Stream<Arguments> provideValid() {
        return Stream.of(
                Arguments.of(123, "abxyz", "aaaaabbbzyx", true),
                Arguments.of(987, "abcde", "abcdefgh", true),
                Arguments.of(404, "oarel", "notarealroom", true),
                Arguments.of(200, "decoy", "totallyrealroom", false));
    }
}
