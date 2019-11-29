package com.grcen.core.behavior;

import com.grcen.core.skill.DefenseSkill;
import com.grcen.core.skill.FatalSkill;
import com.grcen.core.skill.ISkill;
import com.grcen.core.skill.MoneySkill;
import com.grcen.global.Utils;
import com.grcen.role.Role;

/**
 * 攻击过程的实现类
 * 只负责攻击 不参与其他职责
 */
public class AttackImp implements IAttack {

    private ISkill skill;


    /**
     * 攻击过程
     * 对外只提供该唯一方法
     * （外部只需要知道攻击方和被攻击方即可不需要知道具体实现）
     * 首先参数判断，再判断双方是否已死亡，
     * 然后获取攻击方能攻击的次数，开始循环进行次数内的攻击
     * 当双方有人死亡时返回
     *
     * @param me       攻击方
     * @param opposite 被攻击方
     */
    @Override
    public void attack(Role me, Role opposite) {
        if (me == null || opposite == null) {
            return;
        }
        if (isDead(me, opposite)) return;
        int count = getAttackCount(me, opposite);
        for (int i = 0; i < count; i++) {
            if (!isDead(me, opposite))
                doAttack(me, opposite);
            else return;
        }
    }

    /**
     * 单次攻击
     * 赋予被攻击方 原来生命值 - 伤害的值
     */
    private void doAttack(Role me, Role opposite) {
        long hurt = getHurt(me, opposite);
        long newLife = opposite.getLife() - hurt;
        opposite.setLife(newLife);
        System.out.println(me.getName() + " 对 " + opposite.getName() + " 造成 " + hurt + " 点伤害！");
    }


    /**
     * 攻击造成的伤害
     * 伤害值 = 攻击力 - 防御力
     * 在获取攻击力和防御力时都可以使用技能（概率发生）
     *
     * @return 最终伤害值
     */
    private long getHurt(Role me, Role opposite) {
        long attackValue = useSkill(me, me.getAttack(), new FatalSkill());
        attackValue = useSkill(me, attackValue, new MoneySkill());
        long defenseValue = useSkill(opposite, opposite.getDefense(), new DefenseSkill());
        long hurt = attackValue - defenseValue;
        if (hurt < 0) return 0;
        return hurt;
    }


    /**
     * 使用技能（概率发生）
     * @param me           攻击方
     * @param defaultValue 原先伤害值
     */
    private long useSkill(Role me, long defaultValue, ISkill iSkill) {
        if (Utils.OrdinaryProbability()) {
            return iSkill.useSkill(me, defaultValue);
        }
        return defaultValue;
    }

    /**
     * 获取攻击方能攻击的次数
     * 根据敏捷值计算
     * example：(假设小强敏捷值为10，狼的敏捷值为2）-> 主角每打5次，狼才打1次。
     */
    private int getAttackCount(Role me, Role opposite) {
        if (me.getAgile() <= opposite.getAgile()) {
            return 1;
        } else {
            return (int) (me.getAgile() / opposite.getAgile());
        }
    }

    /**
     * 判断双方是否有死亡
     */
    private boolean isDead(Role me, Role opposite) {
        if (me.getLife() <= 0 || opposite.getLife() <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
