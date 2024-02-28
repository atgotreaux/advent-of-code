package com.gotreaux.aoc.puzzles.year2022.day7;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;

@ShellPuzzle(year = 2022, day = 7, title = "No Space Left On Device")
public class NoDeviceSpacePuzzle extends Puzzle {
    public NoDeviceSpacePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        Directory directory = new Directory("/");

        for (String line : getInputProvider().getInputList()) {
            if (Character.isDigit(line.charAt(0))) {
                Scanner scanner = new Scanner(line);
                directory.addFile(new File(scanner.nextInt(), scanner.next()));
                scanner.close();
            } else if (line.startsWith("dir")) {
                directory.addDirectory(new Directory(line.substring(4), directory));
            } else if (line.startsWith("$ cd")) {
                if (line.equals("$ cd ..")) {
                    directory = directory.getParent();
                } else if (line.equals("$ cd /")) {
                    directory = directory.getRoot();
                } else {
                    directory = directory.getDirectory(line.substring(5));
                }
            }
        }

        directory = directory.getRoot();
        int rootSize = directory.size();

        int sumOfSmallDirectories =
                directory.getDirectories().stream()
                        .mapToInt(Directory::size)
                        .filter(size -> size < 100000)
                        .sum();

        int smallestDirectoryToFree =
                directory.getDirectories().stream()
                        .mapToInt(Directory::size)
                        .filter(size -> size > rootSize - 40000000)
                        .min()
                        .orElseThrow();

        return new PuzzleOutput<>(sumOfSmallDirectories, smallestDirectoryToFree);
    }
}
