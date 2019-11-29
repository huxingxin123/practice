package com.grcen.core.skill;

import com.grcen.role.Role;

public class FatalSkill implements ISkill {

    private static final String SKILL_NAME = "河东狮子吼";

    /**
     * 河东狮子吼具体实现
     *
     * @return 两倍伤害
     */
    @Override
    public long useSkill(Role role, long curValue) {
        System.out.println(role.getName() + " 使用 " + SKILL_NAME + "，攻击力翻倍！");
        return 2 * curValue;
    }

}
