package com.gotreaux.aoc.puzzles.year2015.day13;

import com.gotreaux.aoc.utils.collection.CollectionUtils;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

record Table(Collection<Arrangement> arrangements) {
    List<String> getRelatives() {
        return arrangements.stream().map(Arrangement::relative).distinct().toList();
    }

    int getOptimalArrangement() {
        var permutations = CollectionUtils.circularPermutations(getRelatives());

        var arrangementHappiness =
                permutations.stream().mapToInt(this::getHappiness).boxed().toList();

        return arrangementHappiness.stream().max(Integer::compareTo).orElseThrow();
    }

    private int getHappiness(List<String> permutation) {
        var clockwiseHappiness =
                IntStream.range(0, permutation.size())
                        .mapToObj(
                                i ->
                                        findArrangement(
                                                permutation.get(i),
                                                permutation.get(
                                                        i + 1 == permutation.size() ? 0 : i + 1)))
                        .mapToInt(Arrangement::happiness)
                        .sum();

        var counterClockwiseHappiness =
                IntStream.range(0, permutation.size())
                        .mapToObj(
                                i ->
                                        findArrangement(
                                                permutation.get(i),
                                                permutation.get(
                                                        i == 0 ? permutation.size() - 1 : i - 1)))
                        .mapToInt(Arrangement::happiness)
                        .sum();

        return clockwiseHappiness + counterClockwiseHappiness;
    }

    private Arrangement findArrangement(String relative, String neighbor) {
        return arrangements.stream()
                .filter(arrangement -> arrangement.relative().equals(relative))
                .filter(arrangement -> arrangement.neighbor().equals(neighbor))
                .findFirst()
                .orElseThrow();
    }
}
