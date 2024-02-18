package com.gotreaux.aoc.puzzles.year2015.day7;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.gotreaux.aoc.puzzles.year2015.day7.wire.GateWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.SignalWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.Wire;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SomeAssemblyRequiredPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideParseWire")
    void parseWire(String input, Class<? extends Wire> wireClass) {
        assertInstanceOf(wireClass, SomeAssemblyRequiredPuzzle.parseWire(input));
    }

    private static Stream<Arguments> provideParseWire() {
        return Stream.of(
                Arguments.of("123 -> x", SignalWire.class),
                Arguments.of("456 -> y", SignalWire.class),
                Arguments.of("x AND y -> d", GateWire.class),
                Arguments.of("x OR y -> e", GateWire.class),
                Arguments.of("x LSHIFT 2 -> f", GateWire.class),
                Arguments.of("y RSHIFT 2 -> g", GateWire.class),
                Arguments.of("NOT x -> h", GateWire.class),
                Arguments.of("NOT y -> i", GateWire.class));
    }
}
