import equipment.Equipment;
import equipment.Package;
import observe.Observer;
import role.Boss;
import role.NormalEnemy;
import role.Role;

import java.util.Scanner;


public class Judge implements Observer {

    @Override
    public void stop() {
        System.out.println("游戏结束");
        System.exit(0);
    }

    @Override
    public void add(Equipment equipment) {

    }

    void start(Round round, Role role,Package pack){
        System.out.println(role.getName()+"进入了"+round.getName());

        NormalEnemy normalEnemy=round.getNormalEnemy();
        first(role,normalEnemy);
        second(role,normalEnemy);

        Boss boss=round.getBoss();
        third(role,boss);

        System.out.println("你是否要更换装备？输入true（false）来进行选择:");
        Scanner in=new Scanner(System.in);
        boolean ifchange=in.nextBoolean();
        change(role,pack,ifchange);
    }

    private void fightNormal(Role role,NormalEnemy normalEnemy){
        int roleAglity=role.getAgility();
        int normalAglity=normalEnemy.getAgility();
        if (roleAglity>=normalAglity){
            int proporty=(int)(roleAglity/normalAglity);
            for (int i=0;i<proporty;i++){
                role.attack(normalEnemy);
            }
        }else {
            int proporty=(int)(normalAglity/roleAglity);
            for (int i=0;i<proporty;i++){
                normalEnemy.attack(role);
            }
        }
    }

    private void fightBoss(Role role,Boss boss){
        int roleAglity=role.getAgility();
        int bossAglity=boss.getAgility();
        if (roleAglity>=bossAglity){
            int proporty=(int)(roleAglity/bossAglity);
            for (int i=0;i<proporty;i++){
                role.attack(boss);
            }
        }else {
            int proporty=(int)(bossAglity/roleAglity);
            for (int i=0;i<proporty;i++){
                boss.attack(role);
            }
        }
    }

    private void first(Role role,NormalEnemy normalEnemy){
        System.out.println(role.getName()+"遇到3个"+normalEnemy.getName());
        fightNormal(role,normalEnemy);
        fightNormal(role,normalEnemy);
        fightNormal(role,normalEnemy);
    }

    private void second(Role role,NormalEnemy normalEnemy){
        System.out.println(role.getName()+"遇到3个"+normalEnemy.getName());
        fightNormal(role,normalEnemy);
        fightNormal(role,normalEnemy);
        fightNormal(role,normalEnemy);
    }

    private void third(Role role,Boss boss){
        System.out.println(role.getName()+"遇到1个"+boss.getName());
        fightBoss(role,boss);
    }

    private void change(Role role, Package pack,boolean ifchange){
        role.change(pack,ifchange);
    }
}
