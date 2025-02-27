package com.gotreaux.aoc.puzzles.year2015.day21;

enum Armor {
    LEATHER(13, 0, 1),
    CHAINMAIL(31, 0, 2),
    SPLINTMAIL(53, 0, 3),
    BANDEDMAIL(75, 0, 4),
    PLATEMAIL(102, 0, 5);

    private final int cost;
    private final int damage;
    private final int armor;

    Armor(int cost, int damage, int armor) {
        this.cost = cost;
        this.damage = damage;
        this.armor = armor;
    }

    int getCost() {
        return cost;
    }

    int getDamage() {
        return damage;
    }

    int getArmor() {
        return armor;
    }
}
