package com.gotreaux.aoc.puzzles.year2015.day18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.awt.Point;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LightGridMatrixTest {

    @ParameterizedTest
    @MethodSource("provideGetLightCount")
    void getLightCount(int steps, int expected) throws Exception {
        InputReader inputReader = new ResourceInputReader<>(LikeAGifForYourYardPuzzle.class);

        List<String> input = inputReader.getInputList();

        LightGridMatrix matrix = new LightGridMatrix(input);
        for (int step = 0; step < steps; step++) {
            matrix = matrix.animate();
        }

        assertEquals(expected, matrix.getLightCount());
    }

    @ParameterizedTest
    @MethodSource("provideGetStuckLightCount")
    void getStuckLightCount(int steps, int expected) throws Exception {
        InputReader inputReader = new ResourceInputReader<>(LikeAGifForYourYardPuzzle.class);

        List<String> input = inputReader.getInputList();

        List<Point> stuckLights =
                List.of(
                        new Point(0, 0),
                        new Point(0, input.getFirst().length() - 1),
                        new Point(input.size() - 1, 0),
                        new Point(input.size() - 1, input.getFirst().length() - 1));

        LightGridMatrix matrix = new LightGridMatrix(input, stuckLights);
        for (int step = 0; step < steps; step++) {
            matrix = matrix.animate();
        }

        assertEquals(expected, matrix.getLightCount());
    }

    private static Stream<Arguments> provideGetLightCount() {
        return Stream.of(
                Arguments.of(1, 11), Arguments.of(2, 8), Arguments.of(3, 4), Arguments.of(4, 4));
    }

    private static Stream<Arguments> provideGetStuckLightCount() {
        return Stream.of(
                Arguments.of(1, 18),
                Arguments.of(2, 18),
                Arguments.of(3, 18),
                Arguments.of(4, 14),
                Arguments.of(5, 17));
    }
}
