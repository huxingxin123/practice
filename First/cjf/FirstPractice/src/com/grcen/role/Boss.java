package com.grcen.role;


public class Boss extends Enemy {

    public Boss() {
        super("Boss", 250, 60, 30, 1);
    }

    public void initAttributes(int level) {
        ICalculation calculation = new CalculationImp();
        int multiple = calculation.bossMultiple(level);
        this.setLife(multiple * this.getLife());
        this.setAttack(multiple * this.getAttack());
        this.setDefense(multiple * this.getDefense());
        this.setAgile(multiple * this.getAgile());
    }

}
