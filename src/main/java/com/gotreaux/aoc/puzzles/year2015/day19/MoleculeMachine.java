package com.gotreaux.aoc.puzzles.year2015.day19;

import com.gotreaux.aoc.utils.graph.Edge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

record MoleculeMachine(Collection<Edge> replacements, String molecule) {

    Collection<String> getCalibrationMolecules() {
        Collection<String> molecules = new HashSet<>();

        for (Edge replacement : replacements) {
            for (int i = 0; i < molecule.length(); i++) {
                if (molecule.startsWith(replacement.from(), i)) {
                    molecules.add(
                            molecule.substring(0, i)
                                    + replacement.to()
                                    + molecule.substring(i + replacement.from().length()));
                }
            }
        }

        return molecules;
    }

    int getStepCountToFabricate() {
        if (replacements.stream().noneMatch(replacement -> replacement.from().equals("e"))) {
            return -1;
        }

        List<Edge> sortedReplacements = new ArrayList<>(replacements);
        sortedReplacements.sort((r1, r2) -> Integer.compare(r2.to().length(), r1.to().length()));

        int steps = 0;
        String currentMolecule = molecule;
        while (!currentMolecule.equals("e")) {
            for (Edge replacement : sortedReplacements) {
                if (currentMolecule.contains(replacement.to())) {
                    currentMolecule =
                            currentMolecule.replaceFirst(replacement.to(), replacement.from());
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
