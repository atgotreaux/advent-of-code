package com.gotreaux.aoc.puzzles.year2015.day20;

import java.util.Collection;
import java.util.stream.IntStream;

record Delivery(Collection<Elf> elves, int presentTarget) {

    int getMinimumHouseNumber() {
        var maxHouseNumber = presentTarget / 10;

        var housePresents = new int[maxHouseNumber + 1];
        for (var elf : elves) {
            var housesElfDelivered = 0;
            for (var house = elf.id();
                    house <= maxHouseNumber && housesElfDelivered < elf.maximumHouses();
                    house += elf.id()) {
                housePresents[house] += elf.id() * elf.presents();
                housesElfDelivered++;
            }
        }

        return IntStream.range(1, maxHouseNumber + 1)
                .filter(house -> housePresents[house] >= presentTarget)
                .findFirst()
                .orElse(-1);
    }
}
