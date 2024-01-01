package com.gotreaux.year2022.day3;

import com.gotreaux.Puzzle;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RucksackReorganizationPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        puzzle.solve();
    }

    @Override
    public Integer getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToInt(line -> {
                String firstCompartment = line.substring(0, line.length() / 2);
                String secondCompartment = line.substring(line.length() / 2);

                char sharedCompartmentItem = firstCompartment.chars()
                        .mapToObj(c -> Character.toString(c).charAt(0))
                        .filter(c -> secondCompartment.indexOf(c) != -1)
                        .findFirst()
                        .orElseThrow();

                ItemPriority compartmentPriority = ItemPriority.valueOf(String.valueOf(sharedCompartmentItem));

                return compartmentPriority.ordinal() + 1;
            }).sum();
        }
    }

    @Override
    public Integer getPartTwo() throws Exception {
        List<String> input = getInputProvider().getInputList();

        return IntStream.range(0, input.size() - 3 + 1)
                .filter(index -> index % 3 == 0)
                .mapToObj(windowStart -> input.subList(windowStart, windowStart + 3))
                .flatMapToInt(group -> {
                    char sharedGroupItem = group.getFirst().chars()
                            .mapToObj(c -> Character.toString(c).charAt(0))
                            .filter(c -> group.get(1).indexOf(c) != -1)
                            .filter(c -> group.get(2).indexOf(c) != -1)
                            .findFirst()
                            .orElseThrow();

                    ItemPriority groupPriority = ItemPriority.valueOf(String.valueOf(sharedGroupItem));

                    return IntStream.of(groupPriority.ordinal() + 1);
                }).sum();
    }
}
