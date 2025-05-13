package com.gotreaux.aoc.puzzles.year2024.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class RedNosedReportPuzzle extends Puzzle {

    protected RedNosedReportPuzzle() {
        super(2024, 2);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) throws Exception {
        var reports = inputReader.getInputStream().map(Report::of).toList();

        var numOfSafeReports =
                reports.stream().filter(report -> report.isSafe(Tolerance.NO)).count();

        var numOfSafeReportsWithTolerance =
                reports.stream().filter(report -> report.isSafe(Tolerance.YES)).count();

        return new PuzzleOutput<>(numOfSafeReports, numOfSafeReportsWithTolerance);
    }
}
