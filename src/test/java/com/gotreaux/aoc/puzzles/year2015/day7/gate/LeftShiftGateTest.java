package com.gotreaux.aoc.puzzles.year2015.day7.gate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.SignalWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.Wire;
import java.util.List;
import org.junit.jupiter.api.Test;

class LeftShiftGateTest {
    @Test
    void evaluate() {
        List<Wire> wires = List.of(new SignalWire("x", "123"));

        Circuit circuit = new Circuit(wires);

        Gate gate = new LeftShiftGate("x", "2");

        assertEquals(492, gate.evaluate(circuit));
    }
}
