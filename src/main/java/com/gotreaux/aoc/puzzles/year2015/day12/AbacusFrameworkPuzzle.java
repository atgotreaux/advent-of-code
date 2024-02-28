package com.gotreaux.aoc.puzzles.year2015.day12;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import org.json.JSONTokener;

@ShellPuzzle(year = 2015, day = 12, title = "JSAbacusFramework.io")
public class AbacusFrameworkPuzzle extends Puzzle {
    public AbacusFrameworkPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        String input = getInputProvider().getInputString();

        JSONTokener tokener = new JSONTokener(input);
        Object json = tokener.nextValue();
        tokener.close();

        SumOfNumbersFunction sumOfNumbersFunction = new SumOfNumbersFunction();
        int sumOfNumbers = sumOfNumbersFunction.apply(json);

        NoRedSumNumbersFunction noRedSumNumbersFunction = new NoRedSumNumbersFunction();
        int noRedSumNumbers = noRedSumNumbersFunction.apply(json);

        return new PuzzleOutput<>(sumOfNumbers, noRedSumNumbers);
    }
}
