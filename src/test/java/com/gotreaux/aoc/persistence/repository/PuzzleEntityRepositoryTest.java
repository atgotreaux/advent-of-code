package com.gotreaux.aoc.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gotreaux.aoc.persistence.entity.PuzzleEntity;
import com.gotreaux.aoc.persistence.entity.PuzzleEntityId;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class PuzzleEntityRepositoryTest {
    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void emptyIfNotFound() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleEntityId puzzleEntityId = new PuzzleEntityId(puzzle.getYear(), puzzle.getDay());

        assertTrue(puzzleRepository.findById(puzzleEntityId).isEmpty());
    }

    @Test
    void testPresentIfFound() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleEntityId puzzleEntityId = new PuzzleEntityId(puzzle.getYear(), puzzle.getDay());

        PuzzleEntity puzzleEntity = new PuzzleEntity();
        puzzleEntity.setId(puzzleEntityId);

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);
        puzzleEntity.setInput(input);

        puzzleRepository.save(puzzleEntity);

        assertTrue(puzzleRepository.findById(puzzleEntityId).isPresent());
    }
}
