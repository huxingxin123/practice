package com.sdz.game;

import com.sdz.fight.Fight;
import com.sdz.monster.Boss;
import com.sdz.monster.SmallMonster;

import java.util.ArrayList;
import java.util.Collections;

public class RoadBlock {

    private String name;

    private Protagonist player;

    private int difficulty;

    private ArrayList<SmallMonster> smallMonsters;

    private Boss boss;

    public RoadBlock() { }

    public RoadBlock(String name,int difficulty, Protagonist player) {
        this.name =name;
        this.difficulty = difficulty;
        this.player = player;
        SmallMonster smallMonster = new SmallMonster(difficulty);
        smallMonsters = new ArrayList<SmallMonster>();
        for (int i = 0; i < 6; i++) {
            smallMonsters.add(new SmallMonster(difficulty));
        }
        boss = new Boss(difficulty);
        name = "深山";
    }

    Boolean risk (Protagonist player, int difficulty){
        return true;
    }

    public void Init(){ }

    //闯关方法，在关卡初始化后执行
    public int risk(){
//        System.out.println(player.getName()+"在"+this.name+"遇到了三个"+smallMonsters.get(0).getName());
//        int damage = player.attack(smallMonsters.get(1));
//        System.out.println("小狼受到"+damage+"点伤害");
        Fight fight = new Fight(player,smallMonsters,boss);
        return fight.start();
    }
}
