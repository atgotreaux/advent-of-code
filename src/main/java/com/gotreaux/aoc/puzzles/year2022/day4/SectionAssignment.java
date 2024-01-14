package com.gotreaux.aoc.puzzles.year2022.day4;

record SectionAssignment(long firstSection, long lastSection) {
    SectionAssignment {
        if (firstSection > lastSection) {
            throw new IllegalArgumentException("Section assignments must be in ascending format");
        }
    }

    boolean contains(SectionAssignment other) {
        return firstSection <= other.firstSection() && lastSection >= other.lastSection();
    }

    boolean overlaps(SectionAssignment other) {
        return (firstSection <= other.firstSection() && lastSection >= other.firstSection())
                || (firstSection <= other.lastSection() && lastSection >= other.firstSection());
    }
}
