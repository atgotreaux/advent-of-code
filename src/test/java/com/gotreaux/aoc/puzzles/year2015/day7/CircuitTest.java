package com.gotreaux.aoc.puzzles.year2015.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.puzzles.year2015.day7.gate.AndGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.LeftShiftGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.NotGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.OrGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.RightShiftGate;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.GateWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.SignalWire;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class CircuitTest {
    @Test
    void getWire() {
        var generator = RandomGenerator.getDefault();

        var wires =
                List.of(
                        new SignalWire("x", "123"),
                        new SignalWire("y", "456"),
                        new GateWire("d", new AndGate("x", "y")),
                        new GateWire("e", new OrGate("x", "y")),
                        new GateWire("f", new LeftShiftGate("x", "2")),
                        new GateWire("g", new RightShiftGate("y", "2")),
                        new GateWire("h", new NotGate("x")),
                        new GateWire("i", new NotGate("y")));

        var circuit = new Circuit(wires);

        var index = generator.nextInt(0, wires.size());
        var wire = wires.get(index);

        assertEquals(wire, circuit.getWire(wire.getLabel()));
    }

    @Test
    void throwsIfCannotFindWire() {
        var wires =
                List.of(
                        new SignalWire("x", "123"),
                        new SignalWire("y", "456"),
                        new GateWire("d", new AndGate("x", "y")),
                        new GateWire("e", new OrGate("x", "y")),
                        new GateWire("f", new LeftShiftGate("x", "2")),
                        new GateWire("g", new RightShiftGate("y", "2")),
                        new GateWire("h", new NotGate("x")),
                        new GateWire("i", new NotGate("y")));

        var circuit = new Circuit(wires);

        assertThrows(NoSuchElementException.class, () -> circuit.getWire("a"));
    }
}
