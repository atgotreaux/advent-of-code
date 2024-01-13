package com.gotreaux.aoc.utils;

public class MathUtils {

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
