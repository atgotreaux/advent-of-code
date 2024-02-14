package com.gotreaux.aoc.puzzles.year2016.day4;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

@ShellPuzzle(year = 2016, day = 4, title = "Security Through Obscurity")
public class SecurityThroughObscurityPuzzle extends Puzzle {
    public SecurityThroughObscurityPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, NumberFormatException {
        int sumOfRealRooms = 0;
        int northPoleSectorID = Integer.MAX_VALUE;

        Comparator<Map.Entry<Integer, Long>> comparator =
                Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey());

        for (String line : getInputProvider().getInputList()) {
            StringBuilder encryptedName = new StringBuilder();
            int sectorID = 0;
            String checksum = "";

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter("-");
            while (scanner.hasNext()) {
                String roomPart = scanner.next();
                if (Character.isDigit(roomPart.charAt(0))) {
                    sectorID = Integer.parseInt(roomPart.substring(0, 3));
                    checksum = roomPart.substring(4, 9);
                } else {
                    encryptedName.append(roomPart);
                }
            }
            scanner.close();

            String encryptedChecksum =
                    encryptedName
                            .chars()
                            .boxed()
                            .collect(groupingBy(identity(), counting()))
                            .entrySet()
                            .stream()
                            .sorted(comparator)
                            .limit(5)
                            .map(Map.Entry::getKey)
                            .collect(
                                    StringBuilder::new,
                                    StringBuilder::appendCodePoint,
                                    StringBuilder::append)
                            .toString();
            if (encryptedChecksum.equals(checksum)) {
                sumOfRealRooms += sectorID;
            }

            StringBuilder decryptedName = new StringBuilder(encryptedName.length());

            for (int i = 0; i < encryptedName.length(); i++) {
                int letter = encryptedName.codePointAt(i);
                decryptedName.appendCodePoint((letter - 'a' + sectorID) % 26 + 'a');
            }
            if (decryptedName.toString().equals("northpoleobjectstorage")) {
                northPoleSectorID = sectorID;
            }
        }

        return new PuzzleOutput<>(sumOfRealRooms, northPoleSectorID);
    }
}
