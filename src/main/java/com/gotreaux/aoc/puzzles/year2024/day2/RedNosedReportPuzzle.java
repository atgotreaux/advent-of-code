package com.gotreaux.aoc.puzzles.year2024.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RedNosedReportPuzzle extends Puzzle {

    protected RedNosedReportPuzzle() {
        super(2024, 2);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) throws Exception {
        List<Report> reports = inputReader.getInputStream().map(Report::from).toList();

        long numOfSafeReports = reports.stream().filter(Report::isSafe).count();

        long numOfSafeReportsWithTolerance =
                reports.stream().filter(Report::isSafeWithTolerance).count();

        return new PuzzleOutput<>(numOfSafeReports, numOfSafeReportsWithTolerance);
    }
}
