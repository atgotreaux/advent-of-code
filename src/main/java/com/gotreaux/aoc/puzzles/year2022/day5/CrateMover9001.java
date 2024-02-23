package com.gotreaux.aoc.puzzles.year2022.day5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class CrateMover9001 extends CrateMover {
    CrateMover9001(Map<Integer, Deque<Character>> stacks) {
        super(stacks);
    }

    @Override
    void operate(RearrangeProcedure procedure) {
        Deque<Character> crates = new ArrayDeque<>(procedure.operationCount());

        for (int operation = 0; operation < procedure.operationCount(); operation++) {
            crates.push(stacks.get(procedure.from()).pop());
        }

        for (Character c : crates) {
            stacks.get(procedure.to()).push(c);
        }
    }
}
