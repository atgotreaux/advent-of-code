package com.gotreaux.aoc.puzzles.year2024.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class BridgeRepairPuzzle extends Puzzle {

    public BridgeRepairPuzzle() {
        super(2024, 7);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) throws Exception {
        List<CalibrationEquation> equations =
                inputReader.getInputStream().map(CalibrationEquation::from).toList();

        long totalCalibrationResult =
                getTotalCalibrationResult(
                        equations, List.of(CalibrationOperator.ADD, CalibrationOperator.MULTIPLY));

        long totalCalibrationResultWithConcatenation =
                getTotalCalibrationResult(equations, List.of(CalibrationOperator.values()));

        return new PuzzleOutput<>(totalCalibrationResult, totalCalibrationResultWithConcatenation);
    }

    private static long getTotalCalibrationResult(
            Iterable<CalibrationEquation> equations, List<CalibrationOperator> operators) {
        Map<Integer, List<List<CalibrationOperator>>> combinationMap = new HashMap<>();

        long totalCalibrationResult = 0;
        for (CalibrationEquation equation : equations) {
            List<List<CalibrationOperator>> combinations =
                    combinationMap.computeIfAbsent(
                            equation.operands().size() - 1,
                            (key) -> CollectionUtils.combinations(operators, key));
            for (List<CalibrationOperator> calibrationOperators : combinations) {
                long result = equation.evaluate(calibrationOperators);
                if (result == equation.result()) {
                    totalCalibrationResult += result;
                    break;
                }
            }
        }

        return totalCalibrationResult;
    }
}
