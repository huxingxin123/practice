package com.grcen.role;

public abstract class Enemy extends Role {

    public Enemy() {
    }

    public Enemy(String name, long life, long attack, long defense, int agile) {
        super(name, life, attack, defense, agile);
    }

    public abstract void initAttributes(int level);
}
