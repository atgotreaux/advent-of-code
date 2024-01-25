package com.gotreaux.aoc.puzzles.year2021.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@ShellPuzzle(year = 2021, day = 3, title = "Binary Diagnostic")
public class BinaryDiagnosticPuzzle extends Puzzle {
    public BinaryDiagnosticPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        Map<Integer, Integer> zeroes = new HashMap<>();
        Map<Integer, Integer> ones = new HashMap<>();

        for (String line : getInputProvider().getInputList()) {
            for (int i = 0; i < line.length(); i++) {
                int bit = Character.digit(line.charAt(i), 10);
                switch (bit) {
                    case 0:
                        ones.merge(i, 1, Integer::sum);
                        break;
                    case 1:
                        zeroes.merge(i, 1, Integer::sum);
                        break;
                    default:
                        throw new IllegalArgumentException("Unexpected bit '%d'".formatted(bit));
                }
            }
        }

        StringBuilder gamma = new StringBuilder(zeroes.size());
        StringBuilder epsilon = new StringBuilder(zeroes.size());
        for (int i = 0; i < ones.size(); i++) {
            if (zeroes.get(i) > ones.get(i)) {
                gamma.append(0);
                epsilon.append(1);
            } else {
                gamma.append(1);
                epsilon.append(0);
            }
        }
        int power = Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);

        return new PuzzleOutput<>(power, 0);
    }
}
