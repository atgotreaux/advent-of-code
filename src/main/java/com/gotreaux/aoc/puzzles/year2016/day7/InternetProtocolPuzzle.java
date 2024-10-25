package com.gotreaux.aoc.puzzles.year2016.day7;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class InternetProtocolPuzzle extends Puzzle {

    public InternetProtocolPuzzle() {
        super(2016, 7);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException {
        int supportsTlsCount = 0;
        int supportsSslCount = 0;

        for (String line : inputProvider.getInputList()) {
            Collection<String> supernets = new ArrayList<>();
            Collection<String> hypernets = new ArrayList<>();

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter("[\\[\\]]");
            int match = 0;
            while (scanner.hasNext()) {
                if (match % 2 == 0) {
                    supernets.add(scanner.next());
                } else {
                    hypernets.add(scanner.next());
                }
                match++;
            }
            scanner.close();

            if (supportsTls(supernets, hypernets)) {
                supportsTlsCount++;
            }
            if (supportsSsl(supernets, hypernets)) {
                supportsSslCount++;
            }
        }

        return new PuzzleOutput<>(supportsTlsCount, supportsSslCount);
    }

    private static boolean supportsTls(Collection<String> supernets, Collection<String> hypernets) {
        return supernets.stream().anyMatch(InternetProtocolPuzzle::hasAbba)
                && hypernets.stream().noneMatch(InternetProtocolPuzzle::hasAbba);
    }

    private static boolean supportsSsl(Collection<String> supernets, Collection<String> hypernets) {
        Collection<String> babs = hypernets.stream().flatMap(s -> getAbas(s).stream()).toList();
        return supernets.stream()
                .flatMap(s -> getAbas(s).stream())
                .map(s -> String.valueOf(s.charAt(1)) + s.charAt(0) + s.charAt(1))
                .anyMatch(babs::contains);
    }

    private static boolean hasAbba(String net) {
        for (int i = 0; i < net.length() - 3; i++) {
            String abba = net.substring(i, i + 4);
            if (abba.charAt(0) == abba.charAt(3)
                    && abba.charAt(1) == abba.charAt(2)
                    && abba.charAt(0) != abba.charAt(1)) {
                return true;
            }
        }

        return false;
    }

    private static Collection<String> getAbas(String net) {
        Collection<String> abas = new ArrayList<>();

        for (int i = 0; i < net.length() - 2; i++) {
            String aba = net.substring(i, i + 3);
            if (aba.charAt(0) == aba.charAt(2) && aba.charAt(0) != aba.charAt(1)) {
                abas.add(aba);
            }
        }

        return abas;
    }
}
