package com.gotreaux.aoc.puzzles.year2018.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class SumOfPartsPuzzle extends Puzzle {

    public SumOfPartsPuzzle() {
        super(2018, 7);
    }

    @Override
    public PuzzleOutput<String, Integer> solve(InputReader inputReader) throws Exception {
        List<Requirement> reqs =
                inputReader.getInputStream().map(SumOfPartsPuzzle::parseRequirement).toList();

        List<String> steps =
                reqs.stream()
                        .flatMap(req -> Stream.of(req.prereq(), req.step()))
                        .distinct()
                        .toList();

        StringBuilder stepOrder = new StringBuilder(steps.size());
        List<String> availableSteps = new ArrayList<>(steps.size());
        while (stepOrder.length() < steps.size()) {
            List<String> prereqsCompleteSteps =
                    steps.stream()
                            .filter(step -> stepOrder.indexOf(step) == -1)
                            .filter(step -> !availableSteps.contains(step))
                            .filter(
                                    step ->
                                            reqs.stream()
                                                    .filter(req -> req.step().equals(step))
                                                    .allMatch(
                                                            req ->
                                                                    stepOrder.indexOf(req.prereq())
                                                                            >= 0))
                            .toList();

            availableSteps.addAll(prereqsCompleteSteps);
            Collections.sort(availableSteps);

            stepOrder.append(availableSteps.removeFirst());
        }

        return new PuzzleOutput<>(stepOrder.toString(), 0);
    }

    private static Requirement parseRequirement(String input) {
        String[] parts = input.split(" ");
        return new Requirement(parts[1], parts[7]);
    }
}
