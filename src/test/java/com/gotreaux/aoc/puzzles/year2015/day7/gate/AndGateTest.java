package com.gotreaux.aoc.puzzles.year2015.day7.gate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.SignalWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.Wire;
import java.util.List;
import org.junit.jupiter.api.Test;

class AndGateTest {
    @Test
    void evaluate() {
        List<Wire> wires = List.of(new SignalWire("x", "123"), new SignalWire("y", "456"));

        Circuit circuit = new Circuit(wires);

        Gate gate = new OrGate("x", "y");

        assertEquals(507, gate.evaluate(circuit));
    }
}
