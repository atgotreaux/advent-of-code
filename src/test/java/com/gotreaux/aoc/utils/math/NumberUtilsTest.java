package com.gotreaux.aoc.utils.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.utils.regex.PatternUtils;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberUtilsTest {

    @ParameterizedTest
    @MethodSource("provideConcatenate")
    void concatenate(Collection<Long> numbers, long expected) {
        assertEquals(expected, NumberUtils.concatenate(numbers));
    }

    @ParameterizedTest
    @MethodSource("provideCollect")
    void collect(CharSequence line, Pattern pattern, List<Long> expected) {
        assertEquals(expected, NumberUtils.collect(line, pattern));
    }

    private static Stream<Arguments> provideConcatenate() {
        return Stream.of(
                Arguments.of(List.of(7L, 15L, 30L), 71530L),
                Arguments.of(List.of(9L, 40L, 200L), 940200L));
    }

    private static Stream<Arguments> provideCollect() {
        return Stream.of(
                Arguments.of("7  15   30", PatternUtils.ANY_WHITESPACE, List.of(7L, 15L, 30L)),
                Arguments.of("9  40  200", PatternUtils.ANY_WHITESPACE, List.of(9L, 40L, 200L)));
    }
}
