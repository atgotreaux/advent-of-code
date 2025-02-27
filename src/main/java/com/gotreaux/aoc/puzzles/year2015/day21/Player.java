package com.gotreaux.aoc.puzzles.year2015.day21;

import java.util.Optional;
import java.util.stream.Stream;

record Player(
        int hitPoints,
        Weapon weapon,
        Optional<Armor> armor,
        Optional<Ring> leftRing,
        Optional<Ring> rightRing) {

    int calculateDamage() {
        return Stream.of(
                        Optional.of(weapon.getDamage()),
                        armor.map(Armor::getDamage),
                        leftRing.map(Ring::getDamage),
                        rightRing.map(Ring::getDamage))
                .flatMap(Optional::stream)
                .reduce(0, Integer::sum);
    }

    int calculateArmor() {
        return Stream.of(
                        Optional.of(weapon.getArmor()),
                        armor.map(Armor::getArmor),
                        leftRing.map(Ring::getArmor),
                        rightRing.map(Ring::getArmor))
                .flatMap(Optional::stream)
                .reduce(0, Integer::sum);
    }

    int calculateCost() {
        return Stream.of(
                        Optional.of(weapon.getCost()),
                        armor.map(Armor::getCost),
                        leftRing.map(Ring::getCost),
                        rightRing.map(Ring::getCost))
                .flatMap(Optional::stream)
                .reduce(0, Integer::sum);
    }
}
