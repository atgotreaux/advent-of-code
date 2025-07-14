package com.gotreaux.aoc.puzzles.year2020.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BagTest {

    @ParameterizedTest
    @MethodSource("provideContains")
    void contains(String color, boolean expected) {
        InputReader inputReader =
                new ResourceInputReader<>(HandyHaversacksPuzzle.class, "ExampleOne.txt");

        var input = inputReader.getInputList();

        var luggage = new Luggage(input.size());
        input.forEach(luggage::addBag);

        var bag =
                luggage.getBags().stream()
                        .filter(bagCandidate -> bagCandidate.color().equals(color))
                        .findFirst()
                        .orElseThrow();

        assertEquals(expected, bag.contains("shiny gold"));
    }

    @ParameterizedTest
    @MethodSource("provideGetBagCount")
    void getBagCount(String color, long expectedCount) {
        InputReader inputReader =
                new ResourceInputReader<>(HandyHaversacksPuzzle.class, "ExampleOne.txt");

        var input = inputReader.getInputList();

        var luggage = new Luggage(input.size());
        input.forEach(luggage::addBag);

        var bag =
                luggage.getBags().stream()
                        .filter(bagCandidate -> bagCandidate.color().equals(color))
                        .findFirst()
                        .orElseThrow();

        assertEquals(expectedCount, bag.getBagCount());
    }

    private static Stream<Arguments> provideContains() {
        return Stream.of(
                Arguments.of("light red", true),
                Arguments.of("dark orange", true),
                Arguments.of("bright white", true),
                Arguments.of("muted yellow", true),
                Arguments.of("shiny gold", false),
                Arguments.of("dark olive", false),
                Arguments.of("vibrant plum", false),
                Arguments.of("faded blue", false),
                Arguments.of("dotted black", false));
    }

    private static Stream<Arguments> provideGetBagCount() {
        return Stream.of(
                Arguments.of("shiny gold", 32),
                Arguments.of("dark olive", 7),
                Arguments.of("vibrant plum", 11),
                Arguments.of("faded blue", 0),
                Arguments.of("dotted black", 0));
    }
}
