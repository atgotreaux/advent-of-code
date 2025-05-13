package com.gotreaux.aoc.puzzles.year2015.day7.wire;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.AndGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.LeftShiftGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.NotGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.OrGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.RightShiftGate;

public abstract class Wire {

    public static Wire of(String line) {
        var parts = line.split(" ");
        return switch (line) {
            case String s when s.contains("AND") ->
                    new GateWire(parts[4], new AndGate(parts[0], parts[2]));
            case String s when s.contains("OR") ->
                    new GateWire(parts[4], new OrGate(parts[0], parts[2]));
            case String s when s.contains("NOT") -> new GateWire(parts[3], new NotGate(parts[1]));
            case String s when s.contains("LSHIFT") ->
                    new GateWire(parts[4], new LeftShiftGate(parts[0], parts[2]));
            case String s when s.contains("RSHIFT") ->
                    new GateWire(parts[4], new RightShiftGate(parts[0], parts[2]));
            default -> new SignalWire(parts[2], parts[0]);
        };
    }

    private final String label;

    Wire(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public abstract int evaluate(Circuit circuit);
}
