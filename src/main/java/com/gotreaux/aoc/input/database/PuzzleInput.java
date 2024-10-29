package com.gotreaux.aoc.input.database;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "puzzle_input")
public class PuzzleInput {

    @EmbeddedId private PuzzleInputKey id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "input_data")
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
}
