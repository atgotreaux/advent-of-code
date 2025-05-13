package com.gotreaux.aoc.puzzles.year2016.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class CyberspaceExplosivesPuzzle extends Puzzle {

    public CyberspaceExplosivesPuzzle() {
        super(2016, 9);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) throws Exception {
        var input = inputReader.getInputString();

        var decompressedLength = decompress(input, false);
        var decompressedRecursiveLength = decompress(input, true);

        return new PuzzleOutput<>(decompressedLength, decompressedRecursiveLength);
    }

    private static long decompress(String input, boolean recursiveDecompression) {
        long decompressedLength = 0;
        var index = 0;

        while (index < input.length()) {
            var c = input.charAt(index);
            if (c == '(') {
                var markerEnd = input.indexOf(')', index);
                var marker = input.substring(index + 1, markerEnd);

                var scanner = new Scanner(marker);
                scanner.useDelimiter("x");
                var subsequence = scanner.nextInt();
                var occurrences = scanner.nextLong();
                scanner.close();

                var sequence = input.substring(markerEnd + 1, markerEnd + subsequence + 1);
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
