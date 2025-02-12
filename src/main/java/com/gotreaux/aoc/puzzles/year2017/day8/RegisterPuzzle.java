package com.gotreaux.aoc.puzzles.year2017.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class RegisterPuzzle extends Puzzle {

    public RegisterPuzzle() {
        super(2017, 8);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        List<String> input = inputReader.getInputList();

        Map<String, Integer> registers =
                input.stream()
                        .map(line -> line.split(" ")[0])
                        .collect(Collectors.toMap(Function.identity(), _ -> 0, (x, _) -> x));

        int maxRegisterValue = Integer.MIN_VALUE;
        for (String line : input) {
            String[] instructionParts = line.split(" ");

            String register = instructionParts[0];
            Instruction instruction = Instruction.of(instructionParts[1]);
            int amount = Integer.parseInt(instructionParts[2]);
            String operandRegister = instructionParts[4];
            ComparisonOperator comparisonOperator = ComparisonOperator.of(instructionParts[5]);
            int comparisonValue = Integer.parseInt(instructionParts[6]);

            boolean expressionResult =
                    switch (comparisonOperator) {
                        case EQ -> registers.get(operandRegister) == comparisonValue;
                        case NE -> registers.get(operandRegister) != comparisonValue;
                        case LT -> registers.get(operandRegister) < comparisonValue;
                        case GT -> registers.get(operandRegister) > comparisonValue;
                        case LTE -> registers.get(operandRegister) <= comparisonValue;
                        case GTE -> registers.get(operandRegister) >= comparisonValue;
                    };

            if (expressionResult) {
                int resultValue =
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
