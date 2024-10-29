package com.gotreaux.aoc.input;

import com.gotreaux.aoc.input.database.PuzzleInput;
import com.gotreaux.aoc.input.database.PuzzleInputKey;
import com.gotreaux.aoc.input.database.PuzzleInputRepository;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class DatabaseInputProvider implements InputProvider {

    private final PuzzleInputRepository puzzleInputRepository;
    private final PuzzleInputKey inputKey;

    public DatabaseInputProvider(
            PuzzleInputRepository puzzleInputRepository, PuzzleInputKey inputKey) {
        this.puzzleInputRepository = puzzleInputRepository;
        this.inputKey = inputKey;
    }

    @Override
    public String getInputString() throws NoSuchElementException {
        return getInputData();
    }

    @Override
    public Stream<String> getInputStream() throws IOException, URISyntaxException {
        String puzzleInput = getInputData();

        return Stream.of(puzzleInput.split("\n"));
    }

    @Override
    public List<String> getInputList() throws IOException, URISyntaxException {
        String puzzleInput = getInputData();

        return List.of(puzzleInput.split("\n"));
    }

    private String getInputData() throws NoSuchElementException {
        return puzzleInputRepository
                .findById(inputKey)
                .map(PuzzleInput::getInputData)
                .orElseThrow();
    }
}
