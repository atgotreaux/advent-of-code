package com.gotreaux.aoc.puzzles.year2016.day7;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ShellPuzzle(year = 2016, day = 7, title = "Internet Protocol Version 7")
public class InternetProtocolPuzzle extends Puzzle {
    public InternetProtocolPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        int supportsTls = 0;
        int supportsSsl = 0;

        for (String line : getInputProvider().getInputList()) {
            if (supportsTls(line)) {
                supportsTls++;
            }
            if (supportsSsl(line)) {
                supportsSsl++;
            }
        }

        return new PuzzleOutput<>(supportsTls, supportsSsl);
    }

    private static boolean supportsTls(String line) {
        boolean isHypernet = false;
        boolean foundAbba = false;

        for (int i = 0; i < line.length() - 3; i++) {
            String abba = line.substring(i, i + 4);
            if (!isHypernet && abba.contains("[")) {
                isHypernet = true;
            }
            if (isHypernet && abba.contains("]")) {
                isHypernet = false;
            }

            if (abba.charAt(0) == abba.charAt(3)
                    && abba.charAt(1) == abba.charAt(2)
                    && abba.charAt(0) != abba.charAt(1)) {
                if (isHypernet) {
                    return false;
                }
                foundAbba = true;
            }
        }

        return foundAbba;
    }

    private static boolean supportsSsl(String line) {
        boolean isHypernet = false;
        Collection<String> abas = new ArrayList<>();
        List<String> babs = new ArrayList<>();

        for (int i = 0; i < line.length() - 2; i++) {
            String aba = line.substring(i, i + 3);
            if (!isHypernet && aba.contains("[")) {
                isHypernet = true;
            }
            if (isHypernet && aba.contains("]")) {
                isHypernet = false;
            }

            if (aba.charAt(0) == aba.charAt(2) && aba.charAt(0) != aba.charAt(1)) {
                if (isHypernet) {
                    babs.add(aba);
                } else {
                    abas.add(aba);
                }
            }
        }

        return abas.stream()
                .map(s -> String.valueOf(s.charAt(1)) + s.charAt(0) + s.charAt(1))
                .anyMatch(babs::contains);
    }
}
