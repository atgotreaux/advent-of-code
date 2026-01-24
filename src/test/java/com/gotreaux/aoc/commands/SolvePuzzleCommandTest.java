package com.gotreaux.aoc.commands;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import org.springframework.shell.core.command.CommandExecutionException;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.autoconfigure.ShellTest;
import org.springframework.test.annotation.DirtiesContext;

@ShellTest
@SpringBootTest
class SolvePuzzleCommandTest {
    @Autowired private List<Puzzle> puzzles;
    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void commandAvailable(@Autowired ShellTestClient client) throws Exception {
        var screen = client.sendCommand("help");

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText(SolvePuzzleCommand.COMMAND_NAME));
    }

    @Test
    void help(@Autowired ShellTestClient client) throws Exception {
        var screen = client.sendCommand(SolvePuzzleCommand.COMMAND_NAME + " --help");

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText(SolvePuzzleCommand.COMMAND_NAME));
    }

    @Test
    void yearRequired(@Autowired ShellTestClient client) {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var exception =
                assertThrows(
                        CommandExecutionException.class,
                        () ->
                                client.sendCommand(
                                        SolvePuzzleCommand.COMMAND_NAME
                                                + " -d "
                                                + puzzle.getDay()));

        assertTrue(
                exception.getCause().getMessage().contains("Required option '--year' is missing."));
    }

    @Test
    void dayRequired(@Autowired ShellTestClient client) {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var exception =
                assertThrows(
                        CommandExecutionException.class,
                        () ->
                                client.sendCommand(
                                        SolvePuzzleCommand.COMMAND_NAME
                                                + " -y "
                                                + puzzle.getYear()));

        assertTrue(
                exception.getCause().getMessage().contains("Required option '--day' is missing."));
    }

    @Test
    void resourceInput(@Autowired ShellTestClient client) throws Exception {
        var puzzle = new MatchsticksPuzzle();

        var screen =
                client.sendCommand(
                        SolvePuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -i "
                                + InputReaderFactory.RESOURCE_READER);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> ShellAssertions.assertThat(screen).containsText("12"));
    }

    @Test
    @DirtiesContext
    void databaseInput(@Autowired ShellTestClient client) throws Exception {
        var puzzle = new ApartmentFloorPuzzle();

        InputWriter inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());
        inputWriter.write(")())())");

        var screen =
                client.sendCommand(
                        SolvePuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -i "
                                + InputReaderFactory.DATABASE_READER);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> ShellAssertions.assertThat(screen).containsText("-3"));
    }

    @Test
    void stringInput(@Autowired ShellTestClient client) throws Exception {
        var puzzle = new ApartmentFloorPuzzle();

        var screen =
                client.sendCommand(
                        SolvePuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -i "
                                + ")())())");

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> ShellAssertions.assertThat(screen).containsText("-3"));
    }

    @Test
    void fileInput(@Autowired ShellTestClient client) throws Exception {
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

        var screen =
                client.sendCommand(
                        SolvePuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -i "
                                + "\""
                                + inputPath
                                + "\"");

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> ShellAssertions.assertThat(screen).containsText("-3"));
    }
}
