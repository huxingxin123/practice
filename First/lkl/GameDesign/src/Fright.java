import java.util.Scanner;

class Fright {
    private Boss boss;
    private WildMonster monster;
    private Player player;

    private String name;
    private int pVelocity;
    private int pAtk;
    private int pDefence;

    private int mAtk;
    private int mDefence;

    private int bAtk;
    private int bDefence;

    private int mHp;
    private int pHp;
    private int bHp;

     //是否战斗标识
     private Boolean flag = false;

     //玩家是否死亡标识
     private Boolean death=false;

     //判断是否有装备
     private Boolean e=false;

     //彩蛋
     private Fortunate fortunate;

     //判断是否有技能
    private boolean skilled=false;


     Fright(Boss boss, WildMonster wildMonster, Player player) {
         this.boss = boss;
         this.monster = wildMonster;
         this.player = player;
     }

     //初始化玩家姓名，攻击力，防御力等
     private void init() {
         name = player.getName();
         pAtk = player.getAttack();
         pDefence = player.getDefense();
         mAtk = monster.getAttack();
         mDefence = monster.getDefense();
         mHp = monster.getHp();
         pHp = player.getHp();
         bHp=boss.getHp();
         bAtk=boss.getAttack();
         bDefence=boss.getDefense();
         pVelocity=boss.getVelocity();


         System.out.println("角色生成：" + player.toString());
         System.out.println("******关卡敌人属性******");
         System.out.println(boss.toString());
         System.out.println(monster.toString());

         //掉装备的幸运菜单
         fortunate=new Fortunate(player.getEquipment());
     }



     //打架
     public void fright() {
         init();
         for (int i = 0; i < 10; i++) {
             System.out.println("**********************************");
             System.out.println();
             System.out.println("***   欢迎来到第"+(i+1)+"关   ***"   );
             switch (i){
                 case 0:
                     System.out.println("       水帘洞   ");
                     break;
                 case 1:
                     System.out.println("       进入凌霄宝殿   ");
                     break;
                 case 2:
                     System.out.println("       进入南天门   ");
                     break;
                 case 3:
                     System.out.println("       进入深海龙宫   ");
                     skilled=new Fortunate(player).skill();
                     break;
                 case 4:
                     System.out.println("       进入火焰山   ");
                     break;
                 case 5:
                     System.out.println("       进入阴曹地府   ");
                     break;
                 case 6:
                     System.out.println("       进入妖魔大道   ");
                     break;
                 case 7:
                     System.out.println("       进入莲花圣池   ");
                     break;
                 case 8:
                     System.out.println("       进入花果山   ");
                     break;
                 case 9:
                     System.out.println("     进入重庆邮电大学   ");
                     break;
             }

             for (int j = 0; j <3;j++){
                 System.out.println();
                 if (j==0){
                     System.out.println("***   第一波敌人   ***");
                     util();
                     if (death){
                         break;
                     }
                 }
                 if (j==1){
                     System.out.println("***   第二波敌人   ***");
                     util();
                     if (death){
                         break;
                     }
                 }
                 if (j==2){
                     System.out.println("***   打Boss   ***");
                     util();
                     if (death){
                         break;
                     }
                 }
             }
             if (death){
                 break;
             }
         }
     }


    private static int count=0;
    // private Boolean breakUtil=true;
    private void util() {
        while (true) {
            System.out.println("战斗即将开始-_-!是否前进-> 1.前进 2.显示血量 3.退出游戏并保存 4.使用道具");
            Scanner scanner = new Scanner(System.in);
            String scan = scanner.next();
            int s = Integer.parseInt(scan);
            if (s == 1) {
                switch (count) {
                    case 0:
                        whoStart(this.player, this.monster);
                        count++;
                        break;
                    case 1:
                        whoStart(this.player, this.monster);
                        count++;
                        break;
                    case 2:
                        whoStart(this.player, this.boss);
                        count = 0;
                        break;
                }
                return;
            }
            if (s == 2) {
                System.out.println(name + "->剩余血量:" + pHp);
            }
            if (s == 3) {
                System.out.println("结束游戏");
            }
            if (s == 4) {
                System.out.println(name + "玩家，你可使用以下道具：");

                //返回来的有装备的装备栏索引
                int u[] = equip();
                System.out.println("辨真假" + e);
                if (e) {
                    Scanner scanner1 = new Scanner(System.in);
                    String ss = scanner1.next();
                    int use = Integer.parseInt(ss);

                    switch (use) {
                        case 1:
                            if (1 != u[0]) {
                                System.out.println("无装备使用，继续游戏");
                                break;
                            }
                            System.out.println("已喝下红药水");
                            pHp = pHp + 50;
                            break;
                        case 2:
                            if (2 != u[1]) {
                                System.out.println("无装备使用，继续游戏");
                                break;
                            }
                            System.out.println("已佩戴好长剑");
                            int b = pAtk + 20;
                            player.setAttack(b);
                            break;
                        case 3:
                            if (3 != u[2]) {
                                System.out.println("无装备使用，继续游戏");
                                break;
                            }
                            System.out.println("已佩戴好盾牌");
                            int c = pDefence + 10;
                            player.setDefense(c);
                            break;
                        case 4:
                            if (4 != u[3]) {
                                System.out.println("无装备使用，继续游戏");
                                break;
                            }
                            System.out.println("与装备好鞋子");
                            int d = pVelocity + 5;
                            player.setDefense(d);
                            break;
                        default:
                            System.out.println("没有找到你要的装备");
                            break;
                    }
                }
            }
        }
    }

    //查看装备
    private int[] equip() {
         int n=0;
         int[] index=new int[4];
        String[] equipment = player.getEquipment().getEquip();
        if (equipment == null) {
            System.out.println("什么都没有！");
        } else {
            for (int i=0;i<equipment.length;i++) {
                {
                    if (equipment[i]!=null) {
                        System.out.println(equipment[i]);
                        index[n]=i+1;
                        e = true;
                    }
                }
                n++;
            }
            if (!e) {
                System.out.println("好可怜，什么装备也没有，呜呜呜");
            }
        }
        return index;
    }

     /*
     攻击的顺序和方法
      */
     private void whoStart(Player player,Character character){

         if (player.getVelocity() >= character.getVelocity()) {
             System.out.println("***   玩家先攻击   ***");
             if (character instanceof WildMonster){
                 //攻击时用技能


                 frightWithMonster();
             }
             if (character instanceof Boss){
                 frightWithBoss();
             }
         } else {
             if (character instanceof WildMonster) {
                 System.out.println("***   " + character.getName() + "先攻击   ***");
                 frightWithPlayer();
             }
             if (character instanceof Boss){
                 System.out.println("***   " + character.getName() + "先攻击   ***");
                 bossFrightWithPlayer();
             }
         }
     }

     //技能
     public void haveSkill(){
        if (skilled){
            new Fortunate(player).atkDouble();
            System.out.println("你拥有一个技能是否使用 1.使用 2.不使用");
            Scanner scanner=new Scanner(System.in);
            String a=scanner.next();
            int b=Integer.parseInt(a);
            if (b==1){

            }

        }
     }


     /*
     玩家先开始的情况
      */
     private void frightWithMonster() {
         System.out.println("---------"+name+"遇到了"+monster.getName()+"-------------");
         int n=1;
         flag = true;
         while (flag) {
             System.out.println("******第"+n+"轮攻击******");

             n++;
             if (mHp > 0) {
                 if (pAtk-mDefence>0) {
                     int hurt=pAtk - mDefence;
                     mHp = mHp - hurt;
                     System.out.println("玩家攻击野怪："+"造成伤害："+hurt+" "+"野怪剩余血量"+mHp);

                 }
                 else
                 {
                     System.out.println("玩家攻击野怪：Miss");
                     System.out.println("野怪剩余血量"+mHp);
                 }
                 if (mHp<0){
                     System.out.println("野怪死亡");

                     System.out.println("会掉装备吗？");
                     //打了野怪的掉装备环节
                     fortunate.rotation();
                 }
                 boolean adjust = adjust(pHp,mHp);
                 if (!adjust) {
                     return;
                 }
             }

             if (pHp > 0) {

                 if (mAtk-pDefence>0) {
                     pHp = pHp - (mAtk - pDefence)*3;
                     System.out.println("野怪攻击玩家：玩家剩余血量"+pHp);
                 }
                 else
                 {
                     System.out.println("野怪攻击玩家：Miss");
                     System.out.println("玩家剩余血量"+pHp);
                 }
                 if (pHp<0){
                     System.out.println("玩家死亡");
                 }
                 boolean adjust = adjust(pHp,mHp);
                 if (!adjust) {
                     return ;
                 }
             }
         }
     }


     /*
    野怪先开始的情况
     */
     private void frightWithPlayer() {
         System.out.println("---------"+name+"遇到了"+monster.getName()+"-------------");
         int n=1;
         while (flag) {
             if (pHp > 0) {

                 if (mAtk-pDefence>0) {
                     pHp = pHp - (mAtk - pDefence)*3;
                     System.out.println("野怪攻击玩家：玩家剩余血量"+pHp);
                 }
                 else
                 {
                     System.out.println("野怪攻击玩家：Miss");
                     System.out.println("玩家剩余血量"+pHp);
                 }
                 if (pHp<0){
                     System.out.println("玩家死亡");
                 }
                 boolean adjust = adjust(pHp,mHp);
                 if (!adjust) {
                     return;
                 }
             }
             System.out.println("******第"+n+"轮攻击******");
             n++;
             if (mHp > 0) {
                 if (pAtk-mDefence>0) {
                     mHp = mHp - (pAtk - mDefence);
                     System.out.println("玩家攻击野怪："+"野怪剩余血量"+mHp);
                 }
                 else
                 {
                     System.out.println("玩家攻击野怪：Miss");
                     System.out.println("野怪剩余血量"+mHp);
                 }
                 if (mHp<0){
                     System.out.println("野怪死亡");

                     //打了野怪的掉装备环节
                     fortunate.rotation();
                 }
                 boolean adjust = adjust(pHp,mHp);
                 if (!adjust) {
                     return;
                 }
             }
         }
     }


     /*
     从血量判断输赢
      */
     private boolean adjust(int php,int hp) {
         if (php <= 0) {
             flag = false;
             death=true;
             System.out.println("游戏结束");
             return false;
         }

         if (hp <= 0) {
             flag = false;
             System.out.println("***   下一波敌人马上出现  ***");
             System.out.println(name + "->剩余血量:" + php);
             player.setHp(php);
             mHp=100;
             bHp=100;
             return false;
         }
         return true;
     }


     /*
     玩家先开始和Boss战斗
      */
     private void frightWithBoss(){
         System.out.println("---------"+name+"遇到了"+boss.getName()+"-------------");
         int n=1;
         flag = true;
         while (flag) {
             System.out.println("******第"+n+"轮攻击******");
             n++;
             if (mHp > 0) {
                 if (pAtk-bDefence>0) {
                     bHp = bHp - (pAtk - bDefence);
                     System.out.println("玩家攻击野怪："+"野怪剩余血量"+bHp);
                 }
                 else
                 {
                     System.out.println("玩家攻击野怪：Miss");
                     System.out.println("野怪剩余血量"+bHp);
                 }
                 if (bHp<0){
                     System.out.println("Boss死亡");

                     //打了野怪的掉装备环节
                     fortunate.rotation();
                 }
                 boolean adjust = adjust(pHp,bHp);
                 if (!adjust) {
                     return;
                 }
             }

             if (pHp > 0) {

                 if (bAtk-pDefence>0) {
                     pHp = pHp - (bAtk - pDefence)*3;
                     System.out.println("野怪攻击玩家：玩家剩余血量"+pHp);
                 }
                 else
                 {
                     System.out.println("野怪攻击玩家：Miss");
                     System.out.println("玩家剩余血量"+pHp);
                 }
                 if (pHp<0){
                     System.out.println("玩家死亡");
                 }
                 boolean adjust = adjust(pHp,bHp);
                 if (!adjust) {
                     return ;
                 }
             }
         }

     }

    /*
   玩家先开始和Boss战斗
    */
    private void bossFrightWithPlayer(){
        System.out.println("---------"+name+"遇到了"+boss.getName()+"-------------");
        int n=1;
        flag = true;
        while (flag) {
            System.out.println("******第"+n+"轮攻击******");
            n++;
            if (pHp > 0) {

                if (bAtk-pDefence>0) {
                    pHp = pHp - (bAtk - pDefence)*3;
                    System.out.println("野怪攻击玩家：玩家剩余血量"+pHp);
                }
                else
                {
                    System.out.println("野怪攻击玩家：Miss");
                    System.out.println("玩家剩余血量"+pHp);
                }
                if (pHp<0){
                    System.out.println("玩家死亡");
                }
                boolean adjust = adjust(pHp,bHp);
                if (!adjust) {
                    return ;
                }
            }
            if (mHp > 0) {
                if (pAtk-bDefence>0) {
                    bHp = bHp - (pAtk - bDefence);
                    System.out.println("玩家攻击野怪："+"野怪剩余血量"+bHp);
                }
                else
                {
                    System.out.println("玩家攻击野怪：Miss");
                    System.out.println("野怪剩余血量"+bHp);
                }
                if (bHp<0){
                    System.out.println("Boss死亡");

                    //打了野怪的掉装备环节
                    fortunate.rotation();

                }
                boolean adjust = adjust(pHp,bHp);
                if (!adjust) {
                    return;
                }
            }
        }

    }
}
