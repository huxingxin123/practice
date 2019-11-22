package gameset;

import figure.Characters;
import figure.Player;

import java.util.Random;

/*
  人物升级后可获得技能
   */
public class Skill implements Skills{

    @Override
    public int useSkillAtk(Characters player) {
        if (player instanceof Player){
            Random random = new Random();
            int s = random.nextInt(4);
            if (s==1) {
                System.out.println("********产生暴击伤害************");
                return player.getAttack()*2;
            }
    }
        return 0;
    }

    @Override
    public int useSkillDefence(Characters player) {
        return 0;
    }

}
