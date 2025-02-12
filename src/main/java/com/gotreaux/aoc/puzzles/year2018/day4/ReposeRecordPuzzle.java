package com.gotreaux.aoc.puzzles.year2018.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReposeRecordPuzzle extends Puzzle {

    public ReposeRecordPuzzle() {
        super(2018, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        Collection<Guard> guards = new ArrayList<>();

        List<GuardRecord> records =
                inputReader
                        .getInputStream()
                        .map(GuardRecord::of)
                        .sorted(Comparator.comparing(GuardRecord::time))
                        .toList();

        Guard currentGuard = null;
        GuardRecord asleepRecord = null;
        for (GuardRecord record : records) {
            switch (record.status()) {
                case BEGINS_SHIFT ->
                        currentGuard =
                                guards.stream()
                                        .filter(guard -> guard.getId() == record.guardId())
                                        .findFirst()
                                        .orElseGet(
                                                () -> {
                                                    Guard guard = new Guard(record.guardId());
                                                    guards.add(guard);
                                                    return guard;
                                                });
                case FALLS_ASLEEP -> asleepRecord = record;
                case WAKES_UP -> {
                    if (currentGuard != null && asleepRecord != null) {
                        currentGuard.addSleep(asleepRecord.time(), record.time());
                    }
                }
            }
        }

        int guardMostMinutesAsleep =
                guards.stream()
                        .max(Comparator.comparingInt(Guard::getTotalMinutesAsleep))
                        .map(guard -> guard.getId() * guard.getMinuteMostAsleep())
                        .orElseThrow();

        int guardMinuteMostFrequentlyAsleep =
                guards.stream()
                        .max(Comparator.comparingInt(Guard::getHighestMinuteFrequency))
                        .map(guard -> guard.getId() * guard.getMinuteMostAsleep())
                        .orElseThrow();

        return new PuzzleOutput<>(guardMostMinutesAsleep, guardMinuteMostFrequentlyAsleep);
    }
}
