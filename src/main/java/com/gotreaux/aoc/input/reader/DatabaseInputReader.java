package com.gotreaux.aoc.input.reader;

import com.gotreaux.aoc.persistence.entity.PuzzleEntity;
import com.gotreaux.aoc.persistence.entity.PuzzleEntityId;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class DatabaseInputReader implements InputReader {

    private final PuzzleRepository puzzleRepository;
    private final int year;
    private final int day;

    public DatabaseInputReader(PuzzleRepository puzzleRepository, int year, int day) {
        this.puzzleRepository = puzzleRepository;
        this.year = year;
        this.day = day;
    }

    @Override
    public String getInputString() throws NoSuchElementException {
        return getInput();
    }

    @Override
    public Stream<String> getInputStream() throws IOException, NoSuchElementException {
        String puzzleInput = getInput();

        return Stream.of(puzzleInput.split("\n"));
    }

    @Override
    public List<String> getInputList() throws IOException, NoSuchElementException {
        String puzzleInput = getInput();

        return List.of(puzzleInput.split("\n"));
    }

    private String getInput() throws NoSuchElementException {
        PuzzleEntityId inputKey = new PuzzleEntityId(year, day);

        return puzzleRepository.findById(inputKey).map(PuzzleEntity::getInput).orElseThrow();
    }
}
