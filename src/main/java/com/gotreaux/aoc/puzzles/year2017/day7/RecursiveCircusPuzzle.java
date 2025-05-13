package com.gotreaux.aoc.puzzles.year2017.day7;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class RecursiveCircusPuzzle extends Puzzle {
    private static final Pattern INPUT_DELIMS = Pattern.compile("[(),]");

    public RecursiveCircusPuzzle() {
        super(2017, 7);
    }

    @Override
    public PuzzleOutput<String, Integer> solve(InputReader inputReader) throws Exception {
        Collection<String> input = inputReader.getInputList();
        Collection<Disc> discs = new ArrayList<>(input.size());

        for (var line : input) {
            var parts = List.of(INPUT_DELIMS.matcher(line).replaceAll("").split(" "));

            discs.add(new Disc(parts.getFirst(), Integer.parseInt(parts.get(1))));
        }

        for (var line : input) {
            var parts = List.of(INPUT_DELIMS.matcher(line).replaceAll("").split(" "));
            if (parts.size() > 2) {
                var parent =
                        discs.stream()
                                .filter(disc -> disc.getProgram().equals(parts.getFirst()))
                                .findFirst()
                                .orElseThrow();

                for (var child : parts.subList(3, parts.size())) {
                    var childDisc =
                            discs.stream()
                                    .filter(disc -> disc.getProgram().equals(child))
                                    .findFirst()
                                    .orElseThrow();

                    childDisc.setParent(parent);
                    parent.addChild(childDisc);
                }
            }
        }

        var disc =
                discs.stream()
                        .filter(candidate -> candidate.getParent() == null)
                        .findFirst()
                        .orElseThrow();

        var nameOfBottomProgram = disc.getProgram();

        var difference = Integer.MAX_VALUE;
        while (!disc.getChildren().isEmpty()) {
            var childWeights =
                    disc.getChildren().stream()
                            .map(Disc::getTotalWeight)
                            .collect(groupingBy(identity(), counting()));

            if (childWeights.size() == 1) {
                break;
            }

            difference = Math.abs(childWeights.keySet().stream().reduce(0, (x, y) -> y - x));

            disc =
                    disc.getChildren().stream()
                            .filter(childDisc -> childWeights.get(childDisc.getTotalWeight()) == 1L)
                            .findFirst()
                            .orElseThrow();
        }

        var weightOfFixedChild = disc.getWeight() - difference;

        return new PuzzleOutput<>(nameOfBottomProgram, weightOfFixedChild);
    }
}
