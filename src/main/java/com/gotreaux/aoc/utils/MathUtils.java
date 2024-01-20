package com.gotreaux.aoc.utils;

public final class MathUtils {

    private MathUtils() {}

    public static long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }

    static long gcd(long x, long y) {
        return y == 0L ? x : gcd(y, x % y);
    }
}
