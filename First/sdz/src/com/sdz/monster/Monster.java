package com.sdz.monster;

import com.sdz.fight.OnFight;
import com.sdz.game.Protagonist;

public  abstract class Monster implements  OnFight {


//    protected String name ;
//    protected int lifeValue ;
//    protected int aggressiveness;
//    protected int defensivePower ;
//    protected int speed;

    protected boolean isAlive;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    //初始化子类时调用
    public Monster(){
        isAlive = true;
    }
//
//    public Monster(String name, int lifeValue, int aggressiveness, int defensivePower, int speed) {
//        this.name = name;
//        this.lifeValue = lifeValue;
//        this.aggressiveness = aggressiveness;
//        this.defensivePower = defensivePower;
//        this.speed = speed;
//        this.isAlive = true;
//    }



    @Override
    public int beAttacked(Protagonist protagonist) {
        int damage=0;
//        if((protagonist.getAggressiveness()-defensivePower)>=0)
//        {
//            damage =protagonist.getAggressiveness()-defensivePower;
//            lifeValue-=damage;
//            if (lifeValue <= 0) {
//                setAlive(false);
//            }
//            System.out.printf("%s受到了%s的%d点伤害\n",name,protagonist.getName(),damage);
//        }else {
//
//            System.out.println("伤害不够啊");
//        }
        return damage;
    }


    @Override
    public int beAttacked(SmallMonster smallMonster) {
        System.out.println("不能对同伴发起攻击");
        return 0;
    }

    @Override
    public int beAttacked(Boss boss) {
        System.out.println("不能对同伴发起攻击");
        return 0;
    }


    public int attack(OnFight onFight){
        return 0;
    }

    public int getSpeed() {
        return 0;
    }

}
