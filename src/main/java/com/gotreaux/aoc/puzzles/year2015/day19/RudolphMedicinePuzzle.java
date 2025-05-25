package com.gotreaux.aoc.puzzles.year2015.day19;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.graph.Edge;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class RudolphMedicinePuzzle extends Puzzle {

    public RudolphMedicinePuzzle() {
        super(2015, 19);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var molecule = "";
        var mapReplacementEdge = new MapReplacementEdgeFunction();
        Collection<Edge> replacements = new ArrayList<>(input.size() - 2);
        for (var line : input) {
            if (MapReplacementEdgeFunction.PATTERN.matcher(line).matches()) {
                replacements.add(mapReplacementEdge.apply(line));
            } else if (!line.isEmpty()) {
                molecule = line;
            }
        }

        var moleculeMachine = new MoleculeMachine(replacements, molecule);

        var calibrationMolecules = moleculeMachine.getCalibrationMolecules().size();
        var stepsToFabricate = moleculeMachine.getStepCountToFabricate();

        return new PuzzleOutput<>(calibrationMolecules, stepsToFabricate);
    }
}
