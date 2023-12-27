package com.gotreaux.year2022.day4;

import com.gotreaux.Puzzle;

import java.util.Scanner;
import java.util.stream.Stream;

public class CampCleanupPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        CampCleanupPuzzle puzzle = new CampCleanupPuzzle();

        puzzle.solve();
    }

    private long numberOfAssignmentsContained;
    private long numberOfAssignmentsOverlapping;

    public CampCleanupPuzzle() throws Exception {
        super();

        prepare();
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                Scanner elfAssignments = new Scanner(line);
                elfAssignments.useDelimiter(",");
                String assignmentOne = elfAssignments.next();
                String assignmentTwo = elfAssignments.next();
                elfAssignments.close();

                Scanner firstSectionRange = new Scanner(assignmentOne);
                firstSectionRange.useDelimiter("-");
                SectionAssignment firstAssignment = new SectionAssignment(firstSectionRange.nextLong(), firstSectionRange.nextLong());
                firstSectionRange.close();

                Scanner secondSectionRange = new Scanner(assignmentTwo);
                secondSectionRange.useDelimiter("-");
                SectionAssignment secondAssignment = new SectionAssignment(secondSectionRange.nextLong(), secondSectionRange.nextLong());
                secondSectionRange.close();

                if (firstAssignment.contains(secondAssignment) || secondAssignment.contains(firstAssignment)) {
                    numberOfAssignmentsContained++;
                }
                if (firstAssignment.overlaps(secondAssignment)) {
                    numberOfAssignmentsOverlapping++;
                }
            });
        }
    }

    @Override
    public Long getPartOne() throws Exception {
        return numberOfAssignmentsContained;
    }

    @Override
    public Long getPartTwo() throws Exception {
        return numberOfAssignmentsOverlapping;
    }
}
