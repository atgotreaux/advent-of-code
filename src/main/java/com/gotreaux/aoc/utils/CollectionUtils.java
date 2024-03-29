package com.gotreaux.aoc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class CollectionUtils {

    private CollectionUtils() {}

    public static <T> List<List<T>> permutations(List<T> collection) {
        if (collection.isEmpty()) {
            List<List<T>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        T first = collection.getFirst();
        List<List<T>> returnList = new ArrayList<>();
        List<List<T>> permutations = permutations(collection.subList(1, collection.size()));
        for (List<T> smallerPermutated : permutations) {
            for (int i = 0; i <= smallerPermutated.size(); i++) {
                List<T> temp = new ArrayList<>(smallerPermutated);
                temp.add(i, first);
                returnList.add(temp);
            }
        }
        return returnList;
    }

    public static <T> List<List<T>> circularPermutations(List<T> collection) {
        T first = collection.getFirst();

        List<List<T>> permutations = permutations(collection.subList(1, collection.size()));

        return permutations.stream()
                .map(permutation -> Stream.concat(Stream.of(first), permutation.stream()).toList())
                .toList();
    }
}
