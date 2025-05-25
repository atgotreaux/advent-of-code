package com.gotreaux.aoc.puzzles.year2015.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.SignalWire;
import com.gotreaux.aoc.puzzles.year2015.day7.wire.Wire;
import java.util.Collection;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class SomeAssemblyRequiredPuzzle extends Puzzle {

    public SomeAssemblyRequiredPuzzle() {
        super(2015, 7);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        Collection<Wire> wires = inputReader.getInputStream().map(Wire::of).toList();
        var firstCircuit = new Circuit(wires);
        var signalA = firstCircuit.evaluate("a");

        Function<Wire, Wire> remapWireB =
                wire ->
                        wire.getLabel().equals("b")
                                ? new SignalWire("b", Integer.toString(signalA))
                                : wire;
        wires = wires.stream().map(remapWireB).toList();

        var secondCircuit = new Circuit(wires);

        return new PuzzleOutput<>(signalA, secondCircuit.evaluate("a"));
    }
}
