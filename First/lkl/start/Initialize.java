package start;

import figure.Boss;
import figure.Player;
import figure.WildMonster;
import gameset.GameLevel;

import java.util.Scanner;

public class Initialize {

    //退出游戏
    private boolean flag=true;

    public void start() {
        String name;
        int hp;
        int attack;
        int defense;
        int velocity;
        int gameLevel;

        System.out.println("******欢迎进入游戏******");
        System.out.println("输入：1->启动游戏");
        System.out.println("输入：2->退出游戏");

        while (flag) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                String i = scanner.next();
                int j = Integer.parseInt(i);
                if (j == 1) {
                    System.out.println("***游戏开始***");
                    System.out.println("请输入主角名称:");
                    name = scanner.next();
                    System.out.println("请输入主角初始生命值");
                    hp=scanner.nextInt();
                    System.out.println("请输入主角攻击力");
                    attack=scanner.nextInt();
                    System.out.println("请输入主角防御力");
                    defense=scanner.nextInt();
                    System.out.println("请输入主角敏捷");
                    velocity=scanner.nextInt();
                    System.out.println("请选择游戏难度：1->简单 2->中等 3->困难");
                    gameLevel=scanner.nextInt();

                    //人物初始化成功
                    Player player=new Player(name,hp,attack,defense,velocity);

                    //初始化关卡和野怪
                    Boss boss=new GameLevel(gameLevel).buildBoss();
                    WildMonster monster=new GameLevel(gameLevel).bulidWildMonster();

                    //进入游戏战斗
                    new GlobalFight(player,boss,monster).doThis();

                    //退出循环
                    flag=false;

                } else if (j == 2) {
                    System.out.println("游戏结束");
                    flag=false;
                } else {
                    System.out.println("输入的指令错误,请重新输入");
                }
            }
        }
    }
}
