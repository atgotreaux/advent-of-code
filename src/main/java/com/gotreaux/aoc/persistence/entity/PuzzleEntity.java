package com.gotreaux.aoc.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.Objects;
import org.springframework.lang.Nullable;

@Entity
@Table(
        name = "puzzle",
        uniqueConstraints = @UniqueConstraint(columnNames = {"puzzle_year", "puzzle_day"}))
public class PuzzleEntity {

    @EmbeddedId @Nullable private PuzzleEntityId id;

    @Column(name = "raw_input", nullable = false)
    @Lob
    @Nullable
    private String input;

    public PuzzleEntity() {}

    public PuzzleEntity(@Nullable Integer year, @Nullable Integer day, @Nullable String input) {
        id = new PuzzleEntityId(year, day);
        this.input = input;
    }

    @Nullable
    public PuzzleEntityId getId() {
        return id == null ? null : new PuzzleEntityId(id.getYear(), id.getDay());
    }

    public void setId(@Nullable PuzzleEntityId id) {
        this.id = id == null ? null : new PuzzleEntityId(id.getYear(), id.getDay());
    }

    @Nullable
    public String getInput() {
        return input;
    }

    public void setInput(@Nullable String input) {
        this.input = input;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PuzzleEntity puzzleEntity)) {
            return false;
        }

        return Objects.equals(id, puzzleEntity.getId())
                && Objects.equals(input, puzzleEntity.getInput());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, input);
    }
}
