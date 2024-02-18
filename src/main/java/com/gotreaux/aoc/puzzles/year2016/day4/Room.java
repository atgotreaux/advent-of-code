package com.gotreaux.aoc.puzzles.year2016.day4;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.Map;

record Room(int sectorID, String checksum, String encryptedName) {
    boolean isValid() {
        Comparator<Map.Entry<Integer, Long>> comparator =
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
