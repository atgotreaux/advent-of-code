package com.gotreaux.aoc.puzzles.year2015.day15;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CollectionUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;

@ShellPuzzle(year = 2015, day = 15, title = "Science for Hungry People")
public class HungrySciencePuzzle extends Puzzle {
    public HungrySciencePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, NoSuchElementException {
        List<Ingredient> ingredients =
                getInputProvider()
                        .getInputStream()
                        .map(HungrySciencePuzzle::parseIngredient)
                        .toList();

        List<List<Integer>> combinations =
                CollectionUtils.combinationsOfSum(ingredients.size(), 100);

        List<Recipe> recipes =
                combinations.stream().map(teaspoons -> new Recipe(ingredients, teaspoons)).toList();

        int highestScoringCookie =
                recipes.stream().map(Recipe::getScore).max(Integer::compareTo).orElseThrow();

        int highestScoringCalorieCookie =
                recipes.stream()
                        .filter(recipe -> recipe.getPropertyScore(Ingredient::calories) == 500)
                        .map(Recipe::getScore)
                        .max(Integer::compareTo)
                        .orElseThrow();

        return new PuzzleOutput<>(highestScoringCookie, highestScoringCalorieCookie);
    }

    private static Ingredient parseIngredient(String input) {
        String[] parts = input.replace(":", "").replace(",", "").split(" ");

        return new Ingredient(
                Integer.parseInt(parts[2]),
                Integer.parseInt(parts[4]),
                Integer.parseInt(parts[6]),
                Integer.parseInt(parts[8]),
                Integer.parseInt(parts[10]));
    }
}
