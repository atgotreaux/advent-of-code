package com.gotreaux.aoc.puzzles.year2015.day12;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

@Component
public class AbacusFrameworkPuzzle extends Puzzle {

    public AbacusFrameworkPuzzle() {
        super(2015, 12);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException {
        String input = inputProvider.getInputString();

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
