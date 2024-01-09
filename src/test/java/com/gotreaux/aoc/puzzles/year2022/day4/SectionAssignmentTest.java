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
        RandomGenerator generator = RandomGenerator.getDefault();
        long firstSection = generator.nextLong(2L, 1000L);
        long lastSection = generator.nextLong(firstSection - 1);

        assertThrows(
                IllegalArgumentException.class,
                () -> new SectionAssignment(firstSection, lastSection));
    }

    @ParameterizedTest
    @MethodSource("provideContainsSection")
    void containsSection(
            long firstAssignmentFirstSection,
            long firstAssignmentLastSection,
            long secondAssignmentFirstSection,
            long secondAssignmentLastSection) {
        SectionAssignment firstAssignment =
                new SectionAssignment(firstAssignmentFirstSection, firstAssignmentLastSection);
        SectionAssignment secondAssignment =
                new SectionAssignment(secondAssignmentFirstSection, secondAssignmentLastSection);

        assertTrue(firstAssignment.contains(secondAssignment));
    }

    @ParameterizedTest
    @MethodSource("provideDoesNotContainSection")
    void doesNotContainSection(
            long firstAssignmentFirstSection,
            long firstAssignmentLastSection,
            long secondAssignmentFirstSection,
            long secondAssignmentLastSection) {
        SectionAssignment firstAssignment =
                new SectionAssignment(firstAssignmentFirstSection, firstAssignmentLastSection);
        SectionAssignment secondAssignment =
                new SectionAssignment(secondAssignmentFirstSection, secondAssignmentLastSection);

        assertFalse(firstAssignment.contains(secondAssignment));
    }

    @ParameterizedTest
    @MethodSource("provideOverlapsSection")
    void overlapsSection(
            long firstAssignmentFirstSection,
            long firstAssignmentLastSection,
            long secondAssignmentFirstSection,
            long secondAssignmentLastSection) {
        SectionAssignment firstAssignment =
                new SectionAssignment(firstAssignmentFirstSection, firstAssignmentLastSection);
        SectionAssignment secondAssignment =
                new SectionAssignment(secondAssignmentFirstSection, secondAssignmentLastSection);

        assertTrue(firstAssignment.overlaps(secondAssignment));
    }

    @ParameterizedTest
    @MethodSource("doesNotOverlapSection")
    void doesNotOverlapSection(
            long firstAssignmentFirstSection,
            long firstAssignmentLastSection,
            long secondAssignmentFirstSection,
            long secondAssignmentLastSection) {
        SectionAssignment firstAssignment =
                new SectionAssignment(firstAssignmentFirstSection, firstAssignmentLastSection);
        SectionAssignment secondAssignment =
                new SectionAssignment(secondAssignmentFirstSection, secondAssignmentLastSection);

        assertFalse(firstAssignment.overlaps(secondAssignment));
    }

    private static Stream<Arguments> provideContainsSection() {
        return Stream.of(Arguments.of(2L, 8L, 3L, 7L), Arguments.of(4L, 6L, 6L, 6L));
    }

    private static Stream<Arguments> provideDoesNotContainSection() {
        return Stream.of(
                Arguments.of(2L, 4L, 6L, 8L),
                Arguments.of(2L, 3L, 4L, 5L),
                Arguments.of(5L, 7L, 7L, 9L),
                Arguments.of(3L, 7L, 2L, 8L),
                Arguments.of(6L, 6L, 4L, 6L),
                Arguments.of(2L, 6L, 4L, 8L));
    }

    private static Stream<Arguments> provideOverlapsSection() {
        return Stream.of(
                Arguments.of(5L, 7L, 7L, 9L),
                Arguments.of(7L, 9L, 5L, 7L),
                Arguments.of(2L, 8L, 3L, 7L),
                Arguments.of(3L, 7L, 2L, 8L),
                Arguments.of(6L, 6L, 4L, 6L),
                Arguments.of(4L, 6L, 6L, 6L),
                Arguments.of(2L, 6L, 4L, 8L),
                Arguments.of(4L, 8L, 2L, 6L));
    }

    private static Stream<Arguments> doesNotOverlapSection() {
        return Stream.of(
                Arguments.of(2L, 4L, 6L, 8L),
                Arguments.of(6L, 8L, 2L, 4L),
                Arguments.of(2L, 3L, 4L, 5L),
                Arguments.of(4L, 5L, 2L, 3L));
    }
}
