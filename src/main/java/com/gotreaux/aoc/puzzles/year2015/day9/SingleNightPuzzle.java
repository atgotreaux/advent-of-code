package com.gotreaux.aoc.puzzles.year2015.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.collection.CollectionUtils;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class SingleNightPuzzle extends Puzzle {

    public SingleNightPuzzle() {
        super(2015, 9);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        Collection<Route> routes = inputReader.getInputStream().map(Route::of).toList();

        var locations =
                routes.stream()
                        .flatMap(route -> Stream.of(route.from(), route.to()))
                        .distinct()
                        .toList();

        var permutations = CollectionUtils.permutations(locations);

        var distances =
                permutations.stream()
                        .mapToInt(permutation -> getDistance(routes, permutation))
                        .boxed()
                        .toList();

        int shortestDistance = distances.stream().min(Integer::compareTo).orElseThrow();
        int longestDistance = distances.stream().max(Integer::compareTo).orElseThrow();

        return new PuzzleOutput<>(shortestDistance, longestDistance);
    }

    private static int getDistance(Collection<Route> routes, List<String> permutation) {
        return IntStream.range(0, permutation.size() - 1)
                .mapToObj(i -> findRoute(routes, permutation.get(i), permutation.get(i + 1)))
                .mapToInt(Route::distance)
                .sum();
    }

    private static Route findRoute(Collection<Route> routes, String from, String to) {
        return routes.stream().filter(route -> route.matches(from, to)).findFirst().orElseThrow();
    }
}
