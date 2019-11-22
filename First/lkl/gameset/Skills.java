package gameset;

import figure.Characters;

public interface Skills {

    //使用技能攻击
    int useSkillAtk(Characters player);

    //使用技能防御
    int useSkillDefence(Characters player);

}
