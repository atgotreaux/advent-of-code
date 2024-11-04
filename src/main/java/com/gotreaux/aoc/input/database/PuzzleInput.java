package com.gotreaux.aoc.input.database;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.Objects;
import org.springframework.lang.Nullable;

@Entity
@Table(
        name = "puzzle_input",
        uniqueConstraints = @UniqueConstraint(columnNames = {"puzzle_year", "puzzle_day"}))
public class PuzzleInput {

    @EmbeddedId @Nullable private PuzzleInputKey id;

    @Column(name = "input_data", nullable = false, columnDefinition = "CLOB")
    @Nullable
    private String inputData;

    public PuzzleInput() {}

    public PuzzleInput(@Nullable Integer year, @Nullable Integer day, @Nullable String inputData) {
        id = new PuzzleInputKey(year, day);
        this.inputData = inputData;
    }

    @Nullable
    public PuzzleInputKey getId() {
        return id;
    }

    public void setId(@Nullable PuzzleInputKey id) {
        this.id = id;
    }

    @Nullable
    public String getInputData() {
        return inputData;
    }

    public void setInputData(@Nullable String inputData) {
        this.inputData = inputData;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PuzzleInput puzzleInput)) {
            return false;
        }

        return Objects.equals(id, puzzleInput.getId())
                && Objects.equals(inputData, puzzleInput.getInputData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inputData);
    }
}
