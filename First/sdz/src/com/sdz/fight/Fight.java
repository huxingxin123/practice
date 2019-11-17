package com.sdz.fight;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.Prop;
import com.sdz.gameprops.PropFactory;
import com.sdz.monster.Boss;
import com.sdz.monster.Monster;
import com.sdz.monster.SmallMonster;
import com.sdz.utils.Order;
import com.sdz.utils.Probability;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Fight {

    Protagonist player;

    ArrayList<Monster> monsters;

    public Fight(Protagonist player, ArrayList<Monster> monsters) {
        this.player = player;
        this.monsters = monsters;
    }

    public Fight(){}

    public Fight(Protagonist protagonist, ArrayList<SmallMonster> smallMonsters, Boss boss) {
        player = protagonist;
        monsters = new ArrayList<Monster>(Arrays.asList(smallMonsters.get(0),
                smallMonsters.get(1),
                smallMonsters.get(2),
                smallMonsters.get(3),
                smallMonsters.get(4),
                smallMonsters.get(5),
                boss
        ));

    }


    public int start() {
        PropFactory propFactory = new PropFactory();
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        int playerNumbers = monsters.size() + 1;
        int monsterNumbers = playerNumbers - 1;
        Random random = new Random();
        //初始化攻速
        List<Integer> monsterSpeeds = new ArrayList<Integer>();
        for (int i = 0; i < monsterNumbers; i++) {
            if (i >= 1) monsterSpeeds.add(monsters.get(i - 1).getSpeed());
        }

//        order.inputGoOn(player);

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        System.out.printf("按enter:继续前进,输入1查看主角的血量状态\n请输入:");
//        try {
//            String str = bf.readLine();
//            if(str.length()==0){
//                System.out.println("进入下一波野怪");
//            }
//            if(str.equals("1")){
//                System.out.printf("%s的剩余生命值为%d\n",player.getName(),player.getLifeValue());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        //第一波怪物
        outer:
        for (int round = 1; ; round++) {//round 回合
            //主角光环先进行攻击
            for (int i = 0; i < player.getSpeed(); i++) {
                int attackTarget = random.nextInt(monsterNumbers - 4);
                player.attack(monsters.get(attackTarget));
                if (!monsters.get(attackTarget).isAlive()) {
                    monsterNumbers--;
                    System.out.println("一个小狼死了");
                    monsters.remove(attackTarget);
                    Prop prop = dropProp(30,1);
                    if (prop != null) {
                        player.getBag().getPropList().add(prop);
                    }

//                    if (dropProp()) {
//                        int type = random.nextInt(4);
//                        Prop prop = propFactory.getProp(type,1);
//                        player.getBag().add(prop);
//                    }
                }
                if (monsterNumbers == 4) {
                    break outer;
                }
            }
            //三个小怪开始攻击
            for (int j = 0; j < monsterNumbers - 4; j++) {


                for (int i = 0; i < monsters.get(j).getSpeed(); i++) {
                    monsters.get(j).attack(player);
                    if (!player.isAlive()) {

                        return 1;
                    }
                }

            }
        }
        System.out.printf("您已通过第一波!\n\n");
//        order.inputGoOn(player);
        //第二波怪物开始攻击
        outer2:
        for (int round = 1; ; round++) {
            for (int i = 0; i < player.getSpeed(); i++) {
                int attackTarget = random.nextInt(monsterNumbers - 1);
                player.attack(monsters.get(attackTarget));
                if (!monsters.get(attackTarget).isAlive()) {
                    monsterNumbers--;
                    System.out.println("一个小狼死了");
                    monsters.remove(attackTarget);
                    Prop prop = dropProp(30,1);
                    if (prop != null) {
                        player.getBag().getPropList().add(prop);
                    }
//                    if (dropProp()) {
//                        int type = random.nextInt(4);
//                        Prop prop = propFactory.getProp(type,1);
//                        player.getBag().add(prop);
//                    }
                }
                if (monsterNumbers == 1) {
                    break outer2;
                }
            }
            //三个小怪开始攻击
            for (int j = 0; j < monsterNumbers - 1; j++) {
                for (int i = 0; i < monsters.get(j).getSpeed(); i++) {
                    monsters.get(j).attack(player);
                    if (!player.isAlive()) {
                        return 2;
                    }
                }

            }

        }
        System.out.printf("您已通过第二波!\n\n");
        System.out.printf("%s继续前进遇到了一个Boss\n",player.getName());
//        order.inputGoOn(player);
        //和boss单挑
        outer3:
        for (int round = 1; ; round++) {
            for (int i = 0; i < player.getSpeed(); i++) {
                player.attack(monsters.get(0));
                if (!monsters.get(0).isAlive()) {
                    System.out.printf("Boss被击败\n");
                    monsters.remove(0);
                    monsterNumbers--;
                    Prop prop = dropProp(15,2);
                    if (prop != null) {
                        player.getBag().getPropList().add(prop);
                    }
//                    if (dropProp(20)) {
//                        int type = random.nextInt(4);
//                        Prop prop = propFactory.getProp(type,2);
//                        player.getBag().add(prop);
//                    }
                    break outer3;
                }
            }
            for (int i = 0; i < monsters.get(0).getSpeed(); i++) {
                monsters.get(0).attack(player);
                if (!player.isAlive()) {
                    System.out.println("");
                    monsters.remove(0);
                    return 3;
                }
            }

        }
        System.out.printf("您已通过第三波!\n\n");
//        order.inputGoOn(player);
        return 0;
    }

    //击败敌人有几率掉落物品
    public Prop dropProp(int percent,int level){
        if (percent > 100 || percent < 0) {
            System.out.println("概率错误");
            return null;
        }

        Random random = new Random();
        PropFactory propFactory = new PropFactory();
        Prop prop = null;
////        int ranCounts = random.nextInt(100);
////        if (ranCounts < 50)return true;
////        else return false;
        if(Probability.create(percent)){
            int type = random.nextInt(4);
//            int type =2;
            prop = propFactory.getProp(type,level);
            if (level == 1) {
                switch (type){
                    case 0:
                        player.getBag().getTypeNumber()[0]++;
                        break;
                    case 1:
                        player.getBag().getTypeNumber()[1]++;
                        break;
                    case 2:
                        player.getBag().getTypeNumber()[2]++;
                        break;
                    case 3:
                        player.getBag().getTypeNumber()[3]++;
                        break;
                }
            }else if(level==2){
                switch (type){
                    case 0:
                        player.getBag().getTypeNumber()[4]++;
                        break;
                    case 1:
                        player.getBag().getTypeNumber()[5]++;
                        break;
                    case 2:
                        player.getBag().getTypeNumber()[6]++;
                        break;
                    case 3:
                        player.getBag().getTypeNumber()[7]++;
                        break;
                }
            }

        }
        return prop;
    }



}
