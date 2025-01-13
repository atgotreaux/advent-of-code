package com.gotreaux.aoc.input.reader;

import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.file.Files;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InputReaderFactory {

    private static final Logger logger = LoggerFactory.getLogger(InputReaderFactory.class);

    public static final String DATABASE_READER = "database";
    public static final String RESOURCE_READER = "resource";

    private final PuzzleRepository puzzleRepository;

    public InputReaderFactory(PuzzleRepository puzzleRepository) {
        this.puzzleRepository = puzzleRepository;
    }

    public InputReader create(Puzzle puzzle, String input) {
        return switch (input) {
            case DATABASE_READER ->
                    new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());
            case RESOURCE_READER -> new ResourceInputReader<>(puzzle.getClass());
            default -> {
                try {
                    Path filePath = Path.of(input);
                    if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
                        yield new FileInputReader(filePath.toString());
                    }
                } catch (RuntimeException e) {
                    logger.error(e.getMessage());
                }

                yield new StringInputReader(input);
            }
        };
    }
}
