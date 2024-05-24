package com.gotreaux.aoc.puzzles.year2017.day7;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

@ShellPuzzle(year = 2017, day = 7, title = "Recursive Circus")
public class RecursiveCircusPuzzle extends Puzzle {
    private static final Pattern INPUT_DELIMS = Pattern.compile("[(),]");

    public RecursiveCircusPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<String, Integer> solve()
            throws IOException, URISyntaxException, NumberFormatException {
        Collection<Program> programs = new ArrayList<>();
        Collection<Tower> towers = new ArrayList<>();

        for (String line : getInputProvider().getInputList()) {
            List<String> parts = List.of(INPUT_DELIMS.matcher(line).replaceAll("").split(" "));

            Program program = new Program(parts.getFirst(), Integer.parseInt(parts.get(1)));
            programs.add(program);

            if (parts.size() > 2) {
                towers.add(new Tower(program.name(), parts.subList(3, parts.size())));
            }
        }

        String nameOfBottomProgram =
                programs.stream()
                        .filter(
                                program ->
                                        towers.stream()
                                                .noneMatch(
                                                        tower -> tower.isHolding(program.name())))
                        .findFirst()
                        .orElseThrow()
                        .name();

        return new PuzzleOutput<>(nameOfBottomProgram, 0);
    }
}
