package com.gotreaux.aoc.utils.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class CollectionUtils {

    private CollectionUtils() {}

    public static <T> List<List<T>> permutations(List<T> collection) {
        if (collection.isEmpty()) {
            List<List<T>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        var first = collection.getFirst();
        List<List<T>> returnList = new ArrayList<>();
        var permutations = permutations(collection.subList(1, collection.size()));
        for (var smallerPermutated : permutations) {
            for (var i = 0; i <= smallerPermutated.size(); i++) {
                List<T> temp = new ArrayList<>(smallerPermutated);
                temp.add(i, first);
                returnList.add(temp);
            }
        }
        return returnList;
    }

    public static <T> List<List<T>> circularPermutations(List<T> collection) {
        var first = collection.getFirst();

        var permutations = permutations(collection.subList(1, collection.size()));

        return permutations.stream()
                .map(permutation -> Stream.concat(Stream.of(first), permutation.stream()).toList())
                .toList();
    }

    public static <T> List<List<T>> combinations(List<T> elements, int length) {
        List<List<T>> combinations = new ArrayList<>();
        combination(elements, length, new ArrayList<>(), combinations);
        return combinations;
    }

    private static <T> void combination(
            List<T> elements, int length, List<T> combination, List<List<T>> combinations) {
        if (combination.size() == length) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (var element : elements) {
            combination.add(element);
            combination(elements, length, combination, combinations);
            combination.removeLast();
        }
    }

    public static <T> Collection<Optional<T>> optionalValues(T[] values) {
        Collection<Optional<T>> optionalValues = new ArrayList<>(values.length + 1);
        optionalValues.add(Optional.empty());
        for (var value : values) {
            optionalValues.add(Optional.of(value));
        }
        return optionalValues;
    }
}
