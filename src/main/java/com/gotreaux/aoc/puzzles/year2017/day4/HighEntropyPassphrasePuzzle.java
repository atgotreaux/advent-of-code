package com.gotreaux.aoc.puzzles.year2017.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class HighEntropyPassphrasePuzzle extends Puzzle {

    public HighEntropyPassphrasePuzzle() {
        super(2017, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var validDuplicateWordPassphrases = 0;
        var validAnagramWordPassphrases = 0;

        PassphrasePolicy duplicateWordPolicy = new DuplicateWordPassphrasePolicy();
        PassphrasePolicy anagramWordPolicy = new AnagramWordPassphrasePolicy();

        for (var line : inputReader.getInputList()) {
            var passphrase = line.split(" ");

            if (duplicateWordPolicy.passes(passphrase)) {
                validDuplicateWordPassphrases++;
            }
            if (anagramWordPolicy.passes(passphrase)) {
                validAnagramWordPassphrases++;
            }
        }

        return new PuzzleOutput<>(validDuplicateWordPassphrases, validAnagramWordPassphrases);
    }
}
