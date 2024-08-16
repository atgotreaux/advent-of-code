package com.gotreaux.aoc.puzzles.year2021.day10;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

@ShellPuzzle(year = 2021, day = 10, title = "Syntax Scoring")
public class SyntaxScoringPuzzle extends Puzzle {
    public SyntaxScoringPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve() throws IOException, URISyntaxException {
        List<String> input = getInputProvider().getInputList();

        int totalSyntaxErrorScore = 0;
        List<Long> completionScores = new ArrayList<>();
        for (String line : input) {
            Deque<ChunkOpener> chunkOpeners = new ArrayDeque<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                ChunkOpener chunkOpener = ChunkOpener.fromLabel(c);
                if (chunkOpener != null) {
                    chunkOpeners.push(chunkOpener);
                }

                ChunkCloser chunkCloser = ChunkCloser.fromLabel(c);
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
                for (ChunkOpener chunkOpener : chunkOpeners) {
                    ChunkCloser chunkCloser = chunkOpener.getCloser();
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
