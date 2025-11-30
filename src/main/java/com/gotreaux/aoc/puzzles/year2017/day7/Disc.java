package com.gotreaux.aoc.puzzles.year2017.day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.jspecify.annotations.Nullable;

class Disc {
    private final String program;
    private final int weight;
    private @Nullable Disc parent;
    private final Collection<Disc> children = new ArrayList<>();

    Disc(String program, int weight) {
        this.program = program;
        this.weight = weight;
    }

    String getProgram() {
        return program;
    }

    int getWeight() {
        return weight;
    }

    @Nullable Disc getParent() {
        return parent;
    }

    void setParent(Disc parent) {
        this.parent = parent;
    }

    Collection<Disc> getChildren() {
        return Collections.unmodifiableCollection(children);
    }

    void addChild(Disc child) {
        children.add(child);
    }

    int getTotalWeight() {
        return weight + children.stream().mapToInt(Disc::getTotalWeight).sum();
    }
}
