package com.gotreaux.aoc.puzzles.year2015.day7.wire;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.AndGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.LeftShiftGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.NotGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.OrGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.RightShiftGate;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GateWireTest {
    @ParameterizedTest
    @MethodSource("provideEvaluate")
    void evaluate(GateWire wire, int expected) {
        List<Wire> wires = List.of(new SignalWire("x", "123"), new SignalWire("y", "456"), wire);

        Circuit circuit = new Circuit(wires);

        assertEquals(expected, wire.evaluate(circuit));
    }

    private static Stream<Arguments> provideEvaluate() {
        return Stream.of(
                Arguments.of(new GateWire("d", new AndGate("x", "y")), 72),
                Arguments.of(new GateWire("e", new OrGate("x", "y")), 507),
                Arguments.of(new GateWire("f", new LeftShiftGate("x", "2")), 492),
                Arguments.of(new GateWire("g", new RightShiftGate("y", "2")), 114),
                Arguments.of(new GateWire("h", new NotGate("x")), 65412),
                Arguments.of(new GateWire("i", new NotGate("y")), 65079));
    }
}
