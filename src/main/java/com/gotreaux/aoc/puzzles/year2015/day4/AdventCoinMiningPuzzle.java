package com.gotreaux.aoc.puzzles.year2015.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class AdventCoinMiningPuzzle extends Puzzle {

    public AdventCoinMiningPuzzle() {
        super(2015, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputString();

        try {
            var md = MessageDigest.getInstance("MD5");

            var partOne = findHashMatchingCondition(md, input, s -> s.startsWith("00000"));
            var partTwo = findHashMatchingCondition(md, input, s -> s.startsWith("000000"));

            return new PuzzleOutput<>(partOne, partTwo);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not found", e);
        }
    }

    private static int findHashMatchingCondition(
            MessageDigest md, String secretKey, Predicate<String> condition) {
        var number = 0;
        while (true) {
            var input = secretKey + number;
            md.update(input.getBytes(Charset.defaultCharset()));
            var hash = HexFormat.of().formatHex(md.digest());

            if (condition.test(hash)) {
                return number;
            }

            number++;
        }
    }
}
