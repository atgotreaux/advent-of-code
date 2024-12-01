package com.gotreaux.aoc.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.Objects;
import org.springframework.lang.Nullable;

@Embeddable
public class PuzzleEntityId {

    @Column(nullable = false)
    @Min(2015)
    @Max(2024)
    @Nullable
    private Integer year;

    @Column(nullable = false)
    @Min(1)
    @Max(25)
    @Nullable
    private Integer day;

    public PuzzleEntityId() {}

    public PuzzleEntityId(@Nullable Integer year, @Nullable Integer day) {
        this.year = year;
        this.day = day;
    }

    @Nullable
    public Integer getYear() {
        return year;
    }

    public void setYear(@Nullable Integer year) {
        this.year = year;
    }

    @Nullable
    public Integer getDay() {
        return day;
    }

    public void setDay(@Nullable Integer day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PuzzleEntityId puzzleEntityId)) {
            return false;
        }

        return Objects.equals(year, puzzleEntityId.getYear())
                && Objects.equals(day, puzzleEntityId.getDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, day);
    }
}
