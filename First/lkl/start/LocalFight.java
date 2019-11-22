package start;

import figure.Boss;
import figure.Player;
import figure.WildMonster;
import gameset.Equipment;
import rules.AtkDetails;

import java.util.Scanner;

public class LocalFight extends Fight {

    //玩家选项
    private int choose;

    //是否回到准备状态
    private boolean ready=false;



    private static int count=0;
    private Player player;
    private Boss boss;
    private WildMonster monster;

    public LocalFight(Player player, Boss boss, WildMonster monster){
        this.player=player;
        this.boss=boss;
        this.monster=monster;
    }

    //选择
    @Override
    protected void ready() {
        System.out.println("战斗即将开始-_-!是否前进-> 1.前进 2.显示血量 3.退出游戏并保存 4.使用道具");
        Scanner scanner = new Scanner(System.in);
        choose = scanner.nextInt();
    }

    //开始应对每一波的攻击
    @Override
    protected void start() {
        switch (choose){
            case 1:
                switch (count) {
                    case 0:
                        count++;
                        System.out.println("******打Monster******");
                        new AtkDetails(player,boss,monster).atkMonster();
                        if (player.getHp()>0){

                        }
                        ready=false;
                        break;
                    case 1:
                        count++;
                        System.out.println("******打Monster******");
                        new AtkDetails(player,boss,monster).atkMonster();
                        ready=false;
                        break;
                    case 2:
                        count = 0;
                        System.out.println("******打Boss******");
                        new AtkDetails(player,boss,monster).atkBoss();
                        ready=false;
                        break;
                }
                break;
            case 2:
                System.out.println("剩余血量："+player.getHp());
                ready=true;
                break;
            case 3:
                System.out.println("***   游戏结束   ***");
                break;
            case 4:
                System.out.println("请选择需要使用的道具：");
                int i=0;
                for (;i<player.arrayList.size();i++){
                    System.out.println(player.arrayList.get(i));
                }
                Scanner scanner=new Scanner(System.in);
                int index=scanner.nextInt();
                new Equipment(player.arrayList).useEquipment(player,index);
                player.arrayList.remove(index);
                ready=true;
                break;
                default:
                    System.out.println("输入指令错误");
        }

    }

    //一波攻击结束
    @Override
    protected void end() {
        System.out.println("*************");
        if (ready){
            this.doThis();
        }
    }
}
