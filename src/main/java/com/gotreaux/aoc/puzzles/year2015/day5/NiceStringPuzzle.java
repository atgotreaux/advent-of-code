package com.gotreaux.aoc.puzzles.year2015.day5;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

@ShellPuzzle(year = 2015, day = 5, title = "Doesn't He Have Intern-Elves For This?")
public class NiceStringPuzzle extends Puzzle {

    private static final Pattern THREE_VOWELS = Pattern.compile("[^aeiou]");
    private static final Pattern REPEATED_CHARACTER = Pattern.compile("[a-z]*([a-z])\\1[a-z]*");
    private static final Pattern NO_FORBIDDEN_STRINGS =
            Pattern.compile("[a-z]*(ab|cd|pq|xy)[a-z]*");
    private static final Pattern PAIR_REPEATED =
            Pattern.compile("[a-z]*([a-z][a-z])[a-z]*\\1[a-z]*");
    private static final Pattern REPEATED_WITH_SEPARATOR =
            Pattern.compile("[a-z]*([a-z])[a-z]\\1[a-z]*");

    public NiceStringPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws IOException, URISyntaxException {
        long niceStringCount =
                getInputProvider()
                        .getInputStream()
                        .filter(s -> THREE_VOWELS.matcher(s).replaceAll("").length() >= 3)
                        .filter(s -> REPEATED_CHARACTER.matcher(s).matches())
                        .filter(s -> !NO_FORBIDDEN_STRINGS.matcher(s).matches())
                        .count();

        long niceStringBetterModelCount =
                getInputProvider()
                        .getInputStream()
                        .filter(s -> PAIR_REPEATED.matcher(s).matches())
                        .filter(s -> REPEATED_WITH_SEPARATOR.matcher(s).matches())
                        .count();

        return new PuzzleOutput<>(niceStringCount, niceStringBetterModelCount);
    }
}
