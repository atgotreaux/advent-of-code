package com.gotreaux.aoc.puzzles.year2017.day4;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;

@ShellPuzzle(year = 2017, day = 4, title = "High-Entropy Passphrases")
public class HighEntropyPassphrasePuzzle extends Puzzle {
    public HighEntropyPassphrasePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        int validDuplicateWordPassphrases = 0;
        int validAnagramWordPassphrases = 0;

        PassphrasePolicy duplicateWordPolicy = new DuplicateWordPassphrasePolicy();
        PassphrasePolicy anagramWordPolicy = new AnagramWordPassphrasePolicy();

        for (String line : getInputProvider().getInputList()) {
            String[] passphrase = line.split(" ");

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
