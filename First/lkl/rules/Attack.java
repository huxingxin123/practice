package rules;
import figure.Characters;
import figure.Player;
import gameset.Fortunate;
import gameset.Skill;

import java.util.ArrayList;
import java.util.Random;

public class Attack {
    private Player player;
    public Attack(Player player){
        this.player=player;
    }

    /*
    打斗方式和打斗情况
    */
    public void playerFightWith(Characters c1, Characters c2) {
        String name1=c1.getName();
        String name2=c2.getName();
        if (c1 instanceof Player) {
            System.out.println("---------" + name1 + "遇到了" + name2 + "-------------");
            c2.setHp(100);
            System.out.println(c2.getHp());
        }
        if (c2 instanceof Player) {
            System.out.println("---------" + name2 + "遇到了" + name1 + "-------------");
            c1.setHp(100);
            System.out.println(c1.getHp());
        }

        int n=1;
        while (c1.getHp()>0&&c2.getHp()>0) {
            System.out.println("******第"+n+"轮攻击******");
            n++;
            if (c2.getHp() > 0) {
                if (c1.getAttack()-c2.getDefense()>0) {

                    int hurt;
                    //一定几率暴击
                    int strongAtk=new Skill().useSkillAtk(c1);
                    if (strongAtk!=0){
                        hurt=strongAtk-c2.getDefense();
                    }
                    else {
                        hurt = c1.getAttack() - c2.getDefense();
                    }

                    int restHp=c2.getHp()-hurt;
                    System.out.println(name1+"攻击"+name2+" 造成伤害："+hurt+" "+name2+"剩余血量"+restHp);
                    c2.setHp(restHp);
                }
                else
                {
                    System.out.println(name1+"攻击"+name2+"：Miss");
                }
                if (c2.getHp()<=0){
                    System.out.println(name2+"死亡");
                    new Fortunate(player.arrayList).fortunateEquip(c1);
                    new Fortunate(player.arrayList).fortunateEquip(c2);
                    return;
                }
            }
            if (c1.getHp() > 0) {
                if (c2.getAttack()-c1.getDefense()>0) {
                    int hurt=c2.getAttack()-c1.getDefense();
                    int restHp=c1.getHp()-hurt;
                    System.out.println(name2+"攻击"+name1+"造成伤害："+hurt+" "+name1+"剩余血量"+restHp);
                    c1.setHp(restHp);
                }
                else
                {
                    System.out.println(name2+"攻击"+name1+"：Miss");
                }
                if (c1.getHp()<=0){
                    System.out.println(name1+"死亡");
                    new Fortunate(player.arrayList).fortunateEquip(c1);
                    new Fortunate(player.arrayList).fortunateEquip(c2);
                    return;
                }
            }
        }
    }
}
