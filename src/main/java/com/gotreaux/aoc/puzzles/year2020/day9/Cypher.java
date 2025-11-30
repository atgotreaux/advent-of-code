package com.gotreaux.aoc.puzzles.year2020.day9;

import java.util.List;
import java.util.stream.IntStream;

record Cypher(List<Long> numbers, int preambleLength) {

    Cypher {
        if (preambleLength < 2) {
            throw new IllegalArgumentException("Preamble length must be at least 2");
        }
        if (numbers.size() < preambleLength + 1) {
            throw new IllegalArgumentException("Not enough numbers to find a valid cypher");
        }
    }

    long findInvalidNumber() {
        return IntStream.range(preambleLength, numbers.size())
                .filter(index -> !isValidNumber(numbers.get(index), index))
                .mapToLong(numbers::get)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No invalid number found"));
    }

    private boolean isValidNumber(long number, int index) {
        for (var j = index - preambleLength; j < index - 1; j++) {
            for (var k = j + 1; k < index; k++) {
                if (numbers.get(j) + numbers.get(k) == number) {
                    return true;
                }
            }
        }
        return false;
    }

    long findContiguousSetSummingTo(long target) {
        for (var i = 0; i < numbers.size() - 1; i++) {
            long sum = numbers.get(i);
            long min = numbers.get(i);
            long max = numbers.get(i);

            for (var j = i + 1; j < numbers.size(); j++) {
                long currentNumber = numbers.get(j);
                sum += currentNumber;
                min = Math.min(min, currentNumber);
                max = Math.max(max, currentNumber);

                if (sum == target) {
                    return min + max;
                } else if (sum > target) {
                    break;
                }
            }
        }
        throw new IllegalStateException("No contiguous set found");
    }
}
