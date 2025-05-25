package com.gotreaux.aoc.puzzles.year2022.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class NoDeviceSpacePuzzle extends Puzzle {

    public NoDeviceSpacePuzzle() {
        super(2022, 7);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var directory = new Directory("/");

        for (var line : inputReader.getInputList()) {
            if (Character.isDigit(line.charAt(0))) {
                var scanner = new Scanner(line);
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
        var rootSize = directory.size();

        var sumOfSmallDirectories =
                directory.getDirectories().stream()
                        .mapToInt(Directory::size)
                        .filter(size -> size < 100000)
                        .sum();

        var smallestDirectoryToFree =
                directory.getDirectories().stream()
                        .mapToInt(Directory::size)
                        .filter(size -> size > rootSize - 40000000)
                        .min()
                        .orElseThrow();

        return new PuzzleOutput<>(sumOfSmallDirectories, smallestDirectoryToFree);
    }
}
