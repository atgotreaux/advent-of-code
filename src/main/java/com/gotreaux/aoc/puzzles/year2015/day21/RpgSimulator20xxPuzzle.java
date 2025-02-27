package com.gotreaux.aoc.puzzles.year2015.day21;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class RpgSimulator20xxPuzzle extends Puzzle {

    public RpgSimulator20xxPuzzle() {
        super(2015, 21);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        List<String> input = inputReader.getInputList();

        Boss boss = Boss.of(input);

        Collection<Player> players = new ArrayList<>();
        for (Weapon weapon : Weapon.values()) {
            for (Optional<Armor> armor : getOptionalValues(Armor.values())) {
                for (Optional<Ring> leftRing : getOptionalValues(Ring.values())) {
                    for (Optional<Ring> rightRing : getOptionalValues(Ring.values())) {
                        if (leftRing.isEmpty() || !leftRing.equals(rightRing)) {
                            players.add(new Player(100, weapon, armor, leftRing, rightRing));
                        }
                    }
                }
            }
        }

        Collection<Integer> winCosts = new ArrayList<>();
        Collection<Integer> loseCosts = new ArrayList<>();
        for (Player player : players) {
            Battle battle = new Battle(player, boss);
            if (battle.isWin()) {
                winCosts.add(player.calculateCost());
            } else {
                loseCosts.add(player.calculateCost());
            }
        }

        int minimumWinCost = winCosts.stream().min(Integer::compareTo).orElseThrow();
        int maximumLoseCost = loseCosts.stream().max(Integer::compareTo).orElseThrow();

        return new PuzzleOutput<>(minimumWinCost, maximumLoseCost);
    }

    private static <T> Collection<Optional<T>> getOptionalValues(T[] values) {
        Collection<Optional<T>> optionalValues = new ArrayList<>(values.length + 1);
        optionalValues.add(Optional.empty());
        for (T value : values) {
            optionalValues.add(Optional.of(value));
        }
        return optionalValues;
    }
}
