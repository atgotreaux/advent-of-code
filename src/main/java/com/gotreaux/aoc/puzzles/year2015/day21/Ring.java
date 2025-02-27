package com.gotreaux.aoc.puzzles.year2015.day21;

enum Ring {
    DAMAGE1(25, 1, 0),
    DAMAGE2(50, 2, 0),
    DAMAGE3(100, 3, 0),
    DEFENSE1(20, 0, 1),
    DEFENSE2(40, 0, 2),
    DEFENSE3(80, 0, 3);

    private final int cost;
    private final int damage;
    private final int armor;

    Ring(int cost, int damage, int armor) {
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
