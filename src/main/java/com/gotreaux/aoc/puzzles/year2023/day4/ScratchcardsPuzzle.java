package com.gotreaux.aoc.puzzles.year2023.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class ScratchcardsPuzzle extends Puzzle {

    private static final Pattern CARD_LINE = Pattern.compile(": ");
    private static final Pattern ANY_WHITESPACE = Pattern.compile("\\s+");
    private static final Pattern WINNERS_NUMBER_DELIM = Pattern.compile("\\s+\\|\\s+");

    public ScratchcardsPuzzle() {
        super(2023, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        Collection<String> input = inputReader.getInputList();
        var lineCount = input.size();

        var scratchcardPoints = 0;
        Map<Integer, Integer> totalScratchcardMapping = new HashMap<>(lineCount);

        for (var line : input) {
            var cardLine = CARD_LINE.split(line);
            var lineNumber = cardLine[0];
            var labelAndNumber = ANY_WHITESPACE.split(lineNumber);
            var number = Integer.parseInt(labelAndNumber[1]);
            totalScratchcardMapping.merge(number, 1, Integer::sum);

            var winnersAndNumbers = WINNERS_NUMBER_DELIM.split(cardLine[1]);
            var winners = winnersAndNumbers[0];
            var numbers = winnersAndNumbers[1];

            Collection<String> winnerList = List.of(ANY_WHITESPACE.split(winners));
            Collection<String> numberList =
                    Stream.of(ANY_WHITESPACE.split(numbers)).filter(winnerList::contains).toList();

            if (!numberList.isEmpty()) {
                scratchcardPoints += 1 << (numberList.size() - 1);
            }

            for (var i = 0; i < numberList.size(); i++) {
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
