package com.gotreaux.aoc.commands;

import static org.awaitility.Awaitility.await;

import com.gotreaux.aoc.input.database.PuzzleInput;
import com.gotreaux.aoc.input.database.PuzzleInputKey;
import com.gotreaux.aoc.input.database.PuzzleInputRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2015.day1.ApartmentFloorPuzzle;
import com.gotreaux.aoc.puzzles.year2015.day8.MatchsticksPuzzle;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.autoconfigure.AutoConfigureShell;
import org.springframework.shell.test.autoconfigure.AutoConfigureShellTestClient;
import org.springframework.test.annotation.DirtiesContext;

@AutoConfigureShell
@AutoConfigureShellTestClient
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class SolvePuzzleCommandTest {
    @Autowired private ShellTestClient client;
    @Autowired private List<Puzzle> puzzles;
    @Autowired private MessageSource messageSource;
    @Autowired private PuzzleInputRepository puzzleInputRepository;

    @Test
    void solvePuzzleCommandAvailable() {
        ShellTestClient.NonInteractiveShellSession session = client.nonInterative("help").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText(SolvePuzzleCommand.COMMAND_NAME));
    }

    @Test
    void solvePuzzleHelp() {
        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(SolvePuzzleCommand.COMMAND_NAME, "--help").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("help for solve-puzzle"));
    }

    @Test
    void solvePuzzleInvalidEventYear() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String year = String.valueOf(generator.nextInt(2015));

        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(SolvePuzzleCommand.COMMAND_NAME, "-Y", year).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Event years"));
    }

    @Test
    void solvePuzzleInvalidEventDay() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String day = String.valueOf(generator.nextInt(26, 32));

        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(SolvePuzzleCommand.COMMAND_NAME, "-D", day).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Event days"));
    }

    @Test
    void solvePuzzleOutput() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        String code = String.format("puzzle.title.%d.%d", puzzle.getYear(), puzzle.getDay());
        String puzzleTitle = messageSource.getMessage(code, null, Locale.getDefault());

        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()))
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText(puzzleTitle));
    }

    @Test
    void solvePuzzleFileInput() {
        MatchsticksPuzzle puzzle = new MatchsticksPuzzle();

        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-I",
                                "file")
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () -> ShellAssertions.assertThat(session.screen()).containsText("12"));
    }

    @Test
    void solvePuzzleDatabaseInput() {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle();

        PuzzleInputKey inputKey = new PuzzleInputKey(puzzle.getYear(), puzzle.getDay());
        PuzzleInput puzzleInput = new PuzzleInput();
        puzzleInput.setId(inputKey);
        puzzleInput.setInputData(")())())");

        puzzleInputRepository.save(puzzleInput);

        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-I",
                                "database")
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () -> ShellAssertions.assertThat(session.screen()).containsText("-3"));
    }

    @Test
    void solvePuzzleStringInput() {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle();

        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-I",
                                ")())())")
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () -> ShellAssertions.assertThat(session.screen()).containsText("-3"));
    }
}
