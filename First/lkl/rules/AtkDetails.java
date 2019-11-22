package rules;

import figure.Boss;
import figure.Player;
import figure.WildMonster;

public class AtkDetails {
    private Player player;
    private WildMonster monster;
    private Boss boss;
    public AtkDetails(Player player, Boss boss, WildMonster monster){
        this.player=player;
        this.boss=boss;
        this.monster=monster;
    }


    public void atkMonster(){
        //判断攻击顺序
        if (player.getVelocity()>=monster.getVelocity()) {
            System.out.println("******玩家先攻击******");

            if (player.getHp() <= 0) {
                return ;
            }
            //玩家开始战斗
            new Attack(player).playerFightWith(player, monster);

        } else {
            System.out.println("******Monster先攻击******");

            if (player.getHp() <= 0) {
                return;
            }
            new Attack(player).playerFightWith(monster, player);

        }
    }

    public void atkBoss(){
        if (player.getHp() <= 0) {
            return;
        }
        //判断攻击顺序
        if (player.getVelocity()>=boss.getVelocity()) {
            System.out.println("******玩家先攻击******");
            new Attack(player).playerFightWith(player, boss);
        } else {
            System.out.println("******Boss先攻击******");
            new Attack(player).playerFightWith(boss, player);
        }

    }
}
