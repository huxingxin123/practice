package com.grcen.role;

/**
 * 角色都有的信息：
 * 1 名字 2 生命值 3 攻击力 4 防御力 5 敏捷度
 */
public abstract class Role {
    private String name;
    private long life;
    private long attack;
    private long defense;
    private int agile;

    Role() {

    }

    public Role(String name, long life, long attack, long defense, int agile) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.defense = defense;
        this.agile = agile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLife() {
        return life;
    }

    public void setLife(long life) {
        this.life = life;
    }

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public long getDefense() {
        return defense;
    }

    public void setDefense(long defense) {
        this.defense = defense;
    }

    public int getAgile() {
        return agile;
    }

    public void setAgile(int agile) {
        this.agile = agile;
    }

}
