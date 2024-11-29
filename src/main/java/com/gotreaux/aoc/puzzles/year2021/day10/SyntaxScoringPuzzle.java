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
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) throws Exception {
        List<String> input = inputReader.getInputList();

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
