package start;

import figure.Boss;
import figure.Player;
import figure.WildMonster;
import gameset.Progress;

public class GlobalFight extends Fight {
    private Player player;
    private Boss boss;
    private WildMonster monster;


    public GlobalFight(Player player, Boss boss, WildMonster monster){
        this.player=player;
        this.boss=boss;
        this.monster=monster;
    }
    @Override
    public void ready() {
        System.out.println("玩家信息"+player.toString());
        System.out.println("Boss信息"+boss.toString());
        System.out.println("Monster信息"+monster.toString());
    }

    @Override
    public void start() {
        //new AtkDetails(player,boss,monster).details();
        for (int j=0;j<10;j++) {
            new Progress(player).progress(j);
            if (player.getHp() <= 0) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                LocalFight localFight = new LocalFight(player, boss, monster);
                localFight.doThis();
            }
        }
    }

    @Override
    public void end() {
        System.out.println("*****游戏结束******");
    }
}
