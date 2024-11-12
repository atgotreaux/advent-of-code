package com.gotreaux.aoc.puzzles.year2015.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class NiceStringPuzzle extends Puzzle {

    private static final Pattern THREE_VOWELS = Pattern.compile("[^aeiou]");
    private static final Pattern REPEATED_CHARACTER = Pattern.compile("[a-z]*([a-z])\\1[a-z]*");
    private static final Pattern NO_FORBIDDEN_STRINGS =
            Pattern.compile("[a-z]*(ab|cd|pq|xy)[a-z]*");
    private static final Pattern PAIR_REPEATED =
            Pattern.compile("[a-z]*([a-z][a-z])[a-z]*\\1[a-z]*");
    private static final Pattern REPEATED_WITH_SEPARATOR =
            Pattern.compile("[a-z]*([a-z])[a-z]\\1[a-z]*");

    public NiceStringPuzzle() {
        super(2015, 5);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader)
            throws IOException, URISyntaxException {
        long niceStringCount =
                inputReader
                        .getInputStream()
                        .filter(s -> THREE_VOWELS.matcher(s).replaceAll("").length() >= 3)
                        .filter(s -> REPEATED_CHARACTER.matcher(s).matches())
                        .filter(s -> !NO_FORBIDDEN_STRINGS.matcher(s).matches())
                        .count();

        long niceStringBetterModelCount =
                inputReader
                        .getInputStream()
                        .filter(s -> PAIR_REPEATED.matcher(s).matches())
                        .filter(s -> REPEATED_WITH_SEPARATOR.matcher(s).matches())
                        .count();

        return new PuzzleOutput<>(niceStringCount, niceStringBetterModelCount);
    }
}
