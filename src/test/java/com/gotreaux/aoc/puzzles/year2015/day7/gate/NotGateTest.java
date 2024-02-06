package com.gotreaux.aoc.puzzles.year2015.day7.gate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.SignalWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.Wire;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NotGateTest {
    @ParameterizedTest
    @MethodSource("provideEvaluate")
    void evaluate(String label, int signal, int expected) {
        List<Wire> wires = List.of(new SignalWire(label, String.valueOf(signal)));

        Circuit circuit = new Circuit(wires);

        Gate gate = new NotGate(label);

        assertEquals(expected, gate.evaluate(circuit));
    }

    private static Stream<Arguments> provideEvaluate() {
        return Stream.of(Arguments.of("x", 123, 65412), Arguments.of("y", 456, 65079));
    }
}
