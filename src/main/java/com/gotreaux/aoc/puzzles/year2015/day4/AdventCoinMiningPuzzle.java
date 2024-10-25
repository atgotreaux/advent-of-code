package com.gotreaux.aoc.puzzles.year2015.day4;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
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
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException, NoSuchAlgorithmException {
        String input = inputProvider.getInputString();

        int partOne = findHashMatchingCondition(input, s -> s.startsWith("00000"));
        int partTwo = findHashMatchingCondition(input, s -> s.startsWith("000000"));

        return new PuzzleOutput<>(partOne, partTwo);
    }

    private static int findHashMatchingCondition(String secretKey, Predicate<String> condition)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        int number = 0;
        while (true) {
            String input = secretKey + number;
            md.update(input.getBytes(Charset.defaultCharset()));
            String hash = HexFormat.of().formatHex(md.digest());

            if (condition.test(hash)) {
                return number;
            }

            number++;
        }
    }
}
