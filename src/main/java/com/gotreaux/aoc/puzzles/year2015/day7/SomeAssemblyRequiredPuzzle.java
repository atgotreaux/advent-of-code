package com.gotreaux.aoc.puzzles.year2015.day7;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.AndGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.LeftShiftGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.NotGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.OrGate;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.RightShiftGate;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.GateWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.SignalWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.Wire;
import java.util.ArrayList;
import java.util.List;

@ShellPuzzle(year = 2015, day = 7, title = "Some Assembly Required")
public class SomeAssemblyRequiredPuzzle extends Puzzle {
    public SomeAssemblyRequiredPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        List<Wire> wires = new ArrayList<>();

        for (String line : getInputProvider().getInputList()) {
            String[] parts = line.split(" ");
            Wire wire =
                    switch (line) {
                        case String s when s.contains("AND") ->
                                new GateWire(parts[4], new AndGate(parts[0], parts[2]));
                        case String s when s.contains("OR") ->
                                new GateWire(parts[4], new OrGate(parts[0], parts[2]));
                        case String s when s.contains("NOT") ->
                                new GateWire(parts[3], new NotGate(parts[1]));
                        case String s when s.contains("LSHIFT") ->
                                new GateWire(parts[4], new LeftShiftGate(parts[0], parts[2]));
                        case String s when s.contains("RSHIFT") ->
                                new GateWire(parts[4], new RightShiftGate(parts[0], parts[2]));
                        default -> new SignalWire(parts[2], parts[0]);
                    };
            wires.add(wire);
        }

        Circuit firstCircuit = new Circuit(wires);
        int signalA = firstCircuit.evaluate("a");

        wires.removeIf(wire -> wire.getLabel().equals("b"));
        wires.add(new SignalWire("b", String.valueOf(signalA)));
        Circuit secondCircuit = new Circuit(wires);

        return new PuzzleOutput<>(signalA, secondCircuit.evaluate("a"));
    }
}
