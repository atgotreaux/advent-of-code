package com.gotreaux.aoc.puzzles.year2015.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RouteTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Route expected) {
        assertEquals(expected, Route.of(line));
    }

    @ParameterizedTest
    @MethodSource("provideMatches")
    void matches(Route route, String from, String to, boolean expected) {
        assertEquals(expected, route.matches(from, to));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("London to Dublin = 464", new Route("London", "Dublin", 464)),
                Arguments.of("London to Belfast = 518", new Route("London", "Belfast", 518)),
                Arguments.of("Dublin to Belfast = 141", new Route("Dublin", "Belfast", 141)));
    }

    private static Stream<Arguments> provideMatches() {
        return Stream.of(
                Arguments.of(new Route("London", "Dublin", 464), "London", "Dublin", true),
                Arguments.of(new Route("London", "Dublin", 464), "Dublin", "London", true),
                Arguments.of(new Route("London", "Dublin", 464), "Belfast", "Dublin", false),
                Arguments.of(new Route("London", "Dublin", 464), "London", "Belfast", false));
    }
}
