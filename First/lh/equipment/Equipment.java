package equipment;


public class Equipment {
    private int healthPoint;//生命值
    private int ATK;//攻击力
    private int defensivePower;//防御力
    private int agility;//敏捷度

    protected Equipment(int healthPoint, int ATK, int defensivePower, int agility) {
        this.healthPoint = healthPoint;
        this.ATK = ATK;
        this.defensivePower = defensivePower;
        this.agility = agility;
    }


    public static Equipment build() {
        return new Equipment(0, 0, 0, 0);
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDefensivePower() {
        return defensivePower;
    }

    public void setDefensivePower(int defensivePower) {
        this.defensivePower = defensivePower;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

}
