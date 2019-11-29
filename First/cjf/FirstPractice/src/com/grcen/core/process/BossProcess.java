package com.grcen.core.process;

import com.grcen.core.behavior.AttackImp;
import com.grcen.core.behavior.DeadImp;
import com.grcen.role.*;

/**
 * 每波Boss的全部过程
 */
public class BossProcess extends EnemyProcess {

    private Enemy boss;
    private static final int BOSS_FIRST = 0;
    private static final int HOST_FIRST = 1;

    public BossProcess(int curLevel) {
        super(curLevel);
    }

    /**
     * 遇到Boss这波之前的ready内容
     * 包括输入以及初始化Boss对象，attack接口实现类，死亡接口实现类
     */
    @Override
    protected void ready() {
        System.out.println(HERO.getName() + " 遇到了1个Boss");
        boss = EnemyFactory.newBoss(curLevel);
        iAttack = new AttackImp();
        iDead = new DeadImp();
    }


    /**
     * 判断谁是先手
     * 然后根据优先级开始战斗
     */
    @Override
    protected void battle() {
        if (HERO.getAgile() < boss.getAgile()) {
           doBattle(BOSS_FIRST);
        } else {
            doBattle(HOST_FIRST);
        }
    }


    /**
     * Battle策略：
     * 循环条件：主角生命值大于0 并且 小怪都还没死光
     *
     * flag : 用于防止双方的伤害都为0死循环不退出
     *  策略 回合超过20次没有分出胜负即退出程序
     * @param priority 谁优先
     */
    private void doBattle(int priority) {
        while (HERO.getLife() > 0 && boss.getLife() > 0) {
            isTwentyRound(flag++);
            switch (priority) {
                case BOSS_FIRST:
                    iAttack.attack(boss, HERO);
                    iAttack.attack(HERO, boss);
                    break;
                case HOST_FIRST:
                    iAttack.attack(HERO, boss);
                    iAttack.attack(boss, HERO);
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

}
