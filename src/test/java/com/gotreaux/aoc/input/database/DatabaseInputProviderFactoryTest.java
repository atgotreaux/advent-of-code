package com.gotreaux.aoc.input.database;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.gotreaux.aoc.input.DatabaseInputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class DatabaseInputProviderFactoryTest {
    @Autowired private List<Puzzle> puzzles;

    @Autowired private DatabaseInputProviderFactory databaseInputProviderFactory;

    @Test
    void createsDatabaseInputProvider() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey(puzzle.getYear(), puzzle.getDay());

        assertInstanceOf(
                DatabaseInputProvider.class,
                databaseInputProviderFactory.createDatabaseInputProvider(puzzleInputKey));
    }
}
