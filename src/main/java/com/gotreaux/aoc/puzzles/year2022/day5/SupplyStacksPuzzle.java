package com.gotreaux.aoc.puzzles.year2022.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class SupplyStacksPuzzle extends Puzzle {

    private static final Pattern STACK_PATTERN = Pattern.compile("^(\\s+\\d\\s*)+$");
    private static final Pattern CRATE_PATTERN = Pattern.compile("^(\\s*\\[[A-Z]]\\s*)+$");

    public SupplyStacksPuzzle() {
        super(2022, 5);
    }

    @Override
    public PuzzleOutput<String, String> solve(InputReader inputReader) throws Exception {
        Deque<RearrangeProcedure> procedures = new ArrayDeque<>();
        Map<Integer, Deque<Character>> stacks = new HashMap<>();

        var input = inputReader.getInputList();
        for (var lineIndex = input.size() - 1; lineIndex >= 0; lineIndex--) {
            var line = input.get(lineIndex);
            if (line.startsWith("move")) {
                var procedureParts = line.split(" ");

                var operationCount = Integer.parseInt(procedureParts[1]);
                var from = Integer.parseInt(procedureParts[3]);
                var to = Integer.parseInt(procedureParts[5]);

                procedures.push(new RearrangeProcedure(operationCount, from, to));
            } else if (STACK_PATTERN.matcher(line).matches()) {
                var scanner = new Scanner(line);
                while (scanner.hasNextInt()) {
                    stacks.put(scanner.nextInt(), new ArrayDeque<>());
                }
                scanner.close();
            } else if (CRATE_PATTERN.matcher(line).matches()) {
                var stackIndex = 1;
                for (var entry : stacks.entrySet()) {
                    var c = line.charAt(stackIndex);
                    if (Character.isLetter(c)) {
                        stacks.get(entry.getKey()).push(c);
                    }

                    stackIndex += 4;
                    if (stackIndex >= line.length()) {
                        break;
                    }
                }
            }
        }

        CrateMover crateMover9000 = new CrateMover9000(stacks);
        CrateMover crateMover9001 = new CrateMover9001(stacks);

        for (var procedure : procedures) {
            crateMover9000.operate(procedure);
            crateMover9001.operate(procedure);
        }

        return new PuzzleOutput<>(crateMover9000.getMessage(), crateMover9001.getMessage());
    }
}
