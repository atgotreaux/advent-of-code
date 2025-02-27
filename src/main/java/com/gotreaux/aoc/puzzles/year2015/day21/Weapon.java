package com.gotreaux.aoc.puzzles.year2015.day21;

enum Weapon {
    DAGGER(8, 4, 0),
    SHORTSWORD(10, 5, 0),
    WARHAMMER(25, 6, 0),
    LONGSWORD(40, 7, 0),
    GREATEAXE(74, 8, 0);

    private final int cost;
    private final int damage;
    private final int armor;

    Weapon(int cost, int damage, int armor) {
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
