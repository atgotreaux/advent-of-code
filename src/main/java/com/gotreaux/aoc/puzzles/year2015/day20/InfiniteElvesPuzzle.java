package com.gotreaux.aoc.puzzles.year2015.day20;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class InfiniteElvesPuzzle extends Puzzle {

    public InfiniteElvesPuzzle() {
        super(2015, 20);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        int presentTarget = Integer.parseInt(inputReader.getInputString());
        int maxHouseNumber = presentTarget / 10;

        Collection<Elf> infiniteElves =
                IntStream.rangeClosed(1, maxHouseNumber)
                        .mapToObj(i -> new Elf(i, maxHouseNumber, 10))
                        .toList();

        Collection<Elf> finiteElves =
                IntStream.rangeClosed(1, maxHouseNumber).mapToObj(i -> new Elf(i, 50, 11)).toList();

        Delivery infiniteDelivery = new Delivery(infiniteElves, presentTarget);
        Delivery finiteDelivery = new Delivery(finiteElves, presentTarget);

        return new PuzzleOutput<>(
                infiniteDelivery.getMinimumHouseNumber(), finiteDelivery.getMinimumHouseNumber());
    }
}
