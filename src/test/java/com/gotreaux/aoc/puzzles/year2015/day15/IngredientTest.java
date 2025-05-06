package com.gotreaux.aoc.puzzles.year2015.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IngredientTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String input, Ingredient expected) {
        assertEquals(expected, Ingredient.of(input));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of(
                        "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8",
                        new Ingredient(-1, -2, 6, 3, 8)),
                Arguments.of(
                        "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3",
                        new Ingredient(2, 3, -2, -1, 3)));
    }
}
