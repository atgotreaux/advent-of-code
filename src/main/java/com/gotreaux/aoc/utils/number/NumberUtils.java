package com.gotreaux.aoc.utils.number;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class NumberUtils {

    private NumberUtils() {}

    public static Long concatenate(Collection<Long> numbers) {
        return Long.parseLong(numbers.stream().map(Object::toString).collect(Collectors.joining()));
    }

    public static List<Long> collect(CharSequence sequence, Pattern pattern) {
        return Arrays.stream(pattern.split(sequence)).map(Long::parseLong).toList();
    }
}
