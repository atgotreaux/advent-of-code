package com.gotreaux.aoc.commands;

import static org.awaitility.Awaitility.await;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;
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
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class SeedPuzzleCommandTest {
    @Autowired private ShellTestClient client;
    @Autowired private List<Puzzle> puzzles;

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
}
