package com.gotreaux.year2015.day4;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.function.Predicate;

public class AdventCoinMiningPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        AdventCoinMiningPuzzle puzzle = new AdventCoinMiningPuzzle();

        puzzle.solve();
    }

    public AdventCoinMiningPuzzle() {
        super();
    }

    public AdventCoinMiningPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        return findHashMatchingCondition(
                getInputProvider().getInputString(), string -> string.startsWith("00000"));
    }

    @Override
    public Long getPartTwo() throws Exception {
        return findHashMatchingCondition(
                getInputProvider().getInputString(), string -> string.startsWith("000000"));
    }

    private Long findHashMatchingCondition(String secretKey, Predicate<String> condition)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        long number = 0;
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
