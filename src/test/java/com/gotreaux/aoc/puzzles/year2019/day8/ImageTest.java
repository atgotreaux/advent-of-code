package com.gotreaux.aoc.puzzles.year2019.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ImageTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String input, int width, int height, int expectedLayers) {
        var image = Image.of(input, width, height);

        assertEquals(expectedLayers, image.layers().size());
    }

    @Test
    void throwsIfWidthIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> Image.of("123456789012", -1, 2));
    }

    @Test
    void throwsIfHeightIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> Image.of("123456789012", 3, -2));
    }

    @Test
    void throwsIfLengthIsLessThanDimensions() {
        assertThrows(IllegalArgumentException.class, () -> Image.of("1234", 3, 2));
    }

    @Test
    void render() {
        var image = Image.of("0222112222120000", 2, 2);

        var expectedOutput =
                """
                01
                10
                """;

        assertEquals(expectedOutput, image.render());
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("123456789012", 3, 2, 2), Arguments.of("0222112222120000", 2, 2, 4));
    }
}
