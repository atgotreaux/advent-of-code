package com.gotreaux.aoc.input;

import com.gotreaux.aoc.input.database.PuzzleInput;
import com.gotreaux.aoc.input.database.PuzzleInputKey;
import com.gotreaux.aoc.input.database.PuzzleInputRepository;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class DatabaseInputProvider implements InputProvider {

    private final PuzzleInputRepository puzzleInputRepository;
    private final int year;
    private final int day;

    public DatabaseInputProvider(PuzzleInputRepository puzzleInputRepository, int year, int day) {
        this.puzzleInputRepository = puzzleInputRepository;
        this.year = year;
        this.day = day;
    }

    @Override
    public String getInputString() throws NoSuchElementException {
        return getInputData();
    }

    @Override
    public Stream<String> getInputStream() throws IOException, NoSuchElementException {
        String puzzleInput = getInputData();

        return Stream.of(puzzleInput.split("\n"));
    }

    @Override
    public List<String> getInputList() throws IOException, NoSuchElementException {
        String puzzleInput = getInputData();

        return List.of(puzzleInput.split("\n"));
    }

    private String getInputData() throws NoSuchElementException {
        PuzzleInputKey inputKey = new PuzzleInputKey(year, day);

        return puzzleInputRepository
                .findById(inputKey)
                .map(PuzzleInput::getInputData)
                .orElseThrow();
    }
}
