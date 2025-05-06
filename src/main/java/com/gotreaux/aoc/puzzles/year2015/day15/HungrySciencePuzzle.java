package com.gotreaux.aoc.puzzles.year2015.day15;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.collection.CombinationsOfSum;
import com.gotreaux.aoc.utils.collection.UniqueCombinationElements;
import com.gotreaux.aoc.utils.collection.VariableCombinationLength;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HungrySciencePuzzle extends Puzzle {

    public HungrySciencePuzzle() {
        super(2015, 15);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        List<Ingredient> ingredients = inputReader.getInputStream().map(Ingredient::of).toList();

        CombinationsOfSum combinationsOfSum =
                new CombinationsOfSum(
                        100, VariableCombinationLength.NO, UniqueCombinationElements.NO);

        List<List<Integer>> combinations = combinationsOfSum.of(ingredients.size());

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
}
