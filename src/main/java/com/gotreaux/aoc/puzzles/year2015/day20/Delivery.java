package com.gotreaux.aoc.puzzles.year2015.day20;

import java.util.Collection;
import java.util.stream.IntStream;

record Delivery(Collection<Elf> elves, int presentTarget) {

    int getMinimumHouseNumber() {
        int maxHouseNumber = presentTarget / 10;

        int[] housePresents = new int[maxHouseNumber + 1];
        for (Elf elf : elves) {
            int housesElfDelivered = 0;
            for (int house = elf.id();
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
