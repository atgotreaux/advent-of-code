package com.gotreaux.aoc.puzzles.year2015.day7.wire;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SignalWireTest {
    @ParameterizedTest
    @MethodSource("provideEvaluate")
    void evaluate(String label, int signal) {
        Wire wire = new SignalWire(label, String.valueOf(signal));

        Circuit circuit = new Circuit(List.of(wire));

        assertEquals(signal, wire.evaluate(circuit));
    }

    private static Stream<Arguments> provideEvaluate() {
        return Stream.of(Arguments.of("x", 123), Arguments.of("y", 456));
    }

    @Test
    void evaluateWireSignal() {
        Wire signalWire = new SignalWire("x", "123");
        Wire wire = new SignalWire("y", "x");

        Circuit circuit = new Circuit(List.of(signalWire, wire));

        assertEquals(123, wire.evaluate(circuit));
    }
}
