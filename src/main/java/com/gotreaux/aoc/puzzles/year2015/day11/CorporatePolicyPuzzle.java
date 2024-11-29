package com.gotreaux.aoc.puzzles.year2015.day11;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.ForbiddenCharsPredicate;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.IncreasingCharsPredicate;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.IncrementPasswordFunction;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.TwoPairsPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class CorporatePolicyPuzzle extends Puzzle {

    public CorporatePolicyPuzzle() {
        super(2015, 11);
    }

    @Override
    public PuzzleOutput<String, String> solve(InputReader inputReader) throws Exception {
        String nextPassword = inputReader.getInputString();

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
