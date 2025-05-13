package com.gotreaux.aoc.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gotreaux.aoc.persistence.entity.PuzzleEntity;
import com.gotreaux.aoc.persistence.entity.PuzzleEntityId;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.random.RandomGenerator;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class PuzzleEntityRepositoryTest {
    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void emptyIfNotFound() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        var puzzleEntityId = new PuzzleEntityId(puzzle.getYear(), puzzle.getDay());

        assertTrue(puzzleRepository.findById(puzzleEntityId).isEmpty());
    }

    @Test
    @DirtiesContext
    void testPresentIfFound() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        var puzzleEntityId = new PuzzleEntityId(puzzle.getYear(), puzzle.getDay());

        var puzzleEntity = new PuzzleEntity();
        puzzleEntity.setId(puzzleEntityId);

        puzzleEntity.setInput(RandomString.make(10));

        puzzleRepository.save(puzzleEntity);

        assertTrue(puzzleRepository.findById(puzzleEntityId).isPresent());
    }
}
