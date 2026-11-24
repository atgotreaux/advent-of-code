package com.gotreaux.aoc.puzzles.year2015.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class NiceStringPuzzle extends Puzzle {

    private static final Pattern THREE_VOWELS = Pattern.compile("[^aeiou]");
    private static final Pattern REPEATED_CHARACTER = Pattern.compile("[a-z]*([a-z])\\1[a-z]*");
    private static final Pattern NO_FORBIDDEN_STRINGS = Pattern.compile("ab|cd|pq|xy");
    private static final Pattern PAIR_REPEATED = Pattern.compile("([a-z]{2}).*\\1");
    private static final Pattern REPEATED_WITH_SEPARATOR =
            Pattern.compile("[a-z]*([a-z])[a-z]\\1[a-z]*");

    public NiceStringPuzzle() {
        super(2015, 5);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var niceStringCount =
                inputReader
                        .getInputStream()
                        .filter(s -> THREE_VOWELS.matcher(s).replaceAll("").length() >= 3)
                        .filter(s -> REPEATED_CHARACTER.matcher(s).matches())
                        .filter(s -> !NO_FORBIDDEN_STRINGS.matcher(s).find())
                        .count();

        var niceStringBetterModelCount =
                inputReader
                        .getInputStream()
                        .filter(s -> PAIR_REPEATED.matcher(s).find())
                        .filter(s -> REPEATED_WITH_SEPARATOR.matcher(s).matches())
                        .count();

        return new PuzzleOutput<>(niceStringCount, niceStringBetterModelCount);
    }
}
