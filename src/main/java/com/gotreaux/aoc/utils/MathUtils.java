package com.gotreaux.aoc.utils;

public final class MathUtils {

    private MathUtils() {}

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    static long gcd(long a, long b) {
        return b == 0L ? a : gcd(b, a % b);
    }
}
