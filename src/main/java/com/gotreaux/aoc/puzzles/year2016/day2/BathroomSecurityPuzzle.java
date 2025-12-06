package com.gotreaux.aoc.puzzles.year2016.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.RelativeDirection;
import com.gotreaux.aoc.utils.enums.EnumUtils;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BathroomSecurityPuzzle extends Puzzle {

    public BathroomSecurityPuzzle() {
        super(2016, 2);
    }

    @Override
    public PuzzleOutput<String, String> solve(InputReader inputReader) {
        var imaginedKey = new Key("5", "2", "8", "4", "6");
        Collection<Key> imaginedKeys =
                List.of(
                        new Key("1", "1", "4", "1", "2"),
                        new Key("2", "2", "5", "1", "3"),
                        new Key("3", "3", "6", "2", "3"),
                        new Key("4", "1", "7", "4", "6"),
                        imaginedKey,
                        new Key("6", "3", "9", "5", "6"),
                        new Key("7", "4", "7", "7", "8"),
                        new Key("8", "5", "8", "7", "9"),
                        new Key("9", "6", "9", "8", "9"));
        var imaginedKeypad = new Keypad(imaginedKeys);

        var actualKey = new Key("5", "5", "5", "5", "6");
        Collection<Key> actualKeys =
                List.of(
                        new Key("1", "1", "3", "1", "1"),
                        new Key("2", "2", "6", "2", "3"),
                        new Key("3", "1", "7", "2", "4"),
                        new Key("4", "4", "8", "3", "4"),
                        actualKey,
                        new Key("6", "2", "A", "5", "7"),
                        new Key("7", "3", "B", "6", "8"),
                        new Key("8", "4", "C", "7", "9"),
                        new Key("9", "9", "9", "8", "9"),
                        new Key("A", "6", "A", "A", "B"),
                        new Key("B", "7", "D", "A", "C"),
                        new Key("C", "8", "C", "B", "C"),
                        new Key("D", "B", "D", "D", "D"));
        var actualKeypad = new Keypad(actualKeys);

        Collection<String> input = inputReader.getInputList();
        var imaginedBathroomCode = new StringBuilder(input.size());
        var actualBathroomCode = new StringBuilder(input.size());

        for (var line : input) {
            for (var i = 0; i < line.length(); i++) {
                var directionLabel = line.charAt(i);
                var direction = EnumUtils.of(RelativeDirection.class, directionLabel);

                imaginedKey = imaginedKeypad.move(imaginedKey, direction);
                actualKey = actualKeypad.move(actualKey, direction);
            }
            imaginedBathroomCode.append(imaginedKey.label());
            actualBathroomCode.append(actualKey.label());
        }

        return new PuzzleOutput<>(imaginedBathroomCode.toString(), actualBathroomCode.toString());
    }
}
