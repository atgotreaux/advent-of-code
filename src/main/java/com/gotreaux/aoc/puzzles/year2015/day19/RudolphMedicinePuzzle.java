package com.gotreaux.aoc.puzzles.year2015.day19;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class RudolphMedicinePuzzle extends Puzzle {

    public RudolphMedicinePuzzle() {
        super(2015, 19);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var replacements = input.stream().limit(input.size() - 2).map(Replacement::of).toList();
        var molecule = input.getLast();

        var moleculeMachine = new MoleculeMachine(replacements, molecule);

        var calibrationMolecules = moleculeMachine.getCalibrationMolecules().size();
        var stepsToFabricate = moleculeMachine.getStepCountToFabricate();

        return new PuzzleOutput<>(calibrationMolecules, stepsToFabricate);
    }
}
