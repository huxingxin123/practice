package com.grcen.role;

/**
 * 这里把Role作为成员变量解决只想部分继承的问题
 */
public class Hero extends Role {
    private static volatile Hero instance;

    private Hero() {
    }

    private Hero(String name, long lifeValue, long attackValue, long defense, int agileValue) {
        super(name, lifeValue, attackValue, defense, agileValue);
    }

    public static Hero getInstance(String name, long lifeValue, long attackValue, long defense, int agileValue) {
        if (instance == null) {
            synchronized (Hero.class) {
                if (instance == null) {
                    instance = new Hero(name, lifeValue, attackValue, defense, agileValue);
                }
            }
        }
        return instance;
    }

    public static Hero getInstance() {
        if (instance != null) {
            return instance;
        } else {
            throw new IllegalStateException("current Object has not init!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Host{");
        sb.append("life: ").append(getLife())
                .append("attack :").append(getAttack())
                .append("defense: ").append(getDefense())
                .append("agileValue: ").append(getAgile());
        sb.append('}');
        return sb.toString();
    }
}
