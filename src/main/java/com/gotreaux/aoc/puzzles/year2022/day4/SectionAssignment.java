package com.gotreaux.aoc.puzzles.year2022.day4;

public record SectionAssignment(long firstSection, long lastSection) {
    public SectionAssignment {
        if (firstSection > lastSection) {
            throw new IllegalArgumentException("Section assignments must be in ascending format");
        }
    }

    public boolean contains(SectionAssignment other) {
        return this.firstSection <= other.firstSection && this.lastSection >= other.lastSection;
    }

    public boolean overlaps(SectionAssignment other) {
        return (this.firstSection <= other.firstSection && this.lastSection >= other.firstSection)
                || (this.firstSection <= other.lastSection
                        && this.lastSection >= other.firstSection);
    }
}
