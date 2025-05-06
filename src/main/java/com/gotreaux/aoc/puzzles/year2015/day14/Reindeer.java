package com.gotreaux.aoc.puzzles.year2015.day14;

record Reindeer(String name, int speed, int duration, int rest) {

    static Reindeer of(String line) {
        String[] parts = line.split(" ");

        return new Reindeer(
                parts[0],
                Integer.parseInt(parts[3]),
                Integer.parseInt(parts[6]),
                Integer.parseInt(parts[13]));
    }

    int getDistance(int time) {
        int cycleTime = duration + rest;
        int cycles = time / cycleTime;
        int remainingTime = time % cycleTime;

        return (cycles * speed * duration) + (Math.min(remainingTime, duration) * speed);
    }
}
