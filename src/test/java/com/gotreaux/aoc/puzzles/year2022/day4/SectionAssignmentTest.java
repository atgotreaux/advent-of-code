package com.gotreaux.aoc.puzzles.year2022.day4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SectionAssignmentTest {
    @Test
    void throwsIfSectionAssignmentDescending() {
        var generator = RandomGenerator.getDefault();
        var firstSection = generator.nextInt(2, 1000);
        var lastSection = generator.nextInt(firstSection - 1);

        assertThrows(
                IllegalArgumentException.class,
                () -> new SectionAssignment(firstSection, lastSection));
    }

    @ParameterizedTest
    @MethodSource("provideContainsSection")
    void containsSection(
            int firstAssignmentFirstSection,
            int firstAssignmentLastSection,
            int secondAssignmentFirstSection,
            int secondAssignmentLastSection) {
        var firstAssignment =
                new SectionAssignment(firstAssignmentFirstSection, firstAssignmentLastSection);
        var secondAssignment =
                new SectionAssignment(secondAssignmentFirstSection, secondAssignmentLastSection);

        assertTrue(firstAssignment.contains(secondAssignment));
    }

    @ParameterizedTest
    @MethodSource("provideDoesNotContainSection")
    void doesNotContainSection(
            int firstAssignmentFirstSection,
            int firstAssignmentLastSection,
            int secondAssignmentFirstSection,
            int secondAssignmentLastSection) {
        var firstAssignment =
                new SectionAssignment(firstAssignmentFirstSection, firstAssignmentLastSection);
        var secondAssignment =
                new SectionAssignment(secondAssignmentFirstSection, secondAssignmentLastSection);

        assertFalse(firstAssignment.contains(secondAssignment));
    }

    @ParameterizedTest
    @MethodSource("provideOverlapsSection")
    void overlapsSection(
            int firstAssignmentFirstSection,
            int firstAssignmentLastSection,
            int secondAssignmentFirstSection,
            int secondAssignmentLastSection) {
        var firstAssignment =
                new SectionAssignment(firstAssignmentFirstSection, firstAssignmentLastSection);
        var secondAssignment =
                new SectionAssignment(secondAssignmentFirstSection, secondAssignmentLastSection);

        assertTrue(firstAssignment.overlaps(secondAssignment));
    }

    @ParameterizedTest
    @MethodSource("doesNotOverlapSection")
    void doesNotOverlapSection(
            int firstAssignmentFirstSection,
            int firstAssignmentLastSection,
            int secondAssignmentFirstSection,
            int secondAssignmentLastSection) {
        var firstAssignment =
                new SectionAssignment(firstAssignmentFirstSection, firstAssignmentLastSection);
        var secondAssignment =
                new SectionAssignment(secondAssignmentFirstSection, secondAssignmentLastSection);

        assertFalse(firstAssignment.overlaps(secondAssignment));
    }

    private static Stream<Arguments> provideContainsSection() {
        return Stream.of(Arguments.of(2, 8, 3, 7), Arguments.of(4, 6, 6, 6));
    }

    private static Stream<Arguments> provideDoesNotContainSection() {
        return Stream.of(
                Arguments.of(2, 4, 6, 8),
                Arguments.of(2, 3, 4, 5),
                Arguments.of(5, 7, 7, 9),
                Arguments.of(3, 7, 2, 8),
                Arguments.of(6, 6, 4, 6),
                Arguments.of(2, 6, 4, 8));
    }

    private static Stream<Arguments> provideOverlapsSection() {
        return Stream.of(
                Arguments.of(5, 7, 7, 9),
                Arguments.of(7, 9, 5, 7),
                Arguments.of(2, 8, 3, 7),
                Arguments.of(3, 7, 2, 8),
                Arguments.of(6, 6, 4, 6),
                Arguments.of(4, 6, 6, 6),
                Arguments.of(2, 6, 4, 8),
                Arguments.of(4, 8, 2, 6));
    }

    private static Stream<Arguments> doesNotOverlapSection() {
        return Stream.of(
                Arguments.of(2, 4, 6, 8),
                Arguments.of(6, 8, 2, 4),
                Arguments.of(2, 3, 4, 5),
                Arguments.of(4, 5, 2, 3));
    }
}
