package com.gotreaux.aoc.commands;

import static org.awaitility.Awaitility.await;

import com.gotreaux.aoc.Application;
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
@SpringBootTest(classes = Application.class)
class SolvePuzzleCommandTest {
    @Autowired ShellTestClient client;

    @Test
    void solvePuzzleCommandAvailable() {
        ShellTestClient.NonInteractiveShellSession session = client.nonInterative("help").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("solve-puzzle"));
    }

    @Test
    void solvePuzzleHelp() {
        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative("solve-puzzle", "--help").run();

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
                client.nonInterative("solve-puzzle", "-Y", year).run();

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
                client.nonInterative("solve-puzzle", "-D", day).run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Event days"));
    }

    @Test
    void solvePuzzleOutput() {
        ShellTestClient.NonInteractiveShellSession session =
                client.nonInterative("solve-puzzle", "-Y", "2015", "-D", "1").run();

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(
                        () ->
                                ShellAssertions.assertThat(session.screen())
                                        .containsText("Not Quite Lisp"));
    }
}
