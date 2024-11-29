package com.gotreaux.aoc.puzzles.year2018.day2;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class InventoryManagementSystemPuzzle extends Puzzle {

    public InventoryManagementSystemPuzzle() {
        super(2018, 2);
    }

    @Override
    public PuzzleOutput<Integer, String> solve(InputReader inputReader) throws Exception {
        List<String> lines = inputReader.getInputList();

        int boxIdsWithTwoOfLetter = 0;
        int boxIdsWithThreeOfLetter = 0;
        String commonLettersOfCorrectBoxIds = "";

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            Map<Integer, Long> characterOccurrences =
                    line.chars().boxed().collect(groupingBy(identity(), counting()));
            if (characterOccurrences.containsValue(2L)) {
                boxIdsWithTwoOfLetter++;
            }
            if (characterOccurrences.containsValue(3L)) {
                boxIdsWithThreeOfLetter++;
            }

            for (int j = i + 1; j < lines.size(); j++) {
                String nextLine = lines.get(j);
                int difference = 0;
                StringBuilder commonLetters = new StringBuilder(line.length());
                for (int k = 0; k < line.length(); k++) {
                    if (line.charAt(k) == nextLine.charAt(k)) {
                        commonLetters.append(line.charAt(k));
                    } else {
                        difference++;
                        if (difference > 1) {
                            break;
                        }
                    }
                }
                if (difference == 1) {
                    commonLettersOfCorrectBoxIds = commonLetters.toString();
                }
            }
        }

        int productOfOccurrences = boxIdsWithTwoOfLetter * boxIdsWithThreeOfLetter;

        return new PuzzleOutput<>(productOfOccurrences, commonLettersOfCorrectBoxIds);
    }
}
