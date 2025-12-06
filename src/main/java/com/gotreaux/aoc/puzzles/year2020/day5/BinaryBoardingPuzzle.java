package com.gotreaux.aoc.puzzles.year2020.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.enums.EnumUtils;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class BinaryBoardingPuzzle extends Puzzle {

    public BinaryBoardingPuzzle() {
        super(2020, 5);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var seatIDs =
                inputReader
                        .getInputStream()
                        .mapToInt(BinaryBoardingPuzzle::getSeatID)
                        .boxed()
                        .sorted()
                        .toList();

        int highestSeatID = seatIDs.getLast();

        var assignedSeatID =
                IntStream.range(0, seatIDs.size() - 1)
                        .filter(i -> seatIDs.get(i + 1) == seatIDs.get(i) + 2)
                        .map(i -> seatIDs.get(i) + 1)
                        .findFirst()
                        .orElse(Integer.MAX_VALUE);

        return new PuzzleOutput<>(highestSeatID, assignedSeatID);
    }

    static int getSeatID(CharSequence sequence) {
        var rowHigh = 127;
        var rowLow = 0;
        var colHigh = 7;
        var colLow = 0;

        for (var i = 0; i < sequence.length(); i++) {
            var region = EnumUtils.of(Region.class, sequence.charAt(i));
            switch (region) {
                case FRONT -> rowHigh = (rowHigh + rowLow) / 2;
                case BACK -> rowLow = (rowHigh + rowLow + 1) / 2;
                case LEFT -> colHigh = (colHigh + colLow) / 2;
                case RIGHT -> colLow = (colHigh + colLow + 1) / 2;
            }
        }

        return (rowHigh << 3) + colHigh;
    }
}
