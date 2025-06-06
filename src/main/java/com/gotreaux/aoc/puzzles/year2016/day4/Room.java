package com.gotreaux.aoc.puzzles.year2016.day4;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

record Room(int sectorID, String checksum, String encryptedName) {

    static Room of(String line) {
        var sectorID = 0;
        var checksum = "";
        var encryptedName = new StringBuilder();

        var scanner = new Scanner(line);
        scanner.useDelimiter("-");
        while (scanner.hasNext()) {
            var roomPart = scanner.next();
            if (Character.isDigit(roomPart.charAt(0))) {
                sectorID = Integer.parseInt(roomPart.substring(0, 3));
                checksum = roomPart.substring(4, 9);
            } else {
                encryptedName.append(roomPart);
            }
        }
        scanner.close();

        return new Room(sectorID, checksum, encryptedName.toString());
    }

    boolean isValid() {
        var comparator =
                Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey());

        return encryptedName
                .chars()
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .sorted(comparator)
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                .equals(checksum);
    }

    String decryptName() {
        return encryptedName
                .chars()
                .map(i -> (i - 'a' + sectorID) % 26 + 'a')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
