package com.gotreaux.aoc.puzzles.year2025.day6;

import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.regex.PatternUtils;
import java.util.Collection;
import java.util.List;

final class HorizontalWorksheet extends Worksheet {

    static HorizontalWorksheet of(List<String> input) {
        var operators =
                PatternUtils.ANY_WHITESPACE
                        .splitAsStream(input.getLast().trim())
                        .map(label -> EnumUtils.of(Operator.class, label.charAt(0)))
                        .toList();

        var operandLists =
                input.subList(0, input.size() - 1).stream()
                        .map(
                                line ->
                                        PatternUtils.ANY_WHITESPACE
                                                .splitAsStream(line.trim())
                                                .mapToLong(Long::parseLong)
                                                .boxed()
                                                .toList())
                        .toList();

        return new HorizontalWorksheet(operandLists, operators);
    }

    private HorizontalWorksheet(
            Collection<List<Long>> operandLists, Collection<Operator> operators) {
        if (!operandLists.stream()
                .allMatch(operandList -> operandList.size() == operators.size())) {
            throw new IllegalArgumentException(
                    "Operand lists and operators must have the same size");
        }
        super(operandLists, operators);
    }

    @Override
    protected List<Long> getOperands(int operatorIndex) {
        return getOperandLists().stream()
                .map(operandList -> operandList.get(operatorIndex))
                .toList();
    }
}
