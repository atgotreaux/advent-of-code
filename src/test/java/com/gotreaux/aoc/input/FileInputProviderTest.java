package com.gotreaux.aoc.input;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.puzzles.year2016.day2.BathroomSecurityPuzzle;
import com.gotreaux.aoc.puzzles.year2018.day2.InventoryManagementSystemPuzzle;
import com.gotreaux.aoc.puzzles.year2020.day1.ReportRepairPuzzle;
import com.gotreaux.aoc.puzzles.year2020.day2.PasswordPhilosophyPuzzle;
import com.gotreaux.aoc.puzzles.year2021.day1.SonarSweepPuzzle;
import com.gotreaux.aoc.puzzles.year2023.day1.TrebuchetPuzzle;
import com.gotreaux.aoc.puzzles.year2023.day7.CamelCardsPuzzle;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FileInputProviderTest {
    @ParameterizedTest
    @MethodSource("provideInputAsStream")
    void inputAsStream(Class<?> puzzleClass, long expectedCount, String expectedFirstLine)
            throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        assertEquals(expectedCount, inputProvider.getInputStream().count());
        assertEquals(expectedFirstLine, inputProvider.getInputStream().toList().getFirst());
    }

    @ParameterizedTest
    @MethodSource("provideInputAsList")
    void inputAsList(Class<?> puzzleClass, long expectedCount, String expectedFirstLine)
            throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        assertEquals(expectedCount, inputProvider.getInputList().size());
        assertEquals(expectedFirstLine, inputProvider.getInputList().getFirst());
    }

    @ParameterizedTest
    @MethodSource("provideInputFileNameAsList")
    void inputFileNameAsList(
            Class<?> puzzleClass, String fileName, long expectedCount, String expectedFirstLine)
            throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass, fileName);

        assertEquals(expectedCount, inputProvider.getInputList().size());
        assertEquals(expectedFirstLine, inputProvider.getInputList().getFirst());
    }

    private static Stream<Arguments> provideInputAsStream() {
        return Stream.of(
                Arguments.of(SonarSweepPuzzle.class, 10, "199"),
                Arguments.of(ReportRepairPuzzle.class, 6, "1721"));
    }

    private static Stream<Arguments> provideInputAsList() {
        return Stream.of(
                Arguments.of(CamelCardsPuzzle.class, 5, "32T3K 765"),
                Arguments.of(BathroomSecurityPuzzle.class, 4, "ULL"),
                Arguments.of(PasswordPhilosophyPuzzle.class, 3, "1-3 a: abcde"));
    }

    private static Stream<Arguments> provideInputFileNameAsList() {
        return Stream.of(
                Arguments.of(InventoryManagementSystemPuzzle.class, "ExampleOne.txt", 7, "abcdef"),
                Arguments.of(InventoryManagementSystemPuzzle.class, "ExampleTwo.txt", 7, "abcde"),
                Arguments.of(TrebuchetPuzzle.class, "CalibrationDocument.txt", 4, "1abc2"),
                Arguments.of(
                        TrebuchetPuzzle.class, "CalibrationDigitsWithLetters.txt", 7, "two1nine"));
    }
}
