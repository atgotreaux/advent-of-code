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
import java.util.Map;
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

        for (String line : input) {
            List<String> parts = List.of(INPUT_DELIMS.matcher(line).replaceAll("").split(" "));

            discs.add(new Disc(parts.getFirst(), Integer.parseInt(parts.get(1))));
        }

        for (String line : input) {
            List<String> parts = List.of(INPUT_DELIMS.matcher(line).replaceAll("").split(" "));
            if (parts.size() > 2) {
                Disc parent =
                        discs.stream()
                                .filter(disc -> disc.getProgram().equals(parts.getFirst()))
                                .findFirst()
                                .orElseThrow();

                for (String child : parts.subList(3, parts.size())) {
                    Disc childDisc =
                            discs.stream()
                                    .filter(disc -> disc.getProgram().equals(child))
                                    .findFirst()
                                    .orElseThrow();

                    childDisc.setParent(parent);
                    parent.addChild(childDisc);
                }
            }
        }

        Disc disc =
                discs.stream()
                        .filter(candidate -> candidate.getParent() == null)
                        .findFirst()
                        .orElseThrow();

        String nameOfBottomProgram = disc.getProgram();

        int difference = Integer.MAX_VALUE;
        while (!disc.getChildren().isEmpty()) {
            Map<Integer, Long> childWeights =
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

        int weightOfFixedChild = disc.getWeight() - difference;

        return new PuzzleOutput<>(nameOfBottomProgram, weightOfFixedChild);
    }
}
