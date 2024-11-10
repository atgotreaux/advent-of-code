package com.gotreaux.aoc.puzzles.year2015.day12;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
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

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(input);

        SumOfNumbersFunction sumOfNumbersFunction = new SumOfNumbersFunction();
        int sumOfNumbers = sumOfNumbersFunction.apply(jsonNode);

        NoRedSumNumbersFunction noRedSumNumbersFunction = new NoRedSumNumbersFunction();
        int noRedSumNumbers = noRedSumNumbersFunction.apply(jsonNode);

        return new PuzzleOutput<>(sumOfNumbers, noRedSumNumbers);
    }
}
