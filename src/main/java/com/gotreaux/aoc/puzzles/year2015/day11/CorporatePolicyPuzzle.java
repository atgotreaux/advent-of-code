package com.gotreaux.aoc.puzzles.year2015.day11;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.ForbiddenCharsPredicate;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.IncreasingCharsPredicate;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.IncrementPasswordFunction;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.TwoPairsPredicate;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.function.Function;
import java.util.function.Predicate;

@ShellPuzzle(year = 2015, day = 11, title = "Corporate Policy")
public class CorporatePolicyPuzzle extends Puzzle {
    public CorporatePolicyPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<String, String> solve() throws IOException, URISyntaxException {
        String nextPassword = getInputProvider().getInputString();

        Function<String, String> incrementPassword = new IncrementPasswordFunction();
        Predicate<String> requirements =
                new IncreasingCharsPredicate()
                        .and(new ForbiddenCharsPredicate())
                        .and(new TwoPairsPredicate());

        while (!requirements.test(nextPassword)) {
            nextPassword = incrementPassword.apply(nextPassword);
        }
        String expiredAgainPassword = incrementPassword.apply(nextPassword);
        while (!requirements.test(expiredAgainPassword)) {
            expiredAgainPassword = incrementPassword.apply(expiredAgainPassword);
        }

        return new PuzzleOutput<>(nextPassword, expiredAgainPassword);
    }
}
