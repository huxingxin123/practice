package com.grcen.role;

/**
 *
 */
public class Monster extends Enemy {


    public Monster(int id) {
        super("小怪" + id, 200, 50, 20, 1);
    }


    @Override
    public void initAttributes(int level) {
        ICalculation calculation = new CalculationImp();
        int multiple = calculation.monsterMultiple(level);
        this.setLife(multiple * this.getLife());
        this.setAttack(multiple * this.getAttack());
        this.setDefense(multiple * this.getDefense());
        this.setAgile(multiple * this.getAgile());
    }

}
