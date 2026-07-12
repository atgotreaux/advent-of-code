package com.gotreaux.aoc.service;

import com.gotreaux.aoc.exceptions.NoSuchPuzzleException;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PuzzleService {

    private final List<Puzzle> puzzles;
    private final Map<PuzzleKey, Puzzle> puzzleMap;

    PuzzleService(List<Puzzle> puzzles) {
        this.puzzles = List.copyOf(puzzles);
        puzzleMap =
                puzzles.stream()
                        .collect(Collectors.toUnmodifiableMap(PuzzleKey::of, Function.identity()));
    }

    public Puzzle getPuzzle(int year, int day) {
        var key = new PuzzleKey(year, day);

        return Optional.ofNullable(puzzleMap.get(key))
                .orElseThrow(() -> new NoSuchPuzzleException(year, day));
    }

    public Puzzle getRandomPuzzle() {
        if (puzzleMap.isEmpty()) {
            throw new IllegalStateException("No Puzzle beans were discovered.");
        }
        return puzzles.get(ThreadLocalRandom.current().nextInt(puzzles.size()));
    }
}
