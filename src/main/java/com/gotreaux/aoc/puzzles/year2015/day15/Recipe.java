package com.gotreaux.aoc.puzzles.year2015.day15;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

record Recipe(List<Ingredient> ingredients, List<Integer> teaspoons) {
    int getScore() {
        return getPropertyScore(Ingredient::capacity)
                * getPropertyScore(Ingredient::durability)
                * getPropertyScore(Ingredient::flavor)
                * getPropertyScore(Ingredient::texture);
    }

    int getPropertyScore(Function<Ingredient, Integer> ingredientScore) {
        var propertyScore =
                IntStream.range(0, ingredients.size())
                        .map(i -> ingredientScore.apply(ingredients.get(i)) * teaspoons.get(i))
                        .sum();

        return Math.max(propertyScore, 0);
    }
}
