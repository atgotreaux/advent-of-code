package com.gotreaux.year2015.day5;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NiceStringPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        NiceStringPuzzle puzzle = new NiceStringPuzzle();

        puzzle.solve();
    }

    private long numberOfNiceStrings;

    public NiceStringPuzzle() {
        super();
    }

    public NiceStringPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public void prepare() throws Exception {
        List<Predicate<String>> niceStringPredicates = new ArrayList<>();
        niceStringPredicates.add(string -> string.replaceAll("[^aeiou]", "").length() >= 3);
        niceStringPredicates.add(string -> string.matches("[a-z]*([a-z])\\1+[a-z]*"));
        niceStringPredicates.add(string -> !string.matches("[a-z]*(ab|cd|pq|xy)[a-z]*"));

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            numberOfNiceStrings = lines.filter(niceStringPredicates.stream().reduce(criterion->true, Predicate::and))
                    .count();
        }
    }

    @Override
    public Long getPartOne() {
        return numberOfNiceStrings;
    }

    @Override
    public Long getPartTwo() {
        return 0L;
    }
}
