package gameset;

import figure.Boss;
import figure.WildMonster;

    /*
    根据玩家选择的游戏难度创建不同程度的Boss和Monster
    */
public class GameLevel {
    //游戏难度等级
    private static final int level_1=1;
    private static final int level_2=2;
    private static final int level_3=3;

    private int level;

    public GameLevel(int level){
        this.level=level;
    }

    /*
   创建Boss
    */
    public Boss buildBoss(){
        Boss boss=null;
        if (level==level_1){
            boss=new Boss("山脉亚龙(Boss)",100,30,20,10);
        }
        if (level==level_2){
            boss=new Boss("远古巨龙(Boss)",200,50,30,20);
        }
        if (level==level_3){
            boss=new Boss("纳深男爵(Boss)",300,70,50,50);
        }
        return boss;
    }

    /*
   创建小野怪
    */
    public WildMonster bulidWildMonster(){
        WildMonster Monster=null;
        if (level==level_1){
            Monster=new WildMonster("狼战士(Monster)",100,10,10,10);
        }
        if (level==level_2){
            Monster=new WildMonster("狼将军(Monster)",100,20,20,20);
        }
        if (level==level_3){
            Monster=new WildMonster("巨狼之首(Monster)",100,30,30,30);
        }
        return Monster;
    }
}
