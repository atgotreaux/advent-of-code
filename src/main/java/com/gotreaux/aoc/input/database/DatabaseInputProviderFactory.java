package com.gotreaux.aoc.input.database;

import com.gotreaux.aoc.input.DatabaseInputProvider;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInputProviderFactory {

    private final PuzzleInputRepository puzzleInputRepository;

    public DatabaseInputProviderFactory(PuzzleInputRepository puzzleInputRepository) {
        this.puzzleInputRepository = puzzleInputRepository;
    }

    public DatabaseInputProvider createDatabaseInputProvider(PuzzleInputKey inputKey) {
        return new DatabaseInputProvider(puzzleInputRepository, inputKey);
    }
}
