package com.gotreaux.aoc.puzzles.year2019.day4;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class SecureContainerPuzzle extends Puzzle {

    public SecureContainerPuzzle() {
        super(2019, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var scanner = new Scanner(inputReader.getInputString());
        scanner.useDelimiter("-");
        var start = scanner.nextInt();
        var stop = scanner.nextInt();
        scanner.close();

        Predicate<String> adjacentDigits =
                s ->
                        IntStream.range(0, s.length() - 1)
                                .anyMatch(i -> s.charAt(i) == s.charAt(i + 1));
        Predicate<String> increasingDigits =
                s ->
                        IntStream.range(0, s.length() - 1)
                                .noneMatch(i -> s.codePointAt(i) > s.codePointAt(i + 1));
        Predicate<String> digitPair =
                s ->
                        s.chars()
                                .boxed()
                                .collect(groupingBy(identity(), counting()))
                                .containsValue(2L);

        var validPassword = adjacentDigits.and(increasingDigits);
        var validPasswordNoLargerGroups = digitPair.and(increasingDigits);

        var validPasswords = 0;
        var validPasswordsNoLargerGroups = 0;
        for (var i = start; i <= stop; i++) {
            if (validPassword.test(Integer.toString(i))) {
                validPasswords++;
            }
            if (validPasswordNoLargerGroups.test(Integer.toString(i))) {
                validPasswordsNoLargerGroups++;
            }
        }

        return new PuzzleOutput<>(validPasswords, validPasswordsNoLargerGroups);
    }
}
