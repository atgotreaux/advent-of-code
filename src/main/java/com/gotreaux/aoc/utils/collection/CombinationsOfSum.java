package com.gotreaux.aoc.utils.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CombinationsOfSum {

    private final int sum;
    private final VariableCombinationLength variableLength;
    private final UniqueCombinationElements uniqueElements;

    public CombinationsOfSum(
            int sum,
            VariableCombinationLength variableLength,
            UniqueCombinationElements uniqueElements) {
        this.sum = sum;
        this.variableLength = variableLength;
        this.uniqueElements = uniqueElements;
    }

    private boolean allowVariableLength() {
        return variableLength == VariableCombinationLength.YES;
    }

    private boolean enforceUniqueElements() {
        return uniqueElements == UniqueCombinationElements.YES;
    }

    public List<List<Integer>> of(int remainingAddends) {
        List<Integer> addends = IntStream.rangeClosed(0, sum).boxed().toList();
        List<List<Integer>> combinations = new ArrayList<>();

        find(addends, new ArrayList<>(), combinations, remainingAddends, sum);

        return combinations;
    }

    public List<List<Integer>> of(List<Integer> addends) {
        int smallestAddend = addends.stream().min(Integer::compareTo).orElseThrow();
        int combinationSize = sum / smallestAddend;
        List<List<Integer>> combinations = new ArrayList<>();

        find(addends, new ArrayList<>(), combinations, combinationSize, sum);

        return combinations;
    }

    private void find(
            List<Integer> addends,
            List<Integer> combination,
            List<List<Integer>> combinations,
            int remainingAddends,
            int remainingSum) {
        if (remainingSum == 0 && (remainingAddends == 0 || allowVariableLength())) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (remainingAddends == 0) {
            return;
        }

        for (int i = 0; i < addends.size(); i++) {
            int addend = addends.get(i);
            if (addend <= remainingSum) {
                combination.add(addend);
                find(
                        adjustAddends(addends, i),
                        combination,
                        combinations,
                        remainingAddends - 1,
                        remainingSum - addend);
                combination.removeLast();
            }
        }
    }

    private List<Integer> adjustAddends(List<Integer> addends, int index) {
        return enforceUniqueElements() ? addends.subList(index + 1, addends.size()) : addends;
    }
}
