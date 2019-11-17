package com.sdz.monster;

import com.sdz.fight.OnFight;
import com.sdz.game.Protagonist;
import com.sdz.utils.Probability;

public class Boss extends Monster implements OnFight {

    public int getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
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



    int difficulty;

    String name ;
    int lifeValue ;
    int aggressiveness;
    int defensivePower ;
    int speed;



    public Boss(int difficulty) {
        super();
        this.difficulty = difficulty;

        name = difficulty+"级大Boss";
        lifeValue = 300*difficulty;
        aggressiveness = 60*difficulty;
        defensivePower = 15*difficulty;
        speed = 2;


    }

    public int attack(OnFight onFight) {
        return onFight.beAttacked(this);
    }


    @Override
    public int beAttacked(Protagonist protagonist) {
        int damage =0 ;
        if((protagonist.getAggressiveness()-defensivePower)>=0)
        {
            damage =protagonist.getAggressiveness()-defensivePower;
            if (Probability.create(20)) {
                damage*=2;
            }
            lifeValue-=damage;
            if (lifeValue <= 0) {
                setAlive(false);
            }
            System.out.printf("%s受到了%s的%d的伤害\n",name,protagonist.getName(),damage);
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
