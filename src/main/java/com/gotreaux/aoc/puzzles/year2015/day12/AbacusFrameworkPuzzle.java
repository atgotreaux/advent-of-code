package com.gotreaux.aoc.puzzles.year2015.day12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class AbacusFrameworkPuzzle extends Puzzle {

    public AbacusFrameworkPuzzle() {
        super(2015, 12);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var input = inputReader.getInputString();

        var mapper = new ObjectMapper();
        var jsonNode = mapper.readTree(input);

        var sumOfNumbersFunction = new SumOfNumbersFunction();
        int sumOfNumbers = sumOfNumbersFunction.apply(jsonNode);

        var noRedSumNumbersFunction = new NoRedSumNumbersFunction();
        int noRedSumNumbers = noRedSumNumbersFunction.apply(jsonNode);

        return new PuzzleOutput<>(sumOfNumbers, noRedSumNumbers);
    }
}
