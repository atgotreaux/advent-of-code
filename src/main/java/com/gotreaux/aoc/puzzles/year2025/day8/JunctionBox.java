package com.gotreaux.aoc.puzzles.year2025.day8;

record JunctionBox(int x, int y, int z) {

    static JunctionBox of(String line) {
        var parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid junction box format: " + line);
        }

        var x = Integer.parseInt(parts[0]);
        var y = Integer.parseInt(parts[1]);
        var z = Integer.parseInt(parts[2]);

        return new JunctionBox(x, y, z);
    }

    long distanceTo(JunctionBox other) {
        var dx = x - other.x();
        var dy = y - other.y();
        var dz = z - other.z();

        return Math.multiplyFull(dx, dx) + Math.multiplyFull(dy, dy) + Math.multiplyFull(dz, dz);
    }
}
