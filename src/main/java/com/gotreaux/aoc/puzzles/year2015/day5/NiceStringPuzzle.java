package com.gotreaux.aoc.puzzles.year2015.day5;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.function.Predicate;
import java.util.stream.Stream;

@ShellPuzzle(year = 2015, day = 5, title = "Doesn't He Have Intern-Elves For This?")
public class NiceStringPuzzle extends Puzzle {

    public NiceStringPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

    public Long getPartOne() throws Exception {
        Predicate<String> threeVowels = s -> s.replaceAll("[^aeiou]", "").length() >= 3;
        Predicate<String> repeatedCharacter = s -> s.matches("[a-z]*([a-z])\\1[a-z]*");
        Predicate<String> noForbiddenStrings = s -> !s.matches("[a-z]*(ab|cd|pq|xy)[a-z]*");
        Predicate<String> niceStringCriteria =
                threeVowels.and(repeatedCharacter).and(noForbiddenStrings);

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.filter(niceStringCriteria).count();
        }
    }

    public Long getPartTwo() throws Exception {
        Predicate<String> pairRepeated = s -> s.matches("[a-z]*([a-z][a-z])[a-z]*\\1[a-z]*");
        Predicate<String> repeatedWithBetweenCharacter =
                s -> s.matches("[a-z]*([a-z])[a-z]\\1[a-z]*");
        Predicate<String> niceStringBetterModelCriteria =
                pairRepeated.and(repeatedWithBetweenCharacter);

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.filter(niceStringBetterModelCriteria).count();
        }
    }
}
