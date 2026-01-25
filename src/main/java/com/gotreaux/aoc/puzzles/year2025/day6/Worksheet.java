package com.gotreaux.aoc.puzzles.year2025.day6;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

abstract class Worksheet {

    private final List<List<Long>> operandLists;
    private final List<Operator> operators;

    Worksheet(Collection<List<Long>> operandLists, Collection<Operator> operators) {
        this.operandLists = operandLists.stream().toList();
        this.operators = operators.stream().toList();
    }

    List<List<Long>> getOperandLists() {
        return operandLists;
    }

    List<Operator> getOperators() {
        return operators;
    }

    long getSumOfAnswers() {
        return IntStream.range(0, operators.size())
                .mapToLong(i -> operators.get(i).operate(getOperands(i)))
                .sum();
    }

    protected abstract List<Long> getOperands(int operatorIndex);
}
