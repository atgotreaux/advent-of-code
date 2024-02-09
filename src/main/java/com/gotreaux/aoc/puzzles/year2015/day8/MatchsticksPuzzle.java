package com.gotreaux.aoc.puzzles.year2015.day8;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HexFormat;

@ShellPuzzle(year = 2015, day = 8, title = "Matchsticks")
public class MatchsticksPuzzle extends Puzzle {
    public MatchsticksPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        int differenceOfLiteralsAndValues = 0;
        int differenceOfEncodedAndLiterals = 0;

        for (String line : getInputProvider().getInputList()) {
            int length = line.length();
            int values = 0;
            StringBuilder encoded = new StringBuilder("\"");

            int i = 0;
            while (i < length) {
                char literal = line.charAt(i);
                if (literal == '"') {
                    encoded.append("\\\"");
                    i++;
                } else if (literal == '\\') {
                    if (line.charAt(i + 1) == '\\') {
                        values++;
                        encoded.append("\\\\\\\\");
                        i += 2;
                    } else if (line.charAt(i + 1) == '"') {
                        values++;
                        encoded.append("\\\\\\\"");
                        i += 2;
                    } else if (line.charAt(i + 1) == 'x'
                            && HexFormat.isHexDigit(line.charAt(i + 2))
                            && HexFormat.isHexDigit(line.charAt(i + 3))) {
                        values++;
                        encoded.append("\\\\").append(line, i + 1, i + 4);
                        i += 4;
                    }
                } else {
                    values++;
                    encoded.append(literal);
                    i++;
                }
            }
            encoded.append("\"");

            differenceOfLiteralsAndValues += length - values;
            differenceOfEncodedAndLiterals += encoded.length() - length;
        }

        return new PuzzleOutput<>(differenceOfLiteralsAndValues, differenceOfEncodedAndLiterals);
    }
}
