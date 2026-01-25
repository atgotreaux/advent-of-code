package com.gotreaux.aoc.puzzles.year2015.day21;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class RpgSimulator20xxPuzzle extends Puzzle {

    public RpgSimulator20xxPuzzle() {
        super(2015, 21);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var boss = Boss.of(input);

        Collection<Player> players = new ArrayList<>();
        for (var weapon : Weapon.values()) {
            for (var armor : CollectionUtils.optionalValues(Armor.values())) {
                for (var leftRing : CollectionUtils.optionalValues(Ring.values())) {
                    for (var rightRing : CollectionUtils.optionalValues(Ring.values())) {
                        if (leftRing.isEmpty() || !leftRing.equals(rightRing)) {
                            players.add(new Player(100, weapon, armor, leftRing, rightRing));
                        }
                    }
                }
            }
        }

        Collection<Integer> winCosts = new ArrayList<>();
        Collection<Integer> loseCosts = new ArrayList<>();
        for (var player : players) {
            var battle = new Battle(player, boss);
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
}
