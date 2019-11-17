package com.sdz.game;

import com.sdz.gameprops.Bag;
import com.sdz.gameprops.Prop;
import com.sdz.utils.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game  {



    private static Game game = null;

    private int  difficulty;

    private Protagonist player;

//    private List<RoadBlock> roadBlocks ;



    public static void main(String[] args) {
        Game game= Game.GetDefaultGame();
        game.Init();
        game.startGame();
//        smallMonster smallMonster = new smallMonster(game.getDifficulty());
//        System.out.println("小狼受到"+game.getPlayer().attack(smallMonster)+"点伤害");
    }

    public Game(){

    }



    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Protagonist getPlayer() {
        return player;
    }

    public void setPlayer(Protagonist player) {
        this.player = player;
    }


    public static synchronized Game GetDefaultGame(){
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public int Init(){
        String name ;
        int lifeValue ;
        int aggressiveness ;
        int defensivePower ;
        int speed;
        Bag bag;
        System.out.println("请输入主角的信息");
        Scanner sc = new Scanner(System.in);
        System.out.print("姓名: ");
        name = sc.nextLine();
        if(!"sdz".equals(name)) {
            do {
                System.out.print("生命值: ");
                lifeValue = sc.nextInt();
            }while(lifeValue>999999||lifeValue<1);
            do {
                System.out.print("攻击力: ");
                aggressiveness = sc.nextInt();
            } while (aggressiveness > 999999 || aggressiveness <1);
            do {
                System.out.print("防御力: ");
                defensivePower = sc.nextInt();
            } while (defensivePower > 999999 || defensivePower <1);

            do {
                System.out.print("敏捷: ");
                speed = sc.nextInt();
            } while (speed > 100 || speed <= 1);
            do {
                System.out.println("请输入游戏难度");
                difficulty = sc.nextInt();
            } while (difficulty > 10 || difficulty < 1);
            bag = new Bag();

        }else{
            lifeValue = 1000;
            aggressiveness = 105;
            defensivePower = 20;
            speed = 2;
            bag = new Bag();
            difficulty = 1;
        }

        player = new Protagonist(name,lifeValue,true,aggressiveness,defensivePower,speed,bag);

        System.out.println("游戏初始化完毕\n");
        return 0;
    }

    public void startGame(){
        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            String roadBlockName= String.format("第%d关", i);
            switch (i) {
                case 1:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_1;break;
                case 2:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_2;break;
                case 3:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_3;break;
                case 4:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_4;break;
                case 5:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_5;break;
                case 6:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_6;break;
                case 7:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_7;break;
                case 8:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_8;break;
                case 9:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_9;break;
                case 10:roadBlockName=RoadBlockName.ROAD_BLOCK_NAME_10;break;
            }
            System.out.printf("现在准备开始%s\n",roadBlockName);
            RoadBlock roadBlock = new RoadBlock(roadBlockName,difficulty,player);
            //开始闯关
            int wave = roadBlock.risk();
            if(wave!=0){
                System.out.printf("%s在进行%s第%d波倒下了\n",player.getName(),roadBlockName,wave);
                return;
            }else {
                System.out.printf("恭喜通过%s\n", roadBlockName );
                order.inputUseProp(player);
            }
        }
        endGame();
    }
    public void endGame()
    {
        System.out.printf("%s完成了新手村的所有任务,准备接受社会的毒打!\n",player.getName());
    }


}
