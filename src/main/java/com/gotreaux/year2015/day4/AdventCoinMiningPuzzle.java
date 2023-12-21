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

    private long lowestNumberOfFiveZeroes;
    private long lowestNumberOfSixZeroes;

    public AdventCoinMiningPuzzle() {
        super();
    }

    public AdventCoinMiningPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public void prepare() throws Exception {
        String input = getInputProvider().getInputString();
        MessageDigest md = MessageDigest.getInstance("MD5");

        int number = 0;
        while (lowestNumberOfFiveZeroes == 0 || lowestNumberOfSixZeroes == 0) {
            String secretKey = input + number;
            md.update(secretKey.getBytes());
            String hash = HexFormat.of().formatHex(md.digest());

            if (hash.startsWith("000000")) {
                if (lowestNumberOfSixZeroes == 0) {
                    lowestNumberOfSixZeroes = number;
                }
            } else if (hash.startsWith("00000")) {
                if (lowestNumberOfFiveZeroes == 0) {
                    lowestNumberOfFiveZeroes = number;
                }
            }

            number++;
        }
    }

    @Override
    public Long getPartOne() {
        return lowestNumberOfFiveZeroes;
    }

    @Override
    public Long getPartTwo() {
        return lowestNumberOfSixZeroes;
    }
}
