package com.gotreaux.aoc.puzzles.year2019.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.graph.BFS;
import com.gotreaux.aoc.utils.graph.Edge;
import java.util.List;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class UniversalOrbitMapPuzzle extends Puzzle {

    public UniversalOrbitMapPuzzle() {
        super(2019, 6);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        Function<String, Edge> mapOrbitEdge = new MapOrbitEdgeFunction();
        List<Edge> orbits = inputReader.getInputStream().map(mapOrbitEdge).toList();

        BFS bfs = new BFS(orbits);

        int totalDirectAndIndirectOrbits =
                bfs.getDistances("COM").values().stream().mapToInt(Integer::intValue).sum();

        int minimumTransfersRequired = bfs.getDistance("YOU", "SAN") - 2;

        return new PuzzleOutput<>(totalDirectAndIndirectOrbits, minimumTransfersRequired);
    }
}
