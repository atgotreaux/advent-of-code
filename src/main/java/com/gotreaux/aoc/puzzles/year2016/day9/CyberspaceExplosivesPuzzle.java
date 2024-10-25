package com.gotreaux.aoc.puzzles.year2016.day9;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class CyberspaceExplosivesPuzzle extends Puzzle {

    public CyberspaceExplosivesPuzzle() {
        super(2016, 9);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException {
        String input = inputProvider.getInputString();

        long decompressedLength = decompress(input, false);
        long decompressedRecursiveLength = decompress(input, true);

        return new PuzzleOutput<>(decompressedLength, decompressedRecursiveLength);
    }

    private static long decompress(String input, boolean recursiveDecompression) {
        long decompressedLength = 0;
        int index = 0;

        while (index < input.length()) {
            char c = input.charAt(index);
            if (c == '(') {
                int markerEnd = input.indexOf(')', index);
                String marker = input.substring(index + 1, markerEnd);

                Scanner scanner = new Scanner(marker);
                scanner.useDelimiter("x");
                int subsequence = scanner.nextInt();
                long occurrences = scanner.nextLong();
                scanner.close();

                String sequence = input.substring(markerEnd + 1, markerEnd + subsequence + 1);
                if (recursiveDecompression) {
                    decompressedLength += occurrences * decompress(sequence, true);
                } else {
                    decompressedLength += occurrences * sequence.length();
                }

                index = markerEnd + subsequence + 1;
            } else {
                decompressedLength++;
                index++;
            }
        }

        return decompressedLength;
    }
}
