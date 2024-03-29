package com.gotreaux.aoc.puzzles.year2022.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@ShellPuzzle(year = 2022, day = 3, title = "Rucksack Reorganization")
public class RucksackReorganizationPuzzle extends Puzzle {

    public RucksackReorganizationPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, IllegalArgumentException {
        int sumOfCompartmentPriorities = 0;
        int sumOfGroupPriorities = 0;

        String priority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        List<String> group = new ArrayList<>(3);
        for (String line : getInputProvider().getInputList()) {
            String firstCompartment = line.substring(0, line.length() / 2);
            String secondCompartment = line.substring(line.length() / 2);

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
