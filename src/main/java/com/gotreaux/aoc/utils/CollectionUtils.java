package com.gotreaux.aoc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public static List<List<Integer>> combinationsOfSum(int remainingAddends, int remainingSum) {
        List<Integer> combination =
                Stream.generate(() -> 0).limit(remainingAddends).collect(Collectors.toList());
        return combinationsOfSum(combination, remainingAddends, remainingSum);
    }

    private static List<List<Integer>> combinationsOfSum(
            List<Integer> combination, int remainingAddends, int remainingSum) {
        if (remainingAddends == 0) {
            if (remainingSum == 0) {
                return List.of(new ArrayList<>(combination));
            }
            return new ArrayList<>(0);
        }
        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 0; i <= remainingSum; i++) {
            combination.set(remainingAddends - 1, i);
            combinations.addAll(
                    combinationsOfSum(combination, remainingAddends - 1, remainingSum - i));
        }
        return combinations;
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

        for (T element : elements) {
            combination.add(element);
            combination(elements, length, combination, combinations);
            combination.removeLast();
        }
    }
}
