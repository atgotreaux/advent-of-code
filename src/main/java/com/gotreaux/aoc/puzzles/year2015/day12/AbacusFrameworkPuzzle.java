package com.gotreaux.aoc.puzzles.year2015.day12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.UncheckedIOException;
import org.springframework.stereotype.Component;

@Component
public class AbacusFrameworkPuzzle extends Puzzle {

    public AbacusFrameworkPuzzle() {
        super(2015, 12);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputString();

        var mapper = new ObjectMapper();
        try {
            var jsonNode = mapper.readTree(input);

            var sumOfNumbersFunction = new SumOfNumbersFunction();
            int sumOfNumbers = sumOfNumbersFunction.apply(jsonNode);

            var noRedSumNumbersFunction = new NoRedSumNumbersFunction();
            int noRedSumNumbers = noRedSumNumbersFunction.apply(jsonNode);

            return new PuzzleOutput<>(sumOfNumbers, noRedSumNumbers);
        } catch (JsonMappingException e) {
            throw new UncheckedIOException("Failed to map JSON input: %s".formatted(input), e);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException("Failed to process JSON input: %s".formatted(input), e);
        }
    }
}
