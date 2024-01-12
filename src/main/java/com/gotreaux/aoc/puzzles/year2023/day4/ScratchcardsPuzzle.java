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

@ShellPuzzle(year = 2023, day = 4, title = "Scratchcards")
public class ScratchcardsPuzzle extends Puzzle {

    public ScratchcardsPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        List<String> input = getInputProvider().getInputList();
        int lineCount = input.size();

        int scratchcardPoints = 0;
        Map<Integer, Integer> totalScratchcardMapping = new HashMap<>();

        for (String line : input) {
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
                scratchcardPoints += (int) Math.pow(2, numberList.size() - 1);
            }

            for (int i = 0; i < numberList.size(); i++) {
                if (number < lineCount) {
                    totalScratchcardMapping.merge(
                            number + i + 1, totalScratchcardMapping.get(number), Integer::sum);
                }
            }
        }

        int totalScratchcards = totalScratchcardMapping.values().stream().reduce(0, Integer::sum);

        return new PuzzleOutput<>(scratchcardPoints, totalScratchcards);
    }
}
