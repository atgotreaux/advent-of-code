package com.gotreaux.aoc.puzzles.year2015.day14;

record Reindeer(String name, int speed, int duration, int rest) {
    int getDistance(int time) {
        int cycleTime = duration + rest;
        int cycles = time / cycleTime;
        int remainingTime = time % cycleTime;

        return (cycles * speed * duration) + (Math.min(remainingTime, duration) * speed);
    }
}
