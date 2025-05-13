package com.gotreaux.aoc.utils.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CombinationsOfSumTest {

    @ParameterizedTest
    @MethodSource("provideOfInt")
    void ofInt(
            int sum,
            VariableCombinationLength variableLength,
            UniqueCombinationElements uniqueElements,
            int addends,
            int expectedSize) {
        var combinationsOfSum = new CombinationsOfSum(sum, variableLength, uniqueElements);

        var combinations = combinationsOfSum.of(addends);

        var expectedSumCount =
                combinations.stream()
                        .map(combination -> combination.stream().reduce(0, Integer::sum))
                        .filter(combinationSum -> combinationSum == sum)
                        .count();

        assertEquals(expectedSize, expectedSumCount);
    }

    @ParameterizedTest
    @MethodSource("provideOfList")
    void ofList(
            int sum,
            VariableCombinationLength variableCombinationLength,
            UniqueCombinationElements uniqueElements,
            List<Integer> addends,
            int expectedSize) {
        var combinationsOfSum =
                new CombinationsOfSum(sum, variableCombinationLength, uniqueElements);

        var combinations = combinationsOfSum.of(addends);

        var expectedSumCount =
                combinations.stream()
                        .map(combination -> combination.stream().reduce(0, Integer::sum))
                        .filter(combinationSum -> combinationSum == sum)
                        .count();

        assertEquals(expectedSize, expectedSumCount);
    }

    private static Stream<Arguments> provideOfInt() {
        return Stream.of(
                Arguments.of(
                        100, VariableCombinationLength.NO, UniqueCombinationElements.NO, 2, 101),
                Arguments.of(
                        100,
                        VariableCombinationLength.NO,
                        UniqueCombinationElements.NO,
                        4,
                        176851));
    }

    private static Stream<Arguments> provideOfList() {
        return Stream.of(
                Arguments.of(
                        25,
                        VariableCombinationLength.YES,
                        UniqueCombinationElements.YES,
                        List.of(20, 15, 10, 5, 5),
                        4));
    }
}
