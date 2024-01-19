package com.gotreaux.aoc.puzzles.year2022.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;

@ShellPuzzle(year = 2022, day = 3, title = "Rucksack Reorganization")
public class RucksackReorganizationPuzzle extends Puzzle {

    public RucksackReorganizationPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int sumOfCompartmentPriorities = 0;
        int sumOfGroupPriorities = 0;

        List<String> group = new ArrayList<>();
        for (String line : getInputProvider().getInputList()) {
            String firstCompartment = line.substring(0, line.length() / 2);
            String secondCompartment = line.substring(line.length() / 2);

            char sharedCompartmentItem =
                    firstCompartment
                            .chars()
                            .mapToObj(c -> Character.toString(c).charAt(0))
                            .filter(c -> secondCompartment.indexOf(c) != -1)
                            .findFirst()
                            .orElseThrow();

            ItemPriority compartmentPriority =
                    ItemPriority.valueOf(String.valueOf(sharedCompartmentItem));
            sumOfCompartmentPriorities += compartmentPriority.ordinal() + 1;

            group.add(line);
            if (group.size() == 3) {
                char sharedGroupItem =
                        group.getFirst()
                                .chars()
                                .mapToObj(c -> Character.toString(c).charAt(0))
                                .filter(c -> group.get(1).indexOf(c) != -1)
                                .filter(c -> group.get(2).indexOf(c) != -1)
                                .findFirst()
                                .orElseThrow();

                ItemPriority groupPriority = ItemPriority.valueOf(String.valueOf(sharedGroupItem));
                sumOfGroupPriorities += groupPriority.ordinal() + 1;

                group.clear();
            }
        }

        return new PuzzleOutput<>(sumOfCompartmentPriorities, sumOfGroupPriorities);
    }
}
