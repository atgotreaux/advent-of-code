package com.gotreaux.aoc.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AlmanacTest {
    @ParameterizedTest
    @MethodSource("provideConvert")
    void convert(long seed, long expectedLocation) {
        Collection<List<AlmanacRange>> maps = new ArrayList<>(7);

        maps.add(List.of(new AlmanacRange(50L, 98L, 2L), new AlmanacRange(52L, 50L, 48L)));
        maps.add(
                List.of(
                        new AlmanacRange(0L, 15L, 37L),
                        new AlmanacRange(37L, 52L, 2L),
                        new AlmanacRange(39L, 0L, 15L)));
        maps.add(
                List.of(
                        new AlmanacRange(49L, 53L, 8L),
                        new AlmanacRange(0L, 11L, 42L),
                        new AlmanacRange(42L, 0L, 7L),
                        new AlmanacRange(57L, 7L, 4L)));
        maps.add(List.of(new AlmanacRange(88L, 18L, 7L), new AlmanacRange(18L, 25L, 70L)));
        maps.add(
                List.of(
                        new AlmanacRange(45L, 77L, 23L),
                        new AlmanacRange(81L, 45L, 19L),
                        new AlmanacRange(68L, 64L, 13L)));
        maps.add(List.of(new AlmanacRange(0L, 69L, 1L), new AlmanacRange(1L, 0L, 69L)));
        maps.add(List.of(new AlmanacRange(60L, 56L, 37L), new AlmanacRange(56L, 93L, 4L)));

        Almanac almanac = new Almanac(maps);

        assertEquals(expectedLocation, almanac.convert(seed));
    }

    private static Stream<Arguments> provideConvert() {
        return Stream.of(
                Arguments.of(79L, 82L),
                Arguments.of(14L, 43L),
                Arguments.of(55L, 86L),
                Arguments.of(13L, 35L));
    }
}
