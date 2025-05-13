package com.gotreaux.aoc.input.writer;

import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.file.Files;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InputWriterFactory {

    private static final Logger logger = LoggerFactory.getLogger(InputWriterFactory.class);

    public static final String DATABASE_WRITER = "database";
    public static final String RESOURCE_WRITER = "resource";

    private final PuzzleRepository puzzleRepository;

    public InputWriterFactory(PuzzleRepository puzzleRepository) {
        this.puzzleRepository = puzzleRepository;
    }

    public InputWriter create(Puzzle puzzle, String target) throws IllegalStateException {
        return switch (target) {
            case DATABASE_WRITER ->
                    new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());
            case RESOURCE_WRITER -> new ResourceInputWriter<>(puzzle.getClass());
            default -> {
                try {
                    var filePath = Path.of(target);
                    if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
                        yield new FileInputWriter(target);
                    }
                } catch (RuntimeException e) {
                    logger.error(e.getMessage());
                }

                throw new IllegalStateException(
                        "Cannot create input writer for target '%s'".formatted(target));
            }
        };
    }
}
