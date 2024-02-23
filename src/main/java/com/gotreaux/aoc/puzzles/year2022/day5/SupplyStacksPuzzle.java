package com.gotreaux.aoc.puzzles.year2022.day5;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@ShellPuzzle(year = 2022, day = 5, title = "Supply Stacks")
public class SupplyStacksPuzzle extends Puzzle {
    public SupplyStacksPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<String, String> solve()
            throws IOException, URISyntaxException, NumberFormatException {
        Deque<RearrangeProcedure> procedures = new ArrayDeque<>();
        Map<Integer, Deque<Character>> stacks = new HashMap<>();

        List<String> input = getInputProvider().getInputList();
        for (int lineIndex = input.size() - 1; lineIndex >= 0; lineIndex--) {
            String line = input.get(lineIndex);
            if (line.startsWith("move")) {
                String[] procedureParts = line.split(" ");

                int operationCount = Integer.parseInt(procedureParts[1]);
                int from = Integer.parseInt(procedureParts[3]);
                int to = Integer.parseInt(procedureParts[5]);

                procedures.push(new RearrangeProcedure(operationCount, from, to));
            } else if (line.matches("^(\\s+\\d\\s*)+$")) {
                Scanner scanner = new Scanner(line);
                while (scanner.hasNextInt()) {
                    stacks.put(scanner.nextInt(), new ArrayDeque<>());
                }
                scanner.close();
            } else if (line.matches("^(\\s*\\[[A-Z]]\\s*)+$")) {
                int stackIndex = 1;
                for (Map.Entry<Integer, Deque<Character>> entry : stacks.entrySet()) {
                    char c = line.charAt(stackIndex);
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

        for (RearrangeProcedure procedure : procedures) {
            crateMover9000.operate(procedure);
            crateMover9001.operate(procedure);
        }

        return new PuzzleOutput<>(crateMover9000.getMessage(), crateMover9001.getMessage());
    }
}
