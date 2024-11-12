package com.gotreaux.aoc.puzzles.year2015.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HexFormat;
import org.springframework.stereotype.Component;

@Component
public class MatchsticksPuzzle extends Puzzle {

    public MatchsticksPuzzle() {
        super(2015, 8);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException {
        int differenceOfLiteralsAndValues = 0;
        int differenceOfEncodedAndLiterals = 0;

        for (String line : inputReader.getInputList()) {
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
