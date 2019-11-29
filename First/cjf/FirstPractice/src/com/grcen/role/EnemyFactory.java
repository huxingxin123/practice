package com.grcen.role;

public class EnemyFactory {
    public static final Enemy[] newThreeMonster(int level) {
        Enemy[] enemies = new Monster[3];
        for (int i = 0; i < enemies.length; i++) {
            Enemy monster = new Monster(i);
            monster.initAttributes(level);
            enemies[i] = monster;
        }
        return enemies;
    }

    public static final Enemy newBoss(int level) {
        Enemy boss = new Boss();
        boss.initAttributes(level);
        return boss;
    }
}
