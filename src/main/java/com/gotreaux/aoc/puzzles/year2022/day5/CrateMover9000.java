package com.gotreaux.aoc.puzzles.year2022.day5;

import java.util.Deque;
import java.util.Map;

class CrateMover9000 extends CrateMover {

    CrateMover9000(Map<Integer, Deque<Character>> stacks) {
        super(stacks);
    }

    @Override
    void operate(RearrangeProcedure procedure) {
        for (var operation = 0; operation < procedure.operationCount(); operation++) {
            stacks.get(procedure.to()).push(stacks.get(procedure.from()).pop());
        }
    }
}
