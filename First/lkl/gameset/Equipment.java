package gameset;

import figure.Player;

import java.util.ArrayList;

public class Equipment implements Equipments {
    //四个装备栏

    private ArrayList equipList;

    public Equipment(ArrayList<String> arrayList){
        this.equipList=arrayList;
    }

    @Override
    public void useEquipment(Player player,int index) {
        String what= (String) equipList.get(index);
        if (what.equals("红药水")) index=0;
        if (what.equals("长剑")) index=1;
        if (what.equals("盾牌")) index=2;
        if (what.equals("鞋子")) index=3;

        switch (index){
            case 0:
                System.out.println("加50滴血");
                player.setHp(player.getHp()+50);
                break;
            case 1:
                System.out.println("加20攻击力");
                player.setAttack(player.getAttack()+20);
                break;
            case 2:
                System.out.println("加10防御力");
                player.setDefense(player.getDefense()+10);
                break;
            case 3:
                System.out.println("加10敏捷度");
                player.setVelocity(player.getVelocity()+10);
                break;
        }
    }
}
