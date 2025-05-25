package com.gotreaux.aoc.puzzles.year2021.day10;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SyntaxScoringPuzzle extends Puzzle {

    public SyntaxScoringPuzzle() {
        super(2021, 10);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var totalSyntaxErrorScore = 0;
        List<Long> completionScores = new ArrayList<>();
        for (var line : input) {
            Deque<ChunkOpener> chunkOpeners = new ArrayDeque<>();
            for (var i = 0; i < line.length(); i++) {
                var c = line.charAt(i);

                var chunkOpener = ChunkOpener.of(c);
                if (chunkOpener != null) {
                    chunkOpeners.push(chunkOpener);
                }

                var chunkCloser = ChunkCloser.of(c);
                if (chunkCloser != null) {
                    chunkOpener = chunkOpeners.pop();
                    if (!chunkOpener.matches(chunkCloser)) {
                        totalSyntaxErrorScore += chunkCloser.getErrorScore();
                        chunkOpeners.clear();
                        break;
                    }
                }
            }

            if (!chunkOpeners.isEmpty()) {
                long completionScore = 0;
                for (var chunkOpener : chunkOpeners) {
                    var chunkCloser = chunkOpener.getCloser();
                    completionScore = (completionScore * 5) + chunkCloser.getAutoCompleteScore();
                }
                completionScores.add(completionScore);
            }
        }

        Collections.sort(completionScores);
        long middleCompletionScore = completionScores.get(completionScores.size() / 2);

        return new PuzzleOutput<>(totalSyntaxErrorScore, middleCompletionScore);
    }
}
