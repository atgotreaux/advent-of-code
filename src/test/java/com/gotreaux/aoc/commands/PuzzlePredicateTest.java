package com.gotreaux.aoc.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PuzzlePredicateTest {

    @Autowired private List<Puzzle> puzzles;

    @Test
    void nullYears() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Predicate<Puzzle> predicate = new PuzzlePredicate<>(Puzzle::getYear);

        assertTrue(predicate.test(puzzle));
    }

    @Test
    void emptyYears() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] years = new Integer[0];

        Predicate<Puzzle> predicate = new PuzzlePredicate<>(Puzzle::getYear, years);

        assertTrue(predicate.test(puzzle));
    }

    @Test
    void matchingYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] years = {puzzle.getYear()};

        Predicate<Puzzle> predicate = new PuzzlePredicate<>(Puzzle::getYear, years);

        assertTrue(predicate.test(puzzle));
    }

    @Test
    void mismatchingYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] years = {RandomGenerator.getDefault().nextInt(puzzle.getYear())};

        Predicate<Puzzle> predicate = new PuzzlePredicate<>(Puzzle::getYear, years);

        assertFalse(predicate.test(puzzle));
    }

    @Test
    void nullDays() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Predicate<Puzzle> predicate = new PuzzlePredicate<>(Puzzle::getDay);

        assertTrue(predicate.test(puzzle));
    }

    @Test
    void emptyDays() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] days = new Integer[0];

        Predicate<Puzzle> predicate = new PuzzlePredicate<>(Puzzle::getDay, days);

        assertTrue(predicate.test(puzzle));
    }

    @Test
    void matchingDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] days = {puzzle.getDay()};

        Predicate<Puzzle> predicate = new PuzzlePredicate<>(Puzzle::getDay, days);

        assertTrue(predicate.test(puzzle));
    }

    @Test
    void mismatchingDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        Integer[] days = {RandomGenerator.getDefault().nextInt(puzzle.getDay())};

        Predicate<Puzzle> predicate = new PuzzlePredicate<>(Puzzle::getDay, days);

        assertFalse(predicate.test(puzzle));
    }
}
