package com.gotreaux.aoc.puzzles.year2015.day18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.utils.Coordinate;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LightGridTest {

    @ParameterizedTest
    @MethodSource("provideGetLightCount")
    void getLightCount(int steps, int expected) {
        InputReader inputReader = new ResourceInputReader<>(LikeAGifForYourYardPuzzle.class);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofChars(input);

        var lightGrid = new LightGrid(matrix);

        for (var step = 0; step < steps; step++) {
            lightGrid = lightGrid.animate();
        }

        assertEquals(expected, lightGrid.getLightCount());
    }

    @ParameterizedTest
    @MethodSource("provideGetStuckLightCount")
    void getStuckLightCount(int steps, int expected) {
        InputReader inputReader = new ResourceInputReader<>(LikeAGifForYourYardPuzzle.class);

        var input = inputReader.getInputList();

        var stuckLights =
                List.of(
                        new Coordinate(0, 0),
                        new Coordinate(0, input.getFirst().length() - 1),
                        new Coordinate(input.size() - 1, 0),
                        new Coordinate(input.size() - 1, input.getFirst().length() - 1));

        var matrix = MatrixFactory.ofChars(input);

        var lightGrid = new LightGrid(matrix, stuckLights);
        for (var step = 0; step < steps; step++) {
            lightGrid = lightGrid.animate();
        }

        assertEquals(expected, lightGrid.getLightCount());
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
