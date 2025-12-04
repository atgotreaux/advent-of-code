package com.gotreaux.aoc.puzzles.year2015.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class AdventCoinMiningPuzzle extends Puzzle<Integer, Integer> {

    public AdventCoinMiningPuzzle() {
        super(2015, 4);
    }

    @Override
    public Integer solvePartOne(InputReader inputReader) {
        var input = inputReader.getInputString();

        return findHashMatchingCondition(input, s -> s.startsWith("00000"));
    }

    @Override
    public Integer solvePartTwo(InputReader inputReader) {
        var input = inputReader.getInputString();

        return findHashMatchingCondition(input, s -> s.startsWith("000000"));
    }

    private static int findHashMatchingCondition(String secretKey, Predicate<String> condition) {
        var number = 0;
        while (true) {
            try {
                var input = secretKey + number;
                var md = MessageDigest.getInstance("MD5");
                var hash =
                        HexFormat.of().formatHex(md.digest(input.getBytes(StandardCharsets.UTF_8)));
                if (condition.test(hash)) {
                    return number;
                }
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("MD5 algorithm not found", e);
            }

            number++;
        }
    }
}
