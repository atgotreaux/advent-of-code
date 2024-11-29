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
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        int numberOfAssignmentsContained = 0;
        int numberOfAssignmentsOverlapping = 0;

        for (String line : inputReader.getInputList()) {
            Scanner elfAssignments = new Scanner(line);
            elfAssignments.useDelimiter(",");
            String assignmentOne = elfAssignments.next();
            String assignmentTwo = elfAssignments.next();
            elfAssignments.close();

            Scanner firstSectionRange = new Scanner(assignmentOne);
            firstSectionRange.useDelimiter("-");
            SectionAssignment firstAssignment =
                    new SectionAssignment(firstSectionRange.nextInt(), firstSectionRange.nextInt());
            firstSectionRange.close();

            Scanner secondSectionRange = new Scanner(assignmentTwo);
            secondSectionRange.useDelimiter("-");
            SectionAssignment secondAssignment =
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
