package com.gotreaux.aoc.puzzles.year2019.day4;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@ShellPuzzle(year = 2019, day = 4, title = "Secure Container")
public class SecureContainerPuzzle extends Puzzle {
    public SecureContainerPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        Scanner scanner = new Scanner(getInputProvider().getInputString());
        scanner.useDelimiter("-");
        int start = scanner.nextInt();
        int stop = scanner.nextInt();
        scanner.close();

        Predicate<String> adjacentDigits =
                s -> {
                    for (int i = 0; i < s.length() - 1; i++) {
                        if (s.charAt(i) == s.charAt(i + 1)) {
                            return true;
                        }
                    }
                    return false;
                };
        Predicate<String> increasingDigits =
                s -> {
                    for (int i = 0; i < s.length() - 1; i++) {
                        if (Character.digit(s.charAt(i), 10)
                                > Character.digit(s.charAt(i + 1), 10)) {
                            return false;
                        }
                    }
                    return true;
                };
        Predicate<String> digitPair =
                s ->
                        s.chars()
                                .mapToObj(codePoint -> Character.toString(codePoint).charAt(0))
                                .collect(
                                        Collectors.groupingBy(
                                                Function.identity(), Collectors.counting()))
                                .containsValue(2L);

        Predicate<String> validPassword = adjacentDigits.and(increasingDigits);
        Predicate<String> validPasswordNoLargerGroups = digitPair.and(increasingDigits);

        int validPasswords = 0;
        int validPasswordsNoLargerGroups = 0;
        for (int i = start; i <= stop; i++) {
            if (validPassword.test(String.valueOf(i))) {
                validPasswords++;
            }
            if (validPasswordNoLargerGroups.test(String.valueOf(i))) {
                validPasswordsNoLargerGroups++;
            }
        }

        return new PuzzleOutput<>(validPasswords, validPasswordsNoLargerGroups);
    }
}
