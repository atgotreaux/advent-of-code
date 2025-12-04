package com.gotreaux.aoc.puzzles.year2015.day11;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.ForbiddenCharsPredicate;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.IncreasingCharsPredicate;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.IncrementPasswordFunction;
import com.gotreaux.aoc.puzzles.year2015.day11.functions.TwoPairsPredicate;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class CorporatePolicyPuzzle extends Puzzle<String, String> {

    public CorporatePolicyPuzzle() {
        super(2015, 11);
    }

    @Override
    public String solvePartOne(InputReader inputReader) {
        var nextPassword = inputReader.getInputString();

        Function<String, String> incrementPassword = new IncrementPasswordFunction();
        var requirements =
                new IncreasingCharsPredicate()
                        .and(new ForbiddenCharsPredicate())
                        .and(new TwoPairsPredicate());

        while (!requirements.test(nextPassword)) {
            nextPassword = incrementPassword.apply(nextPassword);
        }

        return nextPassword;
    }

    @Override
    public String solvePartTwo(InputReader inputReader) {
        var nextPassword = solvePartOne(inputReader);

        Function<String, String> incrementPassword = new IncrementPasswordFunction();
        var requirements =
                new IncreasingCharsPredicate()
                        .and(new ForbiddenCharsPredicate())
                        .and(new TwoPairsPredicate());

        nextPassword = incrementPassword.apply(nextPassword);
        while (!requirements.test(nextPassword)) {
            nextPassword = incrementPassword.apply(nextPassword);
        }

        return nextPassword;
    }
}
