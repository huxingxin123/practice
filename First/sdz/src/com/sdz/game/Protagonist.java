package com.sdz.game;


import com.sdz.fight.OnFight;
import com.sdz.gameprops.Bag;
import com.sdz.gameprops.Prop;
import com.sdz.monster.Boss;
import com.sdz.monster.Monster;
import com.sdz.monster.SmallMonster;
import com.sdz.gameprops.PropEnum;
import com.sdz.utils.Probability;

import java.util.ArrayList;

public class Protagonist extends Player implements OnFight {

    private String name ;
    private int lifeValue ;
    private boolean isAlive;
    private int aggressiveness ;
    private int defensivePower ;
    private int speed;
    //背包
//    private ArrayList<Prop> bag;
    private Bag bag;


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getName() {
        return name;
    }

    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }

    public void setAggressiveness(int aggressiveness) {
        this.aggressiveness = aggressiveness;
    }

    public void setDefensivePower(int defensivePower) {
        this.defensivePower = defensivePower;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public int getAggressiveness() {
        return aggressiveness;
    }

    public int getDefensivePower() {
        return defensivePower;
    }

    public int getSpeed() {
        return speed;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Protagonist() {
        name = "sdz";
        lifeValue = 1000;
        isAlive = true;
        aggressiveness = 50;
        defensivePower = 20;
        speed = 20;
        bag = new Bag();
    }


    public Protagonist(String name, int lifeValue, boolean isAlive, int aggressiveness, int defensivePower, int speed, Bag bag) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.isAlive = isAlive;
        this.aggressiveness = aggressiveness;
        this.defensivePower = defensivePower;
        this.speed = speed;
        this.bag = bag;
    }

//    public Protagonist(String name, int lifeValue, int aggressiveness, int defensivePower, int speed) {
//        this.name = name;
//        this.lifeValue = lifeValue;
//        this.aggressiveness = aggressiveness;
//        this.defensivePower = defensivePower;
//        this.speed = speed;
//        this.isAlive = true;
//
//    }


    int attack(SmallMonster smallMonster) {
        int damage = aggressiveness-smallMonster.getDefensivePower();
        return  damage ;
    }

    int attack(com.sdz.monster.Boss boss){
        int damage = aggressiveness-boss.getDefensivePower();
        return  damage ;
    }

    public int attack(OnFight onFight) {
//        int damage = aggressiveness-monster.getDefensivePower();
//        onFight.beAttacked(this);
//        return  damage;
        //返回受到的伤害给伤害造成者
        return onFight.beAttacked(this);

    }

//    public int useProp(Prop prop){
//
//        int description = prop.getPropType();
//        switch (description) {
//            case PropEnum.LIFE_VALUE:
//                lifeValue+=prop.getValue();
//                break;
//            case PropEnum.AGGRESSIVENESS:
//                aggressiveness+=prop.getValue();
//                break;
//            case PropEnum.DEFENSIVE_POWER:
//                defensivePower+=prop.getValue();
//            case PropEnum.SPEED:
//                defensivePower+=prop.getValue();
//        }
//
//        return 0;
//    }0



    @Override
    public int beAttacked(Boss boss) {
        int damage = 0;
        if (boss.getAggressiveness() - defensivePower >= 0) {
            damage = boss.getAggressiveness() - defensivePower;
            if (Probability.create(20)) {
                damage*=2;
            }
            lifeValue-=damage;
            if (lifeValue <= 0) {
                setAlive(false);
            }
            System.out.printf("%s受到%s的%d点伤害\n", name, boss.getName(), damage);
        }else {
            System.out.println("伤害不足");
        }
        return damage;
    }


    @Override
    public int beAttacked( SmallMonster smallMonster) {
        int damage = 0;
        if (smallMonster.getAggressiveness() - defensivePower >= 0) {
            damage = smallMonster.getAggressiveness() - defensivePower;
            if (Probability.create(20)) {
                damage*=2;
            }
            lifeValue-=damage;
            if (lifeValue <= 0) {
                setAlive(false);
            }
            System.out.printf("%s受到%s的%d点伤害\n", name, smallMonster.getName(), damage);
        }else {
            System.out.println("伤害不足");
        }
        return damage;
    }


    @Override
    public int beAttacked(Protagonist protagonist) {
        System.out.println("不能攻击队友");
        return 0;
    }



    public void updateData() {
        if(true){

        }
    }

    public int check() {

        if (name.length() >= 50 || name.length() <= 1) {
            System.out.println("野怪名字长度超限");
        }
        if (lifeValue >= 999999 || lifeValue <= 1) {
            System.out.println("野怪生命值越超限");
        }
        if (aggressiveness >= 999999 || aggressiveness <= 1) {
            System.out.println("野怪攻击力超限");
        }
        if (defensivePower >= 999999 || defensivePower <= 1) {
            System.out.println("野怪防御力超限");
        }
        if (speed >= 100 || speed <= 1) {
            System.out.println("野怪敏捷超限");
        }
        if(difficulty<=10||difficulty>1){
            System.out.println("游戏难度超限");
        }
        return 0;
    }


}
