package com.gotreaux.aoc.puzzles.year2020.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class HandyHaversacksPuzzle extends Puzzle {

    public HandyHaversacksPuzzle() {
        super(2020, 7);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var luggage = new Luggage(input.size());
        input.forEach(luggage::addBag);

        var containsShinyGoldBagCount =
                luggage.getBags().stream().filter(bag -> bag.contains("shiny gold")).count();

        var shinyGoldBag =
                luggage.getBags().stream()
                        .filter(bag -> bag.color().equals("shiny gold"))
                        .findFirst()
                        .orElseThrow();

        var shinyGoldBagCount = shinyGoldBag.getBagCount();

        return new PuzzleOutput<>(containsShinyGoldBagCount, shinyGoldBagCount);
    }
}
