package com.gotreaux.aoc.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gotreaux.aoc.Application;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(classes = Application.class)
class PuzzlePredicateTest {

    @Autowired private List<Puzzle> puzzles;

    @Test
    void emptyYears() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] years = new Integer[0];

        BiPredicate<Puzzle, Integer[]> predicate = new PuzzlePredicate(Puzzle::getYear);

        assertTrue(predicate.test(puzzle, years));
    }

    @Test
    void matchingYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] years = {puzzle.getYear()};

        BiPredicate<Puzzle, Integer[]> predicate = new PuzzlePredicate(Puzzle::getYear);

        assertTrue(predicate.test(puzzle, years));
    }

    @Test
    void mismatchingYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] years = {RandomGenerator.getDefault().nextInt(puzzle.getYear())};

        BiPredicate<Puzzle, Integer[]> predicate = new PuzzlePredicate(Puzzle::getYear);

        assertFalse(predicate.test(puzzle, years));
    }

    @Test
    void emptyDays() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] days = new Integer[0];

        BiPredicate<Puzzle, Integer[]> predicate = new PuzzlePredicate(Puzzle::getDay);

        assertTrue(predicate.test(puzzle, days));
    }

    @Test
    void matchingDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] days = {puzzle.getDay()};

        BiPredicate<Puzzle, Integer[]> predicate = new PuzzlePredicate(Puzzle::getDay);

        assertTrue(predicate.test(puzzle, days));
    }

    @Test
    void mismatchingDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] days = {RandomGenerator.getDefault().nextInt(puzzle.getDay())};

        BiPredicate<Puzzle, Integer[]> predicate = new PuzzlePredicate(Puzzle::getDay);

        assertFalse(predicate.test(puzzle, days));
    }
}
