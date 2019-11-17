
import java.util.Scanner;

/**
 * 创建人物
 * 姓名，血量，攻击力，防御力，敏捷度，游戏难度
 * 人物初始化的同时游戏里的场景也应该初始化了
 */
 class Build {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int velocity;
    private int gameLevel;

    //退出游戏
    private boolean flag=true;

    public void start() {
        System.out.println("******欢迎进入游戏******");
        System.out.println("输入：1->启动游戏");
        System.out.println("输入：2->退出游戏");

        while (flag) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                String i = scanner.next();
                int j = Integer.parseInt(i);
                if (j == 1) {
                    System.out.println("***游戏开始***");
                    System.out.println("请输入主角名称:");
                    this.name = scanner.next();
                    System.out.println("请输入主角初始生命值");
                    String hp = scanner.next();
                    this.hp = Integer.parseInt(hp);
                    System.out.println("请输入主角攻击力");
                    String attack = scanner.next();
                    this.attack = Integer.parseInt(attack);
                    System.out.println("请输入主角防御力");
                    String defense = scanner.next();
                    this.defense = Integer.parseInt(defense);
                    System.out.println("请输入主角敏捷");
                    String velocity = scanner.next();
                    this.velocity = Integer.parseInt(velocity);
                    System.out.println("请选择游戏难度：1->简单 2->中等 3->困难");
                    String gameLevel = scanner.next();
                    this.gameLevel = Integer.parseInt(gameLevel);
                    buildPlayer();
                    flag=false;

                } else if (j == 2) {
                    System.out.println("游戏结束");
                    flag=false;
                } else {
                    System.out.println("输入的指令错误,请重新输入");
                }
            }
        }
    }

    /*
    战斗
     */
    private void frightStart(Fright fright){
        fright.fright();
    }

    /*
    创建玩家并开始战斗
     */
    private void buildPlayer()  {
        Player player = new Player(name, hp, attack, defense, velocity, gameLevel);
        System.out.println(player.toString());
        System.out.println("   ***人物创建成功***");
        Boss boss=buildBoss();
        System.out.println("该关卡难度下的Boss属性："+boss.toString());
        WildMonster monster=bulidWildMonster();
        System.out.println("该关卡难度下的野怪属性："+monster.toString());
        System.out.println("  ***游戏关卡加载成功,进入游戏***");


        //战斗
        Fright fright=new Fright(boss,monster,player);
        frightStart(fright);
    }


    /*
    创建Boss
     */
    private Boss buildBoss(){
        Boss boss=null;
        if (gameLevel==1){
             boss=new Boss(100,10,5,5);
             boss.setName("山脉亚龙(Boss)");
        }
        if (gameLevel==2){
             boss=new Boss(200,20,20,20);
             boss.setName("远古巨龙(Boss)");
        }
        if (gameLevel==3){
             boss=new Boss(300,50,50,50);
             boss.setName("纳深男爵(Boss)");
        }
        return boss;
    }


    /*
   创建小野怪
    */
    private WildMonster bulidWildMonster(){
        WildMonster Monster=null;
        if (gameLevel==1){
            Monster=new WildMonster(100,10,10,10);
            Monster.setName("狼战士(Monster)");
        }
        if (gameLevel==2){
            Monster=new WildMonster(100,20,20,20);
            Monster.setName("狼将军(Monster)");
        }
        if (gameLevel==3){
            Monster=new WildMonster(100,30,30,30);
            Monster.setName("巨狼之首(Monster)");
        }
        return Monster;
    }

}
