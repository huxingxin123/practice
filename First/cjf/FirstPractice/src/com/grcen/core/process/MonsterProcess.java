package com.grcen.core.process;


import com.grcen.core.behavior.AttackImp;
import com.grcen.core.behavior.DeadImp;
import com.grcen.role.Enemy;
import com.grcen.role.EnemyFactory;

/**
 * 每波小怪的全部过程
 */
public class MonsterProcess extends EnemyProcess {

    private Enemy[] threeMonster;
    private static final int MONSTER_FIRST = 0;
    private static final int HOST_FIRST = 1;

    public MonsterProcess(int curLevel) {
        super(curLevel);
    }


    /**
     * 遇到小怪这波之前的ready内容
     * 包括输入以及初始化每波小怪数组，attack接口实现类，死亡接口实现类
     */
    @Override
    protected void ready() {
        System.out.println(HERO.getName() + " 遇到了3个敌人");
        threeMonster = EnemyFactory.newThreeMonster(curLevel);
        iAttack = new AttackImp();
        iDead = new DeadImp();
    }


    /**
     * 判断谁是先手
     * 然后根据优先级开始战斗
     */
    @Override
    protected void battle() {
        if (HERO.getAgile() < threeMonster[0].getAgile()) {
            doBattle(MONSTER_FIRST);
        } else {
            doBattle(HOST_FIRST);
        }
    }

    /**
     * Battle策略：
     * 循环条件：主角生命值大于0 并且 小怪都还没死光
     *
     * flag : 用于防止双方的伤害都为0死循环不退出
     * 策略 回合超过20次没有分出胜负即退出程序
     * @param priority 谁优先
     */
    private void doBattle(int priority) {
        while (HERO.getLife() > 0 && !isAllDead()) {
            isTwentyRound(flag++);
            switch (priority) {
                case MONSTER_FIRST:
                    monsterAttack();
                    iAttack.attack(HERO, getAliveMonster());
                    break;
                case HOST_FIRST:
                    iAttack.attack(HERO, getAliveMonster());
                    monsterAttack();
                    break;
                default:
                    throw new IllegalArgumentException("The current priority has not been defined!");
            }
        }
    }

    private void isTwentyRound(int flag) {
        if (flag == 20) {
            System.out.println("双方不分彼此 少侠下次再来！");
            System.exit(0);
        }
    }

    /**
     * 小怪攻击
     * 由于每波有3个小怪所以在小怪攻击时需要当前还活着的小怪都攻击
     */
    private void monsterAttack() {
        for (Enemy item : threeMonster) {
            if (item.getLife() <= 0) continue;
            iAttack.attack(item, HERO);
        }
    }

    /**
     * @return 获取还或者的小怪
     */
    private Enemy getAliveMonster() {
        for (Enemy item : threeMonster) {
            if (item.getLife() > 0) {
                return item;
            }
        }
        return null;
    }

    /**
     * @return 返回当前小怪是不是死光
     */
    private boolean isAllDead() {
        int deadMonsterCount = 0;
        for (Enemy item : threeMonster) {
            if (item.getLife() <= 0) {
                deadMonsterCount++;
            }
        }
        return deadMonsterCount == 3;
    }

}
