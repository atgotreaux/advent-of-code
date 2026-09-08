package com.gotreaux.aoc.puzzles.year2025.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.collection.CollectionUtils;
import com.gotreaux.aoc.utils.graph.DisjointSet;
import com.gotreaux.aoc.utils.graph.edge.WeightedEdge;
import java.util.Comparator;
import org.springframework.stereotype.Component;

@Component
public class PlaygroundPuzzle extends Puzzle {

    private static final int CONNECTIONS = 1000;
    private static final int LARGEST_CIRCUITS = 3;

    public PlaygroundPuzzle() {
        super(2025, 8);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) {
        var junctionBoxes = inputReader.getInputStream().map(JunctionBox::of).toList();

        var connections =
                CollectionUtils.pairs(junctionBoxes).stream()
                        .map(
                                pair ->
                                        WeightedEdge.of(
                                                pair.first(),
                                                pair.second(),
                                                JunctionBox::distanceTo))
                        .sorted()
                        .toList();

        var circuits = new DisjointSet<>(junctionBoxes);
        var junctionBoxCount = junctionBoxes.size();
        var connectionCount = junctionBoxCount < CONNECTIONS ? junctionBoxCount / 2 : CONNECTIONS;

        connections.stream().limit(connectionCount).forEach(circuits::union);

        var productOfLargestCircuits =
                circuits.getRanks().stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(LARGEST_CIRCUITS)
                        .reduce(1, Math::multiplyExact);

        var lastConnection =
                connections.stream()
                        .skip(connectionCount)
                        .filter(edge -> circuits.union(edge) && circuits.getRankCount() == 1)
                        .findFirst()
                        .orElseThrow();

        var productOfLastX = Math.multiplyFull(lastConnection.from().x(), lastConnection.to().x());

        return new PuzzleOutput<>(productOfLargestCircuits, productOfLastX);
    }
}
