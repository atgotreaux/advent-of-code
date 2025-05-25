package com.gotreaux.aoc.puzzles.year2022.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class CampCleanupPuzzle extends Puzzle {

    public CampCleanupPuzzle() {
        super(2022, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var numberOfAssignmentsContained = 0;
        var numberOfAssignmentsOverlapping = 0;

        for (var line : inputReader.getInputList()) {
            var elfAssignments = new Scanner(line);
            elfAssignments.useDelimiter(",");
            var assignmentOne = elfAssignments.next();
            var assignmentTwo = elfAssignments.next();
            elfAssignments.close();

            var firstSectionRange = new Scanner(assignmentOne);
            firstSectionRange.useDelimiter("-");
            var firstAssignment =
                    new SectionAssignment(firstSectionRange.nextInt(), firstSectionRange.nextInt());
            firstSectionRange.close();

            var secondSectionRange = new Scanner(assignmentTwo);
            secondSectionRange.useDelimiter("-");
            var secondAssignment =
                    new SectionAssignment(
                            secondSectionRange.nextInt(), secondSectionRange.nextInt());
            secondSectionRange.close();

            if (firstAssignment.contains(secondAssignment)
                    || secondAssignment.contains(firstAssignment)) {
                numberOfAssignmentsContained++;
            }
            if (firstAssignment.overlaps(secondAssignment)) {
                numberOfAssignmentsOverlapping++;
            }
        }

        return new PuzzleOutput<>(numberOfAssignmentsContained, numberOfAssignmentsOverlapping);
    }
}
