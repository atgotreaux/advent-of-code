package com.gotreaux.aoc.puzzles.year2015.day7;

import com.gotreaux.aoc.puzzles.year2015.day7.wire.Wire;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Circuit {
    private final Collection<Wire> wires;
    private final Map<String, Integer> memo = new HashMap<>();

    public Circuit(Collection<Wire> wires) {
        this.wires = List.copyOf(wires);
    }

    public int evaluate(String signal) {
        if (signal.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(signal);
        }

        if (memo.containsKey(signal)) {
            return memo.get(signal);
        }

        var wire = getWire(signal);
        var result = wire.evaluate(this);
        memo.put(wire.getLabel(), result);

        return result;
    }

    Wire getWire(String signal) {
        return wires.stream()
                .filter(wire -> wire.getLabel().equals(signal))
                .findFirst()
                .orElseThrow();
    }
}
