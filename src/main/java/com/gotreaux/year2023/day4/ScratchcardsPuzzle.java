package com.gotreaux.year2023.day4;

import com.gotreaux.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ScratchcardsPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        puzzle.solve();
    }

    private long scratchcardPoints;
    private long totalScratchcards;

    public ScratchcardsPuzzle() throws Exception {
        super();

        prepare();
    }

    private void prepare() throws Exception {
        long lineCount;
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lineCount = lines.count();
        }
        Map<Integer, Integer> totalScratchcardMapping = new HashMap<>();

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                String[] cardLine = line.split(": ");
                String lineNumber = cardLine[0];
                String[] labelAndNumber = lineNumber.split("\\s+");
                int number = Integer.parseInt(labelAndNumber[1]);
                totalScratchcardMapping.merge(number, 1, Integer::sum);

                String[] winnersAndNumbers = cardLine[1].split("\\s+\\|\\s+");
                String winners = winnersAndNumbers[0];
                String numbers = winnersAndNumbers[1];

                List<String> winnerList = new ArrayList<>(Arrays.asList(winners.split("\\s+")));
                List<String> numberList = new ArrayList<>(Arrays.asList(numbers.split("\\s+")));

                numberList.retainAll(winnerList);

                if (!numberList.isEmpty()) {
                    scratchcardPoints += (long) Math.pow(2, numberList.size() - 1);
                }

                for (int i = 0; i < numberList.size(); i++) {
                    if (number < lineCount) {
                        totalScratchcardMapping.merge(number + i + 1, totalScratchcardMapping.get(number), Integer::sum);
                    }
                }
            });
        }

        totalScratchcards = totalScratchcardMapping.values()
                .stream()
                .reduce(0, Integer::sum);
    }

    @Override
    public Long getPartOne() {
        return scratchcardPoints;
    }

    @Override
    public Long getPartTwo() {
        return totalScratchcards;
    }
}
