package com.gotreaux.aoc.puzzles.year2025.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class LobbyPuzzle extends Puzzle {

    public LobbyPuzzle() {
        super(2025, 3);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var batteryBanks = inputReader.getInputStream().map(BatteryBank::of).toList();

        var sumOfTwoBatteryMaxJoltage =
                batteryBanks.stream()
                        .mapToLong(batteryBank -> batteryBank.getMaximumOutputJoltage(2))
                        .sum();

        var sumOfTwelveBatteryMaxJoltage =
                batteryBanks.stream()
                        .mapToLong(batteryBank -> batteryBank.getMaximumOutputJoltage(12))
                        .sum();

        return new PuzzleOutput<>(sumOfTwoBatteryMaxJoltage, sumOfTwelveBatteryMaxJoltage);
    }
}
