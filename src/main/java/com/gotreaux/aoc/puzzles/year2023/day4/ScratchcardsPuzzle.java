package com.gotreaux.aoc.puzzles.year2023.day4;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@ShellPuzzle(year = 2023, day = 4, title = "Scratchcards")
public class ScratchcardsPuzzle extends Puzzle {

    private long scratchcardPoints;
    private long totalScratchcards;

    public ScratchcardsPuzzle(InputProvider inputProvider) throws Exception {
        super(inputProvider);

        prepare();
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

    private void prepare() throws Exception {
        long lineCount;
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lineCount = lines.count();
        }
        Map<Integer, Integer> totalScratchcardMapping = new HashMap<>();

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(
                    line -> {
                        String[] cardLine = line.split(": ");
                        String lineNumber = cardLine[0];
                        String[] labelAndNumber = lineNumber.split("\\s+");
                        int number = Integer.parseInt(labelAndNumber[1]);
                        totalScratchcardMapping.merge(number, 1, Integer::sum);

                        String[] winnersAndNumbers = cardLine[1].split("\\s+\\|\\s+");
                        String winners = winnersAndNumbers[0];
                        String numbers = winnersAndNumbers[1];

                        List<String> winnerList =
                                new ArrayList<>(Arrays.asList(winners.split("\\s+")));
                        List<String> numberList =
                                new ArrayList<>(Arrays.asList(numbers.split("\\s+")));

                        numberList.retainAll(winnerList);

                        if (!numberList.isEmpty()) {
                            scratchcardPoints += (long) Math.pow(2, numberList.size() - 1);
                        }

                        for (int i = 0; i < numberList.size(); i++) {
                            if (number < lineCount) {
                                totalScratchcardMapping.merge(
                                        number + i + 1,
                                        totalScratchcardMapping.get(number),
                                        Integer::sum);
                            }
                        }
                    });
        }

        totalScratchcards = totalScratchcardMapping.values().stream().reduce(0, Integer::sum);
    }

    public Long getPartOne() {
        return scratchcardPoints;
    }

    public Long getPartTwo() {
        return totalScratchcards;
    }
}
