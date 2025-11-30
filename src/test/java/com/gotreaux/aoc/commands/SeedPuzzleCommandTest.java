package com.gotreaux.aoc.commands;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.DatabaseInputReader;
import com.gotreaux.aoc.input.reader.FileInputReader;
import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.input.writer.InputWriterFactory;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2015.day1.ApartmentFloorPuzzle;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.autoconfigure.AutoConfigureShell;
import org.springframework.shell.test.autoconfigure.AutoConfigureShellTestClient;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@AutoConfigureShell
@AutoConfigureShellTestClient
@SpringBootTest
class SeedPuzzleCommandTest {
    @Autowired private ShellTestClient client;
    @Autowired private List<Puzzle> puzzles;
    @Autowired private PuzzleRepository puzzleRepository;
    @MockitoBean private HttpClient httpClient;

    @Test
    void commandAvailable() {
        var session = client.nonInterative("help").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText(SeedPuzzleCommand.COMMAND_NAME));
    }

    @Test
    void help() {
        var session = client.nonInterative(SeedPuzzleCommand.COMMAND_NAME, "--help").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText(
                                                "help for %s"
                                                        .formatted(
                                                                SeedPuzzleCommand.COMMAND_NAME)));
    }

    @Test
    void yearRequired() {
        var session = client.nonInterative(SeedPuzzleCommand.COMMAND_NAME).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Missing mandatory option '--year'"));
    }

    @Test
    void invalidYear() throws NoSuchAlgorithmException {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var year = String.valueOf(generator.nextInt(2015));

        var bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(bytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                year,
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText(
                                                "--year: must be greater than or equal to 2015"));
    }

    @Test
    void dayRequired() {
        var session = client.nonInterative(SeedPuzzleCommand.COMMAND_NAME).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Missing mandatory option '--day'"));
    }

    @Test
    void invalidDay() throws NoSuchAlgorithmException {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var day = String.valueOf(generator.nextInt(26, 32));

        var bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(bytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                day,
                                "-S",
                                sessionId)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("--day: must be less than or equal to 25"));
    }

    @Test
    void sessionRequired() {
        var session = client.nonInterative(SeedPuzzleCommand.COMMAND_NAME).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Missing mandatory option '--session'"));
    }

    @Test
    void invalidSession() throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        var md = MessageDigest.getInstance("MD5");
        md.update(bytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("--session: must match \"^[a-f0-9]{128}$\""));
    }

    @Test
    void clientThrowsIOException() throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenThrow(new IOException("Mock IOException"));

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Unable to fetch puzzle input from URL"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());

        assertEquals(0L, puzzleRepository.count());
    }

    @Test
    void clientThrowsInterruptedException() throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenThrow(new InterruptedException("Mock InterruptedException"));

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("HTTP request to URL"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());

        assertEquals(0L, puzzleRepository.count());
    }

    @Test
    void statusCodeMessage() throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_UNAUTHORIZED);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Unable to fetch puzzle input."));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse, Mockito.times(2)).statusCode();

        assertEquals(0L, puzzleRepository.count());
    }

    @Test
    void emptyResponseMessage() throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(null);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Empty or null response body from URL"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse).statusCode();
        Mockito.verify(mockResponse).body();

        assertEquals(0L, puzzleRepository.count());
    }

    @Test
    @DirtiesContext
    void writesToDatabase() throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        var input = RandomString.make(10);

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(input);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Successfully seeded input to targets"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse).statusCode();
        Mockito.verify(mockResponse).body();

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(input, inputReader.getInputString());
        assertEquals(1L, puzzleRepository.count());
    }

    @Test
    @DirtiesContext
    void writesToFile() throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        var input = RandomString.make(10);

        var path = Files.createTempFile("input", ".txt");

        var inputPath =
                path.toAbsolutePath()
                        .toString()
                        .replaceAll(
                                Pattern.quote(File.separator),
                                Matcher.quoteReplacement(File.separator.repeat(2)));

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(input);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId,
                                "-T",
                                "\"" + inputPath + "\"")
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Successfully seeded input to targets"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse).statusCode();
        Mockito.verify(mockResponse).body();

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    @DirtiesContext
    void writesToResource() throws Exception {
        var puzzle = new ApartmentFloorPuzzle();

        var generator = RandomGenerator.getDefault();
        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var sessionId = HexFormat.of().formatHex(md.digest());

        var input = RandomString.make(10);

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(input);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var session =
                client.nonInterative(
                                SeedPuzzleCommand.COMMAND_NAME,
                                "-Y",
                                String.valueOf(puzzle.getYear()),
                                "-D",
                                String.valueOf(puzzle.getDay()),
                                "-S",
                                sessionId,
                                "-T",
                                InputWriterFactory.RESOURCE_WRITER)
                        .run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Successfully seeded input to targets"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse).statusCode();
        Mockito.verify(mockResponse).body();

        InputReader inputReader = new ResourceInputReader<>(ApartmentFloorPuzzle.class);

        assertEquals(input, inputReader.getInputString());
    }
}
