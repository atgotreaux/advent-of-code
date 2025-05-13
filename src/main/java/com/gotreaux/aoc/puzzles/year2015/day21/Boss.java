package com.gotreaux.aoc.puzzles.year2015.day21;

import java.util.regex.Pattern;

record Boss(int hitPoints, int damage, int armor) {

    private static final Pattern PATTERN = Pattern.compile(": ");

    static Boss of(Iterable<String> input) {
        var hitPoints = 0;
        var damage = 0;
        var armor = 0;

        for (var line : input) {
            var parts = PATTERN.split(line);
            switch (parts[0]) {
                case "Hit Points" -> hitPoints = Integer.parseInt(parts[1]);
                case "Damage" -> damage = Integer.parseInt(parts[1]);
                case "Armor" -> armor = Integer.parseInt(parts[1]);
                default ->
                        throw new IllegalArgumentException(
                                "Unknown boss attribute: %s".formatted(parts[0]));
            }
        }

        return new Boss(hitPoints, damage, armor);
    }
}
