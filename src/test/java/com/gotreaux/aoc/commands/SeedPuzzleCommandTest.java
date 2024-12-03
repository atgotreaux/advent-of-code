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
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
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
        ShellTestClient.NonInteractiveShellSession session = client.nonInterative("help").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText(SeedPuzzleCommand.COMMAND_NAME));
    }

    @Test
    void help() {
        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(SeedPuzzleCommand.COMMAND_NAME, "--help").run();

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
        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(SeedPuzzleCommand.COMMAND_NAME).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Missing mandatory option '--year'"));
    }

    @Test
    void invalidYear() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        String year = String.valueOf(generator.nextInt(2015));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(bytes);
        String sessionId = HexFormat.of().formatHex(md.digest());

        ShellTestClient.NonInteractiveShellSession session =
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
                                        .containsText("Event years"));
    }

    @Test
    void dayRequired() {
        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(SeedPuzzleCommand.COMMAND_NAME).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Missing mandatory option '--day'"));
    }

    @Test
    void invalidDay() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        String day = String.valueOf(generator.nextInt(26, 32));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(bytes);
        String sessionId = HexFormat.of().formatHex(md.digest());

        ShellTestClient.NonInteractiveShellSession session =
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
                                        .containsText("Event days"));
    }

    @Test
    void sessionRequired() {
        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative(SeedPuzzleCommand.COMMAND_NAME).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Missing mandatory option '--session'"));
    }

    @Test
    void invalidSession() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bytes);
        String sessionId = HexFormat.of().formatHex(md.digest());

        ShellTestClient.NonInteractiveShellSession session =
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
                                        .containsText("Session ID should be"));
    }

    @Test
    void statusCodeMessage() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        String sessionId = HexFormat.of().formatHex(md.digest());

        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_UNAUTHORIZED);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        ShellTestClient.NonInteractiveShellSession session =
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
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        String sessionId = HexFormat.of().formatHex(md.digest());

        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(null);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        ShellTestClient.NonInteractiveShellSession session =
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
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        String sessionId = HexFormat.of().formatHex(md.digest());

        String input = RandomString.make(10);

        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(input);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        ShellTestClient.NonInteractiveShellSession session =
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
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        String sessionId = HexFormat.of().formatHex(md.digest());

        String input = RandomString.make(10);

        Path path = Files.createTempFile("input", ".txt");

        String inputPath =
                path.toAbsolutePath()
                        .toString()
                        .replaceAll(
                                Pattern.quote(File.separator),
                                Matcher.quoteReplacement(File.separator.repeat(2)));

        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(input);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        ShellTestClient.NonInteractiveShellSession session =
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
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle();

        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        String sessionId = HexFormat.of().formatHex(md.digest());

        String input = RandomString.make(10);

        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(input);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        ShellTestClient.NonInteractiveShellSession session =
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
