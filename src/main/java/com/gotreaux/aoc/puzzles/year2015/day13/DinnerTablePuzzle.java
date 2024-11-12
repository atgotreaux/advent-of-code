package com.gotreaux.aoc.puzzles.year2015.day13;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class DinnerTablePuzzle extends Puzzle {

    public DinnerTablePuzzle() {
        super(2015, 13);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException, NoSuchElementException {
        Collection<Arrangement> arrangements =
                inputReader.getInputStream().map(DinnerTablePuzzle::parseArrangement).toList();

        Table guestTable = new Table(arrangements);

        Collection<Arrangement> myArrangements =
                guestTable.getRelatives().stream()
                        .flatMap(
                                relative ->
                                        Stream.of(
                                                new Arrangement("Me", relative, 0),
                                                new Arrangement(relative, "Me", 0)))
                        .toList();

        Table myTable =
                new Table(Stream.concat(arrangements.stream(), myArrangements.stream()).toList());

        return new PuzzleOutput<>(
                guestTable.getOptimalArrangement(), myTable.getOptimalArrangement());
    }

    static Arrangement parseArrangement(String line) {
        String[] arrangementParts = line.split(" ");

        String relative = arrangementParts[0];
        String neighbor = arrangementParts[10].replace(".", "");

        int happiness = Integer.parseInt(arrangementParts[3]);
        if (arrangementParts[2].equals("lose")) {
            happiness = -happiness;
        }

        return new Arrangement(relative, neighbor, happiness);
    }
}
