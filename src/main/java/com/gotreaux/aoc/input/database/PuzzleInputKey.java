package com.gotreaux.aoc.input.database;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PuzzleInputKey {

    @Column(name = "puzzle_year")
    private Integer puzzleYear;

    @Column(name = "puzzle_day")
    private Integer puzzleDay;

    public PuzzleInputKey() {}

    public PuzzleInputKey(Integer puzzleYear, Integer puzzleDay) {
        this.puzzleYear = puzzleYear;
        this.puzzleDay = puzzleDay;
    }

    public Integer getPuzzleYear() {
        return puzzleYear;
    }

    public void setPuzzleYear(Integer year) {
        puzzleYear = year;
    }

    public Integer getPuzzleDay() {
        return puzzleDay;
    }

    public void setPuzzleDay(Integer day) {
        puzzleDay = day;
    }
}
