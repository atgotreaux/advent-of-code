package com.gotreaux.twentythree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        System.out.println(day4.scratchcardPoints(path));
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
}
