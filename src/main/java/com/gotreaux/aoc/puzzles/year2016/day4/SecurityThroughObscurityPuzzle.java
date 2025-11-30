package com.gotreaux.aoc.puzzles.year2016.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class SecurityThroughObscurityPuzzle extends Puzzle {

    public SecurityThroughObscurityPuzzle() {
        super(2016, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        Collection<Room> rooms = inputReader.getInputStream().map(Room::of).toList();

        var sumOfRealRooms = rooms.stream().filter(Room::isValid).mapToInt(Room::sectorID).sum();

        var northPoleSectorID =
                rooms.stream()
                        .filter(room -> "northpoleobjectstorage".equals(room.decryptName()))
                        .mapToInt(Room::sectorID)
                        .findFirst()
                        .orElse(Integer.MAX_VALUE);

        return new PuzzleOutput<>(sumOfRealRooms, northPoleSectorID);
    }
}
