package com.gotreaux.aoc.puzzles.year2015.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class RecipeTest {
    @Test
    void score() {
        var ingredients = List.of(new Ingredient(-1, -2, 6, 3, 8), new Ingredient(2, 3, -2, -1, 3));

        var teaspoons = List.of(44, 56);

        var recipe = new Recipe(ingredients, teaspoons);

        assertEquals(62842880, recipe.getScore());
    }

    @Test
    void propertyScore() {
        var ingredients = List.of(new Ingredient(-1, -2, 6, 3, 8), new Ingredient(2, 3, -2, -1, 3));

        var teaspoons = List.of(40, 60);

        var recipe = new Recipe(ingredients, teaspoons);

        assertEquals(500, recipe.getPropertyScore(Ingredient::calories));
    }
}
