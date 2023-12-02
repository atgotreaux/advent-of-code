package com.gotreaux.twentythree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day1 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = Day1.class.getClassLoader().getResource("com/gotreaux/twentythree/1.txt");
        if (resource == null) {
            System.out.println("Could not find input file");
            return;
        }

        Path path = Path.of(resource.toURI());

        Day1 day1 = new Day1();
        System.out.println(day1.calibrationValue(path));
    }

    public int calibrationValue(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

            return lines.mapToInt(line -> {
                String firstDigit = null;
                String lastDigital = null;
                int substringIndex = 0;
                for (Character c : line.toCharArray()) {
                    String substring = line.substring(substringIndex);
                    for (String word : words) {
                        if (substring.startsWith(word)) {
                            c = String.valueOf(words.indexOf(word) + 1).charAt(0);
                            break;
                        }
                    }
                    if (Character.isDigit(c)) {
                        if (firstDigit == null) {
                            firstDigit = String.valueOf(c);
                        }
                        lastDigital = String.valueOf(c);
                    }
                    substringIndex++;
                }

                return Integer.parseInt(firstDigit + lastDigital);
            }).sum();
        }
    }
}
