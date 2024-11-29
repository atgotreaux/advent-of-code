package com.gotreaux.aoc.puzzles.year2015.day12;

import com.fasterxml.jackson.databind.JsonNode;
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
        String input = inputReader.getInputString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(input);

        SumOfNumbersFunction sumOfNumbersFunction = new SumOfNumbersFunction();
        int sumOfNumbers = sumOfNumbersFunction.apply(jsonNode);

        NoRedSumNumbersFunction noRedSumNumbersFunction = new NoRedSumNumbersFunction();
        int noRedSumNumbers = noRedSumNumbersFunction.apply(jsonNode);

        return new PuzzleOutput<>(sumOfNumbers, noRedSumNumbers);
    }
}
