package com.gotreaux.aoc.input.writer;

import com.gotreaux.aoc.persistence.entity.PuzzleEntity;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;

public class DatabaseInputWriter implements InputWriter {
    private final PuzzleRepository puzzleRepository;
    private final int year;
    private final int day;

    public DatabaseInputWriter(PuzzleRepository puzzleRepository, int year, int day) {
        this.puzzleRepository = puzzleRepository;
        this.year = year;
        this.day = day;
    }

    @Override
    public void write(String input) {
        PuzzleEntity puzzleEntity = new PuzzleEntity(year, day, input);
        puzzleRepository.save(puzzleEntity);
    }
}
