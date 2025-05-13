package com.gotreaux.aoc.puzzles.year2024.day7;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

record CalibrationEquation(long result, List<Long> operands) {

    private static final Pattern EQUATION_PATTERN = Pattern.compile(": | ");

    static CalibrationEquation of(CharSequence line) {
        var parts = Arrays.stream(EQUATION_PATTERN.split(line)).map(Long::parseLong).toList();

        return new CalibrationEquation(parts.getFirst(), parts.subList(1, parts.size()));
    }

    long evaluate(Iterable<CalibrationOperator> calibrationOperators) {
        long operationResult = operands.getFirst();
        var operandIndex = 1;

        for (var operator : calibrationOperators) {
            operationResult =
                    switch (operator) {
                        case ADD -> operationResult + operands.get(operandIndex);
                        case MULTIPLY -> operationResult * operands.get(operandIndex);
                        case CONCATENATE ->
                                Long.parseLong(
                                        operationResult
                                                + String.valueOf(operands.get(operandIndex)));
                    };
            operandIndex++;
        }

        return operationResult;
    }
}
