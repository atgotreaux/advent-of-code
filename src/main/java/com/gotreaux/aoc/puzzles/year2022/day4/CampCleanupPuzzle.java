package com.gotreaux.aoc.puzzles.year2022.day4;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;

@ShellPuzzle(year = 2022, day = 4, title = "Camp Cleanup")
public class CampCleanupPuzzle extends Puzzle {

    public CampCleanupPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int numberOfAssignmentsContained = 0;
        int numberOfAssignmentsOverlapping = 0;

        for (String line : getInputProvider().getInputList()) {
            Scanner elfAssignments = new Scanner(line);
            elfAssignments.useDelimiter(",");
            String assignmentOne = elfAssignments.next();
            String assignmentTwo = elfAssignments.next();
            elfAssignments.close();

            Scanner firstSectionRange = new Scanner(assignmentOne);
            firstSectionRange.useDelimiter("-");
            SectionAssignment firstAssignment =
                    new SectionAssignment(
                            firstSectionRange.nextLong(), firstSectionRange.nextLong());
            firstSectionRange.close();

            Scanner secondSectionRange = new Scanner(assignmentTwo);
            secondSectionRange.useDelimiter("-");
            SectionAssignment secondAssignment =
                    new SectionAssignment(
                            secondSectionRange.nextLong(), secondSectionRange.nextLong());
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
