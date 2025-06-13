package com.gotreaux.aoc.puzzles.year2024.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class DiskFragmenterPuzzle extends Puzzle {

    public DiskFragmenterPuzzle() {
        super(2024, 9);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var input = inputReader.getInputString();

        var filesystem = Filesystem.of(input);

        var defraggedBlocks = filesystem.defragmentBlocks();
        var defraggedFiles = filesystem.defragmentFiles();

        return new PuzzleOutput<>(defraggedBlocks.getChecksum(), defraggedFiles.getChecksum());
    }
}
