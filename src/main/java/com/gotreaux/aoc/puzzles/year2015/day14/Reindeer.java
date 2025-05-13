package com.gotreaux.aoc.puzzles.year2015.day14;

record Reindeer(String name, int speed, int duration, int rest) {

    static Reindeer of(String line) {
        var parts = line.split(" ");

        return new Reindeer(
                parts[0],
                Integer.parseInt(parts[3]),
                Integer.parseInt(parts[6]),
                Integer.parseInt(parts[13]));
    }

    int getDistance(int time) {
        var cycleTime = duration + rest;
        var cycles = time / cycleTime;
        var remainingTime = time % cycleTime;

        return (cycles * speed * duration) + (Math.min(remainingTime, duration) * speed);
    }
}
