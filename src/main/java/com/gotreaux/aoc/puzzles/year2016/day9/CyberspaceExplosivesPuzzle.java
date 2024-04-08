package com.gotreaux.aoc.puzzles.year2016.day9;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

@ShellPuzzle(year = 2016, day = 9, title = "Explosives in Cyberspace")
public class CyberspaceExplosivesPuzzle extends Puzzle {
    public CyberspaceExplosivesPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        String input = getInputProvider().getInputString();

        StringBuilder decompressedSequence = new StringBuilder(input.length());
        int index = 0;
        while (index < input.length()) {
            char c = input.charAt(index);
            if (c == '(') {
                int markerEnd = input.indexOf(')', index);
                String marker = input.substring(index + 1, markerEnd);

                Scanner scanner = new Scanner(marker);
                scanner.useDelimiter("x");
                int subsequence = scanner.nextInt();
                int occurrences = scanner.nextInt();
                scanner.close();

                String sequence = input.substring(markerEnd + 1, markerEnd + subsequence + 1);
                decompressedSequence.append(sequence.repeat(occurrences));

                index = markerEnd + subsequence + 1;
            } else {
                decompressedSequence.append(c);
                index++;
            }
        }

        return new PuzzleOutput<>(decompressedSequence.length(), 0);
    }
}
