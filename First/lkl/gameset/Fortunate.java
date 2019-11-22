package gameset;

import figure.Boss;
import figure.Characters;
import figure.Player;
import figure.WildMonster;

import java.util.ArrayList;
import java.util.Random;

      /*
      在击杀野怪或Boss后有一定几率掉装备
      */
public class Fortunate
{
    private Player player;
    private ArrayList<String> equipLists;
    private ArrayList<String> skillLists;


    public Fortunate(ArrayList<String> array){
        this.equipLists=array;
    }
    public Fortunate(Player player,ArrayList<String> arrayList){
        this.player=player;
        this.skillLists=arrayList;
    }
    public void fortunateEquip(Characters character) {
        if (character.getHp() <= 0&& ((character instanceof WildMonster)||(character instanceof Boss))) {
            Random random = new Random();
            int r = random.nextInt(5);
            switch (r) {
                case 1:
                    equipLists.add("红药水");
                    break;
                case 2:
                    equipLists.add("长剑");
                    break;
                case 3:
                    equipLists.add("盾牌");
                    break;
                case 4:
                    equipLists.add("鞋子");
                    break;
            }
        }
    }
}
