package com.gotreaux.aoc.puzzles.year2015.day13;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class DinnerTablePuzzle extends Puzzle {

    public DinnerTablePuzzle() {
        super(2015, 13);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        Collection<Arrangement> arrangements =
                inputReader.getInputStream().map(Arrangement::of).toList();

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
}
