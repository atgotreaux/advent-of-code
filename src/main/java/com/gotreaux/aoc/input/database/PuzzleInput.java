package com.gotreaux.aoc.input.database;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.Objects;

@Entity
@Table(
        name = "puzzle_input",
        uniqueConstraints = @UniqueConstraint(columnNames = {"puzzle_year", "puzzle_day"}))
public class PuzzleInput {

    @EmbeddedId private PuzzleInputKey id;

    @Column(name = "input_data", nullable = false, columnDefinition = "CLOB")
    private String inputData;

    public PuzzleInputKey getId() {
        return id;
    }

    public void setId(PuzzleInputKey id) {
        this.id = id;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PuzzleInput)) {
            return false;
        }

        PuzzleInput puzzleInput = (PuzzleInput) obj;
        return Objects.equals(id, puzzleInput.getId())
                && Objects.equals(inputData, puzzleInput.getInputData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inputData);
    }
}
