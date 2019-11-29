package com.grcen.core.skill;

import com.grcen.role.Role;

public class DefenseSkill implements ISkill {

    private static final String SKILL_NAME = "金钟罩铁布衫";

    @Override
    public long useSkill(Role role, long curValue) {
        System.out.println(role.getName() + " 发动 " + SKILL_NAME + "防御力翻倍！");
        return curValue * 2;
    }
}
