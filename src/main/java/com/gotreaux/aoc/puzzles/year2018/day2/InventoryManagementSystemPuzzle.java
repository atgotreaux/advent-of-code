package com.gotreaux.aoc.puzzles.year2018.day2;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class InventoryManagementSystemPuzzle extends Puzzle {

    public InventoryManagementSystemPuzzle() {
        super(2018, 2);
    }

    @Override
    public PuzzleOutput<Integer, String> solve(InputReader inputReader) throws Exception {
        var lines = inputReader.getInputList();

        var boxIdsWithTwoOfLetter = 0;
        var boxIdsWithThreeOfLetter = 0;
        var commonLettersOfCorrectBoxIds = "";

        for (var i = 0; i < lines.size(); i++) {
            var line = lines.get(i);

            var characterOccurrences =
                    line.chars().boxed().collect(groupingBy(identity(), counting()));
            if (characterOccurrences.containsValue(2L)) {
                boxIdsWithTwoOfLetter++;
            }
            if (characterOccurrences.containsValue(3L)) {
                boxIdsWithThreeOfLetter++;
            }

            for (var j = i + 1; j < lines.size(); j++) {
                var nextLine = lines.get(j);
                var difference = 0;
                var commonLetters = new StringBuilder(line.length());
                for (var k = 0; k < line.length(); k++) {
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

        var productOfOccurrences = boxIdsWithTwoOfLetter * boxIdsWithThreeOfLetter;

        return new PuzzleOutput<>(productOfOccurrences, commonLettersOfCorrectBoxIds);
    }
}
