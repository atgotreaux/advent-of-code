package com.gotreaux.aoc.puzzles.year2022.day4;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import java.util.stream.Stream;

@ShellPuzzle(year = 2022, day = 4, title = "Camp Cleanup")
public class CampCleanupPuzzle extends Puzzle {

    private long numberOfAssignmentsContained;
    private long numberOfAssignmentsOverlapping;

    public CampCleanupPuzzle(InputProvider inputProvider) throws Exception {
        super(inputProvider);

        prepare();
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(
                    line -> {
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
                                        secondSectionRange.nextLong(),
                                        secondSectionRange.nextLong());
                        secondSectionRange.close();

                        if (firstAssignment.contains(secondAssignment)
                                || secondAssignment.contains(firstAssignment)) {
                            numberOfAssignmentsContained++;
                        }
                        if (firstAssignment.overlaps(secondAssignment)) {
                            numberOfAssignmentsOverlapping++;
                        }
                    });
        }
    }

    @Override
    public Long getPartOne() {
        return numberOfAssignmentsContained;
    }

    @Override
    public Long getPartTwo() {
        return numberOfAssignmentsOverlapping;
    }
}
