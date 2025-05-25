package com.gotreaux.aoc.puzzles.year2017.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class RegisterPuzzle extends Puzzle {

    public RegisterPuzzle() {
        super(2017, 8);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var registers =
                input.stream()
                        .map(line -> line.split(" ")[0])
                        .collect(Collectors.toMap(Function.identity(), _ -> 0, (x, _) -> x));

        var maxRegisterValue = Integer.MIN_VALUE;
        for (var line : input) {
            var instructionParts = line.split(" ");

            var register = instructionParts[0];
            var instruction = Instruction.of(instructionParts[1]);
            var amount = Integer.parseInt(instructionParts[2]);
            var operandRegister = instructionParts[4];
            var comparisonOperator = ComparisonOperator.of(instructionParts[5]);
            var comparisonValue = Integer.parseInt(instructionParts[6]);

            var expressionResult =
                    switch (comparisonOperator) {
                        case EQ -> registers.get(operandRegister) == comparisonValue;
                        case NE -> registers.get(operandRegister) != comparisonValue;
                        case LT -> registers.get(operandRegister) < comparisonValue;
                        case GT -> registers.get(operandRegister) > comparisonValue;
                        case LTE -> registers.get(operandRegister) <= comparisonValue;
                        case GTE -> registers.get(operandRegister) >= comparisonValue;
                    };

            if (expressionResult) {
                var resultValue =
                        switch (instruction) {
                            case INCREASE -> registers.get(register) + amount;
                            case DECREASE -> registers.get(register) - amount;
                        };
                maxRegisterValue = Math.max(maxRegisterValue, resultValue);
                registers.put(register, resultValue);
            }
        }

        int largestRegisterValue =
                registers.values().stream().max(Integer::compareTo).orElseThrow();

        return new PuzzleOutput<>(largestRegisterValue, maxRegisterValue);
    }
}
