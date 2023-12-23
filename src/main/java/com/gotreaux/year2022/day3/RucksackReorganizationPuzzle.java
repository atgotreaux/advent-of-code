package com.gotreaux.year2022.day3;

import com.gotreaux.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RucksackReorganizationPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        puzzle.solve();
    }

    private long sumOfCompartmentPriorities;
    private long sumOfGroupPriorities;

    @Override
    public void prepare() throws Exception {
        List<String> group = new ArrayList<>();
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                String firstCompartment = line.substring(0, line.length() / 2);
                String secondCompartment = line.substring(line.length() / 2);

                char sharedCompartmentItem = firstCompartment.chars()
                        .mapToObj(c -> Character.toString(c).charAt(0))
                        .filter(c -> secondCompartment.indexOf(c) != -1)
                        .findFirst()
                        .orElseThrow();

                ItemPriority compartmentPriority = ItemPriority.valueOf(String.valueOf(sharedCompartmentItem));

                sumOfCompartmentPriorities += compartmentPriority.ordinal() + 1;

                group.add(line);
                if (group.size() == 3) {
                    char sharedGroupItem = group.getFirst().chars()
                            .mapToObj(c -> Character.toString(c).charAt(0))
                            .filter(c -> group.get(1).indexOf(c) != -1)
                            .filter(c -> group.get(2).indexOf(c) != -1)
                            .findFirst()
                            .orElseThrow();

                    ItemPriority groupPriority = ItemPriority.valueOf(String.valueOf(sharedGroupItem));

                    sumOfGroupPriorities += groupPriority.ordinal() + 1;

                    group.clear();
                }
            });
        }
    }

    @Override
    public Long getPartOne() throws Exception {
        return sumOfCompartmentPriorities;
    }

    @Override
    public Long getPartTwo() throws Exception {
        return sumOfGroupPriorities;
    }
}
