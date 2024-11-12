package com.gotreaux.aoc.puzzles.year2015.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CollectionUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class SingleNightPuzzle extends Puzzle {

    public SingleNightPuzzle() {
        super(2015, 9);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException, NoSuchElementException {
        Collection<Route> routes =
                inputReader.getInputStream().map(SingleNightPuzzle::parseRoute).toList();

        List<String> locations =
                routes.stream()
                        .flatMap(route -> Stream.of(route.from(), route.to()))
                        .distinct()
                        .toList();

        List<List<String>> permutations = CollectionUtils.permutations(locations);

        List<Integer> distances =
                permutations.stream()
                        .mapToInt(permutation -> getDistance(routes, permutation))
                        .boxed()
                        .toList();

        int shortestDistance = distances.stream().min(Integer::compareTo).orElseThrow();
        int longestDistance = distances.stream().max(Integer::compareTo).orElseThrow();

        return new PuzzleOutput<>(shortestDistance, longestDistance);
    }

    private static Route parseRoute(String line) {
        String[] routeParts = line.split(" ");

        return new Route(routeParts[0], routeParts[2], Integer.parseInt(routeParts[4]));
    }

    private static int getDistance(Collection<Route> routes, List<String> permutation)
            throws NoSuchElementException {
        return IntStream.range(0, permutation.size() - 1)
                .mapToObj(i -> findRoute(routes, permutation.get(i), permutation.get(i + 1)))
                .mapToInt(Route::distance)
                .sum();
    }

    private static Route findRoute(Collection<Route> routes, String from, String to)
            throws NoSuchElementException {
        return routes.stream().filter(route -> route.matches(from, to)).findFirst().orElseThrow();
    }
}
