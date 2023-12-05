package com.gotreaux.twentythree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Day4 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = Day1.class.getClassLoader().getResource("com/gotreaux/twentythree/4.txt");
        if (resource == null) {
            System.out.println("Could not find input file");
            return;
        }

        Path path = Path.of(resource.toURI());

        Day4 day4 = new Day4();

        System.out.println("Part 1: " + day4.scratchcardPoints(path));
        System.out.println("Part 2: " + day4.totalScratchcards(path));
    }

    public int scratchcardPoints(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.mapToInt(line -> {
                String cardLine = line.split(": ")[1];
                String[] winnersAndNumbers = cardLine.split("\\s+\\|\\s+");

                String winners = winnersAndNumbers[0];
                String numbers = winnersAndNumbers[1];

                List<String> winnerList = new ArrayList<>(Arrays.asList(winners.split("\\s+")));
                List<String> numberList = new ArrayList<>(Arrays.asList(numbers.split("\\s+")));

                numberList.retainAll(winnerList);

                if (!numberList.isEmpty()) {
                    return (int) Math.pow(2, numberList.size() - 1);
                }

                return 0;
            }).sum();
        }
    }

    public int totalScratchcards(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);

        Map<Integer, Integer> totalScratchcards = new HashMap<>();

        for (String line : lines) {
            String[] cardLine = line.split(": ");

            String lineNumber = cardLine[0];
            String[] labelAndNumber = lineNumber.split("\\s+");
            int number = Integer.parseInt(labelAndNumber[1]);
            totalScratchcards.merge(number, 1, Integer::sum);

            String[] winnersAndNumbers = cardLine[1].split("\\s+\\|\\s+");
            String winners = winnersAndNumbers[0];
            String numbers = winnersAndNumbers[1];

            List<String> winnerList = new ArrayList<>(Arrays.asList(winners.split("\\s+")));
            List<String> numberList = new ArrayList<>(Arrays.asList(numbers.split("\\s+")));

            numberList.retainAll(winnerList);
            for (int i = 0; i < numberList.size(); i++) {
                if (number < lines.size()) {
                    totalScratchcards.merge(number + i + 1, totalScratchcards.get(number), Integer::sum);
                }
            }
        }

        return totalScratchcards.values().stream().reduce(0, Integer::sum);
    }
}
