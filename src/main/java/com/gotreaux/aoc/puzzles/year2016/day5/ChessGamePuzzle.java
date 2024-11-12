package com.gotreaux.aoc.puzzles.year2016.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ChessGamePuzzle extends Puzzle {

    public ChessGamePuzzle() {
        super(2016, 5);
    }

    @Override
    public PuzzleOutput<String, String> solve(InputReader inputReader)
            throws IOException, URISyntaxException, NoSuchAlgorithmException {
        String doorID = inputReader.getInputString();

        StringBuilder nextCharBuilder = new StringBuilder(8);
        Map<Integer, Integer> positionPasswordMapping = new HashMap<>();

        MessageDigest md = MessageDigest.getInstance("MD5");
        int number = 0;
        while (nextCharBuilder.length() < 8 || positionPasswordMapping.size() < 8) {
            String input = doorID + number;
            md.update(input.getBytes(Charset.defaultCharset()));
            String hash = HexFormat.of().formatHex(md.digest());

            if (hash.startsWith("00000")) {
                if (nextCharBuilder.length() < 8) {
                    nextCharBuilder.append(hash.charAt(5));
                }
                int hexIndex = HexFormat.fromHexDigit(hash.codePointAt(5));
                if (positionPasswordMapping.size() < 8 && hexIndex < 8) {
                    positionPasswordMapping.putIfAbsent(hexIndex, hash.codePointAt(6));
                }
            }

            number++;
        }

        String nextPositionPassword =
                positionPasswordMapping.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(Map.Entry::getValue)
                        .collect(
                                StringBuilder::new,
                                StringBuilder::appendCodePoint,
                                StringBuilder::append)
                        .toString();

        return new PuzzleOutput<>(nextCharBuilder.toString(), nextPositionPassword);
    }
}
