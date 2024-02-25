package com.gotreaux.aoc.puzzles.year2020.day6;

import java.util.Collection;

record PassengerGroup(Collection<String> passengerDeclarations) {
    long anyoneDeclared() {
        return passengerDeclarations().stream().flatMapToInt(String::chars).distinct().count();
    }

    long everyoneDeclared() {
        return passengerDeclarations().stream()
                .flatMapToInt(String::chars)
                .distinct()
                .filter(i -> passengerDeclarations.stream().allMatch(s -> s.indexOf(i) != -1))
                .count();
    }
}
