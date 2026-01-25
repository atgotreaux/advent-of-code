package com.gotreaux.aoc.puzzles.year2025.day6;

import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.RayNavigator;
import com.gotreaux.aoc.utils.matrix.provider.CharMatrixProvider;
import com.gotreaux.aoc.utils.regex.PatternUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class RtlVerticalWorksheet extends Worksheet {

    static RtlVerticalWorksheet of(List<String> input) {
        var operators =
                PatternUtils.ANY_WHITESPACE
                        .splitAsStream(input.getLast().trim())
                        .map(label -> EnumUtils.of(Operator.class, label.charAt(0)))
                        .toList()
                        .reversed();

        List<List<Long>> operandLists = new ArrayList<>();
        List<Long> operandList = new ArrayList<>();
        var matrix = new Matrix<>(input.subList(0, input.size() - 1), new CharMatrixProvider());
        for (var col = matrix.getColCount() - 1; col >= -1; col--) {
            var navigator = new RayNavigator<>(matrix, new Cell(-1, col));
            var colElements = navigator.collectElements(Direction.SOUTH);
            var colString =
                    colElements.stream()
                            .collect(
                                    StringBuilder::new,
                                    StringBuilder::append,
                                    StringBuilder::append)
                            .toString()
                            .trim();
            if (colString.isEmpty()) {
                operandLists.add(operandList);
                operandList = new ArrayList<>();
            } else {
                operandList.add(Long.parseLong(colString));
            }
        }

        return new RtlVerticalWorksheet(operandLists, operators);
    }

    private RtlVerticalWorksheet(
            Collection<List<Long>> operandLists, Collection<Operator> operators) {
        if (operandLists.size() != operators.size()) {
            throw new IllegalArgumentException(
                    "Operand lists and operators must have the same size");
        }
        super(operandLists, operators);
    }

    @Override
    protected List<Long> getOperands(int operatorIndex) {
        return getOperandLists().get(operatorIndex);
    }
}
