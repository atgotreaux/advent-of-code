package com.gotreaux.aoc.puzzles.year2015.day21;

record Battle(Player player, Boss boss) {

    boolean isWin() {
        int playerHitPoints = player.hitPoints();
        int bossHitPoints = boss.hitPoints();

        int damageToBoss = Math.max(1, player.calculateDamage() - boss.armor());
        int damageToPlayer = Math.max(1, boss.damage() - player.calculateArmor());

        while (playerHitPoints > 0 && bossHitPoints > 0) {
            bossHitPoints -= damageToBoss;
            if (bossHitPoints <= 0) {
                return true;
            }
            playerHitPoints -= damageToPlayer;
        }
        return false;
    }
}
