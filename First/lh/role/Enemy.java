package role;

import exception.SetException;

abstract public class Enemy {
    private String name;
    private int healthPoint;//生命值
    private int ATK;//攻击力
    private int defensivePower;//防御力
    private int agility;//敏捷度

    abstract void attack(Role role);

    Enemy(String name, int healthPoint, int ATK, int defensivePower, int agility) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.ATK = ATK;
        this.defensivePower = defensivePower;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    void setHealthPoint(int healthPoint) {
        if (healthPoint>=1&&healthPoint<=999999){
            this.healthPoint = healthPoint;
        }else {
            try {
                throw new SetException("生命值不能超过999999以及低于1");
            } catch (SetException e) {
                e.printStackTrace();
            }
        }
    }

    public int getATK() {
        return ATK;
    }

    void setATK(int ATK) {
        if (ATK>=1&&ATK<=999999){
            this.ATK = ATK;
        }else {
            try {
                throw new SetException("攻击力不能超过999999以及低于1");
            } catch (SetException e) {
                e.printStackTrace();
            }
        }

    }

    public int getDefensivePower() {
        return defensivePower;
    }

    void setDefensivePower(int defensivePower) {
        if (defensivePower>=1&&defensivePower<=999999){
            this.defensivePower = defensivePower;
        }else {
            try {
                throw new SetException("防御力不能超过999999以及低于1");
            } catch (SetException e) {
                e.printStackTrace();
            }
        }
    }

    public int getAgility() {
        return agility;
    }

    void setAgility(int agility) {
        if (agility>=1&&agility<=100){
            this.agility = agility;
        }else {
            try {
                throw new SetException("敏捷度不能超过100以及低于1");
            } catch (SetException e) {
                e.printStackTrace();
            }
        }
    }

}
