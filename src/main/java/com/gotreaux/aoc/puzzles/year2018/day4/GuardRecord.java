package com.gotreaux.aoc.puzzles.year2018.day4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.lang.Nullable;

record GuardRecord(LocalDateTime time, Status status, @Nullable Integer guardId) {

    private static final Pattern RECORD_PATTERN =
            Pattern.compile("^\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})] (.+)$");
    static final Pattern WAKES_UP_PATTERN = Pattern.compile("^wakes up$");
    static final Pattern FALLS_ASLEEP_PATTERN = Pattern.compile("^falls asleep$");
    static final Pattern BEGINS_SHIFT_PATTERN = Pattern.compile("^Guard #(\\d+) begins shift$");

    static GuardRecord from(String line) {
        Matcher recordMatcher = RECORD_PATTERN.matcher(line);
        if (!recordMatcher.matches()) {
            throw new IllegalArgumentException("Invalid record: %s".formatted(line));
        }

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.getDefault());
        LocalDateTime time = LocalDateTime.parse(recordMatcher.group(1), formatter);
        Status status = Status.from(recordMatcher.group(2));

        Integer guardId = null;
        if (status == Status.BEGINS_SHIFT) {
            Matcher shiftMatcher = BEGINS_SHIFT_PATTERN.matcher(recordMatcher.group(2));
            if (shiftMatcher.matches()) {
                guardId = Integer.parseInt(shiftMatcher.group(1));
            }
        }

        return new GuardRecord(time, status, guardId);
    }
}
