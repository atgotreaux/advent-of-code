package com.gotreaux.aoc.input.database;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.Objects;

@Embeddable
public class PuzzleInputKey {

    @Column(name = "puzzle_year", nullable = false)
    @Min(2015)
    @Max(2023)
    private Integer puzzleYear;

    @Column(name = "puzzle_day", nullable = false)
    @Min(1)
    @Max(25)
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PuzzleInputKey)) {
            return false;
        }

        PuzzleInputKey puzzleInputKey = (PuzzleInputKey) obj;
        return Objects.equals(puzzleYear, puzzleInputKey.getPuzzleYear())
                && Objects.equals(puzzleDay, puzzleInputKey.getPuzzleDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(puzzleYear, puzzleDay);
    }
}
