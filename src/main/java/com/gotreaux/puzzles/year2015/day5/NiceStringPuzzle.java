package com.gotreaux.puzzles.year2015.day5;

import com.gotreaux.annotations.ShellPuzzle;
import com.gotreaux.input.InputProvider;
import com.gotreaux.puzzles.Puzzle;
import java.util.function.Predicate;
import java.util.stream.Stream;

@ShellPuzzle(year = 2015, day = 5, title = "Doesn't He Have Intern-Elves For This?")
public class NiceStringPuzzle extends Puzzle {

    public NiceStringPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        Predicate<String> threeVowels = string -> string.replaceAll("[^aeiou]", "").length() >= 3;
        Predicate<String> repeatedCharacter = string -> string.matches("[a-z]*([a-z])\\1[a-z]*");
        Predicate<String> noForbiddenStrings =
                string -> !string.matches("[a-z]*(ab|cd|pq|xy)[a-z]*");
        Predicate<String> niceStringCriteria =
                threeVowels.and(repeatedCharacter).and(noForbiddenStrings);

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.filter(niceStringCriteria).count();
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        Predicate<String> pairRepeated =
                string -> string.matches("[a-z]*([a-z][a-z])[a-z]*\\1[a-z]*");
        Predicate<String> repeatedWithBetweenCharacter =
                string -> string.matches("[a-z]*([a-z])[a-z]\\1[a-z]*");
        Predicate<String> niceStringBetterModelCriteria =
                pairRepeated.and(repeatedWithBetweenCharacter);

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.filter(niceStringBetterModelCriteria).count();
        }
    }
}
