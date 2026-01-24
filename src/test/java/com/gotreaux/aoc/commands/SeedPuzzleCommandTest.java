package com.gotreaux.aoc.commands;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import org.springframework.shell.core.command.CommandExecutionException;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.autoconfigure.ShellTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@ShellTest
@SpringBootTest
class SeedPuzzleCommandTest {

    @Autowired private List<Puzzle> puzzles;
    @Autowired private PuzzleRepository puzzleRepository;
    @MockitoBean private HttpClient httpClient;

    @Test
    void commandAvailable(@Autowired ShellTestClient client) throws Exception {
        var screen = client.sendCommand("help");

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText(SeedPuzzleCommand.COMMAND_NAME));
    }

    @Test
    void help(@Autowired ShellTestClient client) throws Exception {
        var screen = client.sendCommand(SeedPuzzleCommand.COMMAND_NAME + " --help");

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText(SeedPuzzleCommand.COMMAND_NAME));
    }

    @Test
    void yearRequired(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(bytes);
        var session = HexFormat.of().formatHex(md.digest());

        var exception =
                assertThrows(
                        CommandExecutionException.class,
                        () ->
                                client.sendCommand(
                                        SeedPuzzleCommand.COMMAND_NAME
                                                + " -d "
                                                + puzzle.getDay()
                                                + " -s "
                                                + session));

        assertTrue(
                exception.getCause().getMessage().contains("Required option '--year' is missing."));
    }

    @Test
    void dayRequired(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(bytes);
        var session = HexFormat.of().formatHex(md.digest());

        var command = SeedPuzzleCommand.COMMAND_NAME + " -y " + puzzle.getYear() + " -s " + session;

        var exception =
                assertThrows(CommandExecutionException.class, () -> client.sendCommand(command));

        assertTrue(
                exception.getCause().getMessage().contains("Required option '--day' is missing."));
    }

    @Test
    void sessionRequired(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var exception =
                assertThrows(
                        CommandExecutionException.class,
                        () ->
                                client.sendCommand(
                                        SeedPuzzleCommand.COMMAND_NAME
                                                + " -y "
                                                + puzzle.getYear()
                                                + " -d "
                                                + puzzle.getDay()));

        assertTrue(
                exception
                        .getCause()
                        .getMessage()
                        .contains("Required option '--session' is missing."));
    }

    @Test
    void clientThrowsIOException(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(bytes);
        var session = HexFormat.of().formatHex(md.digest());

        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenThrow(new IOException("Mock IOException"));

        var screen =
                client.sendCommand(
                        SeedPuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -s "
                                + session);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText("Unable to fetch puzzle input from URL"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());

        assertEquals(0L, puzzleRepository.count());
    }

    @Test
    void clientThrowsInterruptedException(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var session = HexFormat.of().formatHex(md.digest());

        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenThrow(new InterruptedException("Mock InterruptedException"));

        var screen =
                client.sendCommand(
                        SeedPuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -s "
                                + session);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText("HTTP request to URL"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());

        assertEquals(0L, puzzleRepository.count());
    }

    @Test
    void statusCodeMessage(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var session = HexFormat.of().formatHex(md.digest());

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_UNAUTHORIZED);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var screen =
                client.sendCommand(
                        SeedPuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -s "
                                + session);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText("Unable to fetch puzzle input."));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse, Mockito.times(2)).statusCode();

        assertEquals(0L, puzzleRepository.count());
    }

    @Test
    void emptyResponseMessage(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var session = HexFormat.of().formatHex(md.digest());

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(null);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var screen =
                client.sendCommand(
                        SeedPuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -s "
                                + session);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText("Empty or null response body from URL"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse).statusCode();
        Mockito.verify(mockResponse).body();

        assertEquals(0L, puzzleRepository.count());
    }

    @Test
    @DirtiesContext
    void writesToDatabase(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var session = HexFormat.of().formatHex(md.digest());

        var input = RandomString.make(10);

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(input);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var screen =
                client.sendCommand(
                        SeedPuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -s "
                                + session);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
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
    void writesToFile(@Autowired ShellTestClient client) throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var session = HexFormat.of().formatHex(md.digest());

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

        var screen =
                client.sendCommand(
                        SeedPuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -s "
                                + session
                                + " -t "
                                + "\""
                                + inputPath
                                + "\"");

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText("Successfully seeded input to targets"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse).statusCode();
        Mockito.verify(mockResponse).body();

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    @DirtiesContext
    void writesToResource(@Autowired ShellTestClient client) throws Exception {
        var puzzle = new ApartmentFloorPuzzle();

        var generator = RandomGenerator.getDefault();
        var sessionBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(sessionBytes);

        var md = MessageDigest.getInstance("SHA-512");
        md.update(sessionBytes);
        var session = HexFormat.of().formatHex(md.digest());

        var input = RandomString.make(10);

        HttpResponse<String> mockResponse = Mockito.mock();
        Mockito.when(mockResponse.statusCode()).thenReturn(HttpURLConnection.HTTP_OK);
        Mockito.when(mockResponse.body()).thenReturn(input);
        Mockito.when(httpClient.send(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(_ -> mockResponse);

        var screen =
                client.sendCommand(
                        SeedPuzzleCommand.COMMAND_NAME
                                + " -y "
                                + puzzle.getYear()
                                + " -d "
                                + puzzle.getDay()
                                + " -s "
                                + session
                                + " -t "
                                + InputWriterFactory.RESOURCE_WRITER);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(screen)
                                        .containsText("Successfully seeded input to targets"));

        Mockito.verify(httpClient).send(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verify(mockResponse).statusCode();
        Mockito.verify(mockResponse).body();

        InputReader inputReader = new ResourceInputReader<>(ApartmentFloorPuzzle.class);

        assertEquals(input, inputReader.getInputString());
    }
}
