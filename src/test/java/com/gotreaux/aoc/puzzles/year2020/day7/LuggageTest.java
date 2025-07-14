package com.gotreaux.aoc.puzzles.year2020.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LuggageTest {

    @ParameterizedTest
    @MethodSource("provideGetBags")
    void getBags(String fileName, int expectedBags) {
        InputReader inputReader = new ResourceInputReader<>(HandyHaversacksPuzzle.class, fileName);

        var input = inputReader.getInputList();

        var luggage = new Luggage(input.size());
        input.forEach(luggage::addBag);

        assertEquals(expectedBags, luggage.getBags().size());
    }

    private static Stream<Arguments> provideGetBags() {
        return Stream.of(
                Arguments.of("ExampleOne.txt", 9),
                Arguments.of("ExampleTwo.txt", 7)
        );
    }
}