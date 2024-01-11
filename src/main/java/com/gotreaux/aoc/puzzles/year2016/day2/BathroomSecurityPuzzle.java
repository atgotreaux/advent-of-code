package com.gotreaux.aoc.puzzles.year2016.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;

@ShellPuzzle(year = 2016, day = 2, title = "Bathroom Security")
public class BathroomSecurityPuzzle extends Puzzle {

    public BathroomSecurityPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<String, String> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

    public String getPartOne() throws Exception {
        List<Key> keys = new ArrayList<>();
        Key currentKey = new Key("5", "2", "8", "4", "6");
        keys.add(new Key("1", "1", "4", "1", "2"));
        keys.add(new Key("2", "2", "5", "1", "3"));
        keys.add(new Key("3", "3", "6", "2", "3"));
        keys.add(new Key("4", "1", "7", "4", "6"));
        keys.add(currentKey);
        keys.add(new Key("6", "3", "9", "5", "6"));
        keys.add(new Key("7", "4", "7", "7", "8"));
        keys.add(new Key("8", "5", "8", "7", "9"));
        keys.add(new Key("9", "6", "9", "8", "9"));

        Keypad keypad = new Keypad(keys);

        StringBuilder bathroomCode = new StringBuilder();

        for (String line : getInputProvider().getInputList()) {
            for (int i = 0; i < line.length(); i++) {
                char instructionLabel = line.charAt(i);
                Instruction instruction = Instruction.fromLabel(instructionLabel);
                currentKey = keypad.move(currentKey, instruction);
            }
            bathroomCode.append(currentKey.label());
        }
        return bathroomCode.toString();
    }

    public String getPartTwo() throws Exception {
        List<Key> keys = new ArrayList<>();
        Key currentKey = new Key("5", "5", "5", "5", "6");
        keys.add(new Key("1", "1", "3", "1", "1"));
        keys.add(new Key("2", "2", "6", "2", "3"));
        keys.add(new Key("3", "1", "7", "2", "4"));
        keys.add(new Key("4", "4", "8", "3", "4"));
        keys.add(currentKey);
        keys.add(new Key("6", "2", "A", "5", "7"));
        keys.add(new Key("7", "3", "B", "6", "8"));
        keys.add(new Key("8", "4", "C", "7", "9"));
        keys.add(new Key("9", "9", "9", "8", "9"));
        keys.add(new Key("A", "6", "A", "A", "B"));
        keys.add(new Key("B", "7", "D", "A", "C"));
        keys.add(new Key("C", "8", "C", "B", "C"));
        keys.add(new Key("D", "B", "D", "D", "D"));

        Keypad keypad = new Keypad(keys);

        StringBuilder bathroomCode = new StringBuilder();

        for (String line : getInputProvider().getInputList()) {
            for (int i = 0; i < line.length(); i++) {
                char instructionLabel = line.charAt(i);
                Instruction instruction = Instruction.fromLabel(instructionLabel);
                currentKey = keypad.move(currentKey, instruction);
            }
            bathroomCode.append(currentKey.label());
        }
        return bathroomCode.toString();
    }
}
