package com.sdz.monster;

import com.sdz.fight.OnFight;
import com.sdz.game.Protagonist;
import com.sdz.utils.Probability;

public class SmallMonster extends Monster implements OnFight {

    int difficulty;

    private String name ;
    private int lifeValue ;
    private int aggressiveness ;
    private int defensivePower ;
    private int speed;


    public void setName(String name) {
        this.name = name;
    }

    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }

    public int getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(int aggressiveness) {
        aggressiveness = aggressiveness;
    }

    public void setDefensivePower(int defensivePower) {
        this.defensivePower = defensivePower;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
    }

    public int getLifeValue() {
        return lifeValue;
    }


    public int getDefensivePower() {
        return defensivePower;
    }

    public int getSpeed() {
        return speed;
    }


    public SmallMonster(int difficulty) {

        super();
        this.difficulty = difficulty;

        name = difficulty + "级小狼";
        lifeValue = 100 * difficulty;
        aggressiveness = 40 * difficulty;
        defensivePower = 5 * difficulty;
        speed = 1;
    }





    public int attack(OnFight onFight) {
        return onFight.beAttacked(this);
    }




    @Override
    public int beAttacked(Protagonist protagonist) {
        int damage=0;
        if((protagonist.getAggressiveness()-defensivePower)>=0)
        {
            damage =protagonist.getAggressiveness()-defensivePower;
            lifeValue-=damage;
            if (lifeValue <= 0) {
                setAlive(false);
            }
            System.out.printf("%s受到了%s的%d点伤害\n",name,protagonist.getName(),damage);
        }else {

            System.out.println("伤害不够啊");
        }
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


}
