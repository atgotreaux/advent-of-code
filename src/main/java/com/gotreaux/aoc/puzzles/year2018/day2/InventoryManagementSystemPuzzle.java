package com.gotreaux.aoc.puzzles.year2018.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ShellPuzzle(year = 2018, day = 2, title = "Inventory Management System")
public class InventoryManagementSystemPuzzle extends Puzzle {

    public InventoryManagementSystemPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, String> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

    public Long getPartOne() throws Exception {
        long boxIdsWithTwoOfLetter = 0L;
        long boxIdsWithThreeOfLetter = 0L;

        for (String line : getInputProvider().getInputList()) {
            Map<Character, Long> characterOccurences = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                characterOccurences.merge(line.charAt(i), 1L, Long::sum);
            }

            if (characterOccurences.containsValue(2L)) {
                boxIdsWithTwoOfLetter++;
            }
            if (characterOccurences.containsValue(3L)) {
                boxIdsWithThreeOfLetter++;
            }
        }

        return boxIdsWithTwoOfLetter * boxIdsWithThreeOfLetter;
    }

    public String getPartTwo() throws Exception {
        List<String> lines = getInputProvider().getInputList();
        for (int i = 0; i < lines.size(); i++) {
            String first = lines.get(i);
            for (int j = i + 1; j < lines.size(); j++) {
                String second = lines.get(j);
                int difference = 0;
                StringBuilder commonLetters = new StringBuilder();
                for (int k = 0; k < first.length(); k++) {
                    if (first.charAt(k) == second.charAt(k)) {
                        commonLetters.append(first.charAt(k));
                    } else {
                        difference++;
                        if (difference > 1) {
                            break;
                        }
                    }
                }
                if (difference == 1) {
                    return commonLetters.toString();
                }
            }
        }

        throw new RuntimeException("Could not find boxes with ID difference of 1!");
    }
}
