package com.gotreaux.aoc.utils.matrix;

import java.util.function.Predicate;

class LimitPredicate implements Predicate<Integer> {
    private final int limit;

    LimitPredicate() {
        this(Integer.MAX_VALUE);
    }

    LimitPredicate(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean test(Integer value) {
        return value < limit;
    }
}
