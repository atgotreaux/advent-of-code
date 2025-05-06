package com.gotreaux.aoc.puzzles.year2015.day14;

import static java.util.stream.Collectors.toMap;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ReindeerOlympicsPuzzle extends Puzzle {

    public ReindeerOlympicsPuzzle() {
        super(2015, 14);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        Collection<Reindeer> reindeers = inputReader.getInputStream().map(Reindeer::of).toList();

        int maxDistance =
                reindeers.stream()
                        .mapToInt(reindeer -> reindeer.getDistance(2503))
                        .max()
                        .orElseThrow();

        Map<String, Integer> reindeerScores = new HashMap<>(reindeers.size());
        for (int i = 1; i <= 2503; i++) {
            int finalI = i;
            Map<String, Integer> reindeerDistances =
                    reindeers.stream().collect(toMap(Reindeer::name, r -> r.getDistance(finalI)));

            int maxSecondDistance =
                    reindeerDistances.values().stream().max(Integer::compareTo).orElseThrow();

            Collection<String> leadingReindeers =
                    reindeerDistances.entrySet().stream()
                            .filter(e -> e.getValue() == maxSecondDistance)
                            .map(Map.Entry::getKey)
                            .toList();

            for (String leadingReindeer : leadingReindeers) {
                reindeerScores.merge(leadingReindeer, 1, Integer::sum);
            }
        }

        int maxReindeerScore =
                reindeerScores.values().stream().max(Integer::compareTo).orElseThrow();

        return new PuzzleOutput<>(maxDistance, maxReindeerScore);
    }
}
