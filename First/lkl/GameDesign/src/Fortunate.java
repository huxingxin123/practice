import java.util.Random;
import java.util.Scanner;

class Fortunate
{
    private Equipment equipment;
    private Player player;

    //是否学会技能
    private boolean skill=false;

    public Fortunate(Equipment equipment){
        this.equipment=equipment;
    }
    public Fortunate(Player player){
        this.player=player;
    }
    private static int fortunate(){
        Random random=new Random();
        return random.nextInt(6);
    }

    //野怪随机掉落装备
    public void rotation(){
        int a=Fortunate.fortunate();
       // System.out.println("生成数字为"+a);
        switch (a){
            case 1:
                System.out.println("······捡到一瓶红药水······");
                equipment.setEquipment_1("一瓶可以加50滴血的红药水");
                equipment.getEquip()[0]="1.红药水";
                break;
            case 2:
                System.out.println("······捡到一把武器······");
                equipment.setEquipment_2("一把可以加20点攻击力的长剑");
                equipment.getEquip()[1]="2.长剑";
                break;
            case 3:
                System.out.println("······捡到一块盾牌······");
                equipment.setEquipment_3("一块可以加10点防御力的盾牌");
                equipment.getEquip()[2]="3.盾牌";
                break;
            case 4:
                System.out.println("······捡到一双鞋子······");
                equipment.setEquipment_4("一双可以加5点移动速度的鞋子");
                equipment.getEquip()[3]="4.鞋子";
                break;
        }
    }


    public Boolean skill(){
        System.out.println("是否学习技能：致命打击(一定几率可暴击)");
        System.out.println("1.学习 2.放弃");
        Scanner scanner=new Scanner(System.in);
        String a=scanner.next();
        int b=Integer.parseInt(a);
        if (b==1){
            System.out.println("恭喜你学会技能：致命打击");
            //攻击翻倍
            player.setSkill(player.getAttack()*2);
            skill=true;
            return true;
        }
        else {
            System.out.println("不屑于使用技能也能通关，你一定是大神吧！");
        }
        return false;
    }

    public int  atkDouble(){
        if (skill) {
            return player.getSkill();
        }
        return 0;
    }
}
