package com.gotreaux.aoc.puzzles.year2015.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CollectionUtils;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class SingleNightPuzzle extends Puzzle<Integer, Integer> {

    public SingleNightPuzzle() {
        super(2015, 9);
    }

    @Override
    public Integer solvePartOne(InputReader inputReader) {
        Collection<Route> routes = inputReader.getInputStream().map(Route::of).toList();

        var distances = getDistances(routes);

        return distances.stream().min(Integer::compareTo).orElseThrow();
    }

    @Override
    public Integer solvePartTwo(InputReader inputReader) {
        Collection<Route> routes = inputReader.getInputStream().map(Route::of).toList();

        var distances = getDistances(routes);

        return distances.stream().max(Integer::compareTo).orElseThrow();
    }

    private static List<Integer> getDistances(Collection<Route> routes) {
        var locations =
                routes.stream()
                        .flatMap(route -> Stream.of(route.from(), route.to()))
                        .distinct()
                        .toList();

        var permutations = CollectionUtils.permutations(locations);

        return permutations.stream()
                .mapToInt(permutation -> getDistance(routes, permutation))
                .boxed()
                .toList();
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
