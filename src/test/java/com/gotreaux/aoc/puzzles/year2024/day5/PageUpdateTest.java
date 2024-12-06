package com.gotreaux.aoc.puzzles.year2024.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PageUpdateTest {

    @ParameterizedTest
    @MethodSource("provideFrom")
    void from(String line, Collection<Integer> expectedPages) {
        PageUpdate pageUpdate = PageUpdate.from(line);

        assertEquals(expectedPages, pageUpdate.getPages());
    }

    @ParameterizedTest
    @MethodSource("provideIsCorrectOrder")
    void isCorrectOrder(String line, boolean expected) throws Exception {
        PageUpdate pageUpdate = PageUpdate.from(line);

        InputReader inputReader = new ResourceInputReader<>(PrintQueuePuzzle.class, "rules.txt");

        List<PageOrderingRule> rules =
                inputReader.getInputStream().map(PageOrderingRule::from).toList();

        assertEquals(expected, pageUpdate.isCorrectOrder(rules));
    }

    @ParameterizedTest
    @MethodSource("provideGetMiddlePage")
    void getMiddlePage(String line, int expectedMiddlePage) throws Exception {
        PageUpdate pageUpdate = PageUpdate.from(line);

        InputReader inputReader = new ResourceInputReader<>(PrintQueuePuzzle.class, "rules.txt");

        List<PageOrderingRule> rules =
                inputReader.getInputStream().map(PageOrderingRule::from).toList();

        assertEquals(expectedMiddlePage, pageUpdate.getMiddlePage(rules));
    }

    private static Stream<Arguments> provideFrom() {
        return Stream.of(
                Arguments.of("75,47,61,53,29", List.of(75, 47, 61, 53, 29)),
                Arguments.of("97,61,53,29,13", List.of(97, 61, 53, 29, 13)),
                Arguments.of("75,29,13", List.of(75, 29, 13)));
    }

    private static Stream<Arguments> provideIsCorrectOrder() {
        return Stream.of(
                Arguments.of("75,47,61,53,29", true),
                Arguments.of("97,61,53,29,13", true),
                Arguments.of("75,29,13", true),
                Arguments.of("75,97,47,61,53", false),
                Arguments.of("61,13,29", false),
                Arguments.of("97,13,75,29,47", false));
    }

    private static Stream<Arguments> provideGetMiddlePage() {
        return Stream.of(
                Arguments.of("75,47,61,53,29", 61),
                Arguments.of("97,61,53,29,13", 53),
                Arguments.of("75,29,13", 29),
                Arguments.of("75,97,47,61,53", 47),
                Arguments.of("61,13,29", 29),
                Arguments.of("97,13,75,29,47", 47));
    }
}
