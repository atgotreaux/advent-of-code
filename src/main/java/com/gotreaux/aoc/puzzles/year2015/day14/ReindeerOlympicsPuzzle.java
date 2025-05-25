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
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        Collection<Reindeer> reindeers = inputReader.getInputStream().map(Reindeer::of).toList();

        var maxDistance =
                reindeers.stream()
                        .mapToInt(reindeer -> reindeer.getDistance(2503))
                        .max()
                        .orElseThrow();

        Map<String, Integer> reindeerScores = new HashMap<>(reindeers.size());
        for (var i = 1; i <= 2503; i++) {
            var finalI = i;
            var reindeerDistances =
                    reindeers.stream().collect(toMap(Reindeer::name, r -> r.getDistance(finalI)));

            int maxSecondDistance =
                    reindeerDistances.values().stream().max(Integer::compareTo).orElseThrow();

            Collection<String> leadingReindeers =
                    reindeerDistances.entrySet().stream()
                            .filter(e -> e.getValue() == maxSecondDistance)
                            .map(Map.Entry::getKey)
                            .toList();

            for (var leadingReindeer : leadingReindeers) {
                reindeerScores.merge(leadingReindeer, 1, Integer::sum);
            }
        }

        int maxReindeerScore =
                reindeerScores.values().stream().max(Integer::compareTo).orElseThrow();

        return new PuzzleOutput<>(maxDistance, maxReindeerScore);
    }
}
