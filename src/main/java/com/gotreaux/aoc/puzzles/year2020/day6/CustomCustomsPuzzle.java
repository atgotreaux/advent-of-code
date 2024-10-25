package com.gotreaux.aoc.puzzles.year2020.day6;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class CustomCustomsPuzzle extends Puzzle {

    public CustomCustomsPuzzle() {
        super(2020, 6);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException {
        Collection<PassengerGroup> passengerGroups = new ArrayList<>();

        Collection<String> passengerDeclarations = new ArrayList<>();
        for (String line : inputProvider.getInputList()) {
            if (line.isBlank()) {
                passengerGroups.add(new PassengerGroup(passengerDeclarations));
                passengerDeclarations = new ArrayList<>();
            } else {
                passengerDeclarations.add(line);
            }
        }
        passengerGroups.add(new PassengerGroup(passengerDeclarations));

        long sumOfAnyoneDeclared =
                passengerGroups.stream().mapToLong(PassengerGroup::anyoneDeclared).sum();

        long sumOfEveryoneDeclared =
                passengerGroups.stream().mapToLong(PassengerGroup::everyoneDeclared).sum();

        return new PuzzleOutput<>(sumOfAnyoneDeclared, sumOfEveryoneDeclared);
    }
}
