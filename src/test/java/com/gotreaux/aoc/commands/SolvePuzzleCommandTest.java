package com.gotreaux.aoc.commands;

import static org.awaitility.Awaitility.await;

import com.gotreaux.aoc.input.reader.InputReaderFactory;
import com.gotreaux.aoc.input.writer.DatabaseInputWriter;
import com.gotreaux.aoc.input.writer.FileInputWriter;
import com.gotreaux.aoc.input.writer.InputWriter;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2015.day1.ApartmentFloorPuzzle;
import com.gotreaux.aoc.puzzles.year2015.day8.MatchsticksPuzzle;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.autoconfigure.AutoConfigureShell;
import org.springframework.shell.test.autoconfigure.AutoConfigureShellTestClient;
import org.springframework.test.annotation.DirtiesContext;

@AutoConfigureShell
@AutoConfigureShellTestClient
@SpringBootTest
class SolvePuzzleCommandTest {
    @Autowired private ShellTestClient client;
    @Autowired private List<Puzzle> puzzles;
    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void commandAvailable() {
        var session = client.nonInterative("help").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText(SolvePuzzleCommand.COMMAND_NAME));
    }

    @Test
    void help() {
        var session = client.nonInterative(SolvePuzzleCommand.COMMAND_NAME, "--help").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText(
                                                "help for %s"
                                                        .formatted(
                                                                SolvePuzzleCommand.COMMAND_NAME)));
    }

    @Test
    void yearRequired() {
        var session = client.nonInterative(SolvePuzzleCommand.COMMAND_NAME).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Missing mandatory option '--year'"));
    }

    @Test
    void invalidYear() {
        var generator = RandomGenerator.getDefault();

        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        var year = String.valueOf(generator.nextInt(2015));

        var session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                year,
                                "-D",
                                String.valueOf(puzzle.getDay()))
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("solve.year"));
    }

    @Test
    void dayRequired() {
        var session = client.nonInterative(SolvePuzzleCommand.COMMAND_NAME).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Missing mandatory option '--day'"));
    }

    @Test
    void invalidDay() {
        var generator = RandomGenerator.getDefault();

        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        var day = String.valueOf(generator.nextInt(26, 32));

        var session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                day)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("solve.day"));
    }

    @Test
    void resourceInput() {
        var puzzle = new MatchsticksPuzzle();

        var session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-I",
                                InputReaderFactory.RESOURCE_READER)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () -> ShellAssertions.assertThat(session.screen()).containsText("12"));
    }

    @Test
    @DirtiesContext
    void databaseInput() {
        var puzzle = new ApartmentFloorPuzzle();

        var inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());
        inputWriter.write(")())())");

        var session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-I",
                                InputReaderFactory.DATABASE_READER)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () -> ShellAssertions.assertThat(session.screen()).containsText("-3"));
    }

    @Test
    void stringInput() {
        var puzzle = new ApartmentFloorPuzzle();

        var session =
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

    @Test
    void fileInput() throws Exception {
        var path = Files.createTempFile("input", ".txt");

        InputWriter inputWriter = new FileInputWriter(path.toAbsolutePath().toString());
        inputWriter.write(")())())");

        var inputPath =
                path.toAbsolutePath()
                        .toString()
                        .replaceAll(
                                Pattern.quote(File.separator),
                                Matcher.quoteReplacement(File.separator.repeat(2)));

        var puzzle = new ApartmentFloorPuzzle();

        var session =
                client.nonInterative(
                                SolvePuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-I",
                                "\"" + inputPath + "\"")
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () -> ShellAssertions.assertThat(session.screen()).containsText("-3"));
    }
}
