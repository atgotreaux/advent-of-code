package com.gotreaux.aoc.puzzles.year2022.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RucksackReorganizationPuzzle extends Puzzle {

    public RucksackReorganizationPuzzle() {
        super(2022, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var sumOfCompartmentPriorities = 0;
        var sumOfGroupPriorities = 0;

        var priority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        List<String> group = new ArrayList<>(3);
        for (var line : inputReader.getInputList()) {
            var firstCompartment = line.substring(0, line.length() / 2);
            var secondCompartment = line.substring(line.length() / 2);

            char sharedCompartmentItem =
                    firstCompartment
                            .chars()
                            .mapToObj(codePoint -> Character.toString(codePoint).charAt(0))
                            .filter(c -> secondCompartment.indexOf(c) != -1)
                            .findFirst()
                            .orElseThrow();

            sumOfCompartmentPriorities += priority.indexOf(sharedCompartmentItem) + 1;

            group.add(line);
            if (group.size() == 3) {
                char sharedGroupItem =
                        group.getFirst()
                                .chars()
                                .mapToObj(codePoint -> Character.toString(codePoint).charAt(0))
                                .filter(c -> group.get(1).indexOf(c) != -1)
                                .filter(c -> group.get(2).indexOf(c) != -1)
                                .findFirst()
                                .orElseThrow();

                sumOfGroupPriorities += priority.indexOf(sharedGroupItem) + 1;

                group.clear();
            }
        }

        return new PuzzleOutput<>(sumOfCompartmentPriorities, sumOfGroupPriorities);
    }
}
