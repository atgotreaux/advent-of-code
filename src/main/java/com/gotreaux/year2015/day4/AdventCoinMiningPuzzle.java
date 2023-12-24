package com.gotreaux.year2015.day4;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;

import java.security.MessageDigest;
import java.util.HexFormat;

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
        String input = getInputProvider().getInputString();
        MessageDigest md = MessageDigest.getInstance("MD5");

        long number = 0L;
        while (true) {
            String secretKey = input + number;
            md.update(secretKey.getBytes());
            String hash = HexFormat.of().formatHex(md.digest());

            if (hash.startsWith("00000")) {
                return number;
            }

            number++;
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        String input = getInputProvider().getInputString();
        MessageDigest md = MessageDigest.getInstance("MD5");

        long number = 0;
        while (true) {
            String secretKey = input + number;
            md.update(secretKey.getBytes());
            String hash = HexFormat.of().formatHex(md.digest());

            if (hash.startsWith("000000")) {
                return number;
            }

            number++;
        }
    }
}
