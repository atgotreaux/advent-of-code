package com.gotreaux.aoc.input.reader;

import com.gotreaux.aoc.persistence.entity.PuzzleEntity;
import com.gotreaux.aoc.persistence.entity.PuzzleEntityId;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import java.util.List;
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
    public String getInputString() {
        return getInput();
    }

    @Override
    public Stream<String> getInputStream() {
        var puzzleInput = getInput();

        return Stream.of(puzzleInput.split("\n"));
    }

    @Override
    public List<String> getInputList() {
        var puzzleInput = getInput();

        return List.of(puzzleInput.split("\n"));
    }

    private String getInput() {
        var inputKey = new PuzzleEntityId(year, day);

        return puzzleRepository.findById(inputKey).map(PuzzleEntity::getInput).orElseThrow();
    }
}
