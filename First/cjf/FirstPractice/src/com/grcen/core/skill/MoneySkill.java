package com.grcen.core.skill;

import com.grcen.global.Utils;
import com.grcen.role.Role;

public class MoneySkill implements ISkill {

    private static final String SKILL_NAME = "临时充钱";

    @Override
    public long useSkill(Role role, long curValue) {
        if (Utils.lowProbability()) {
            System.out.println(role.getName() + SKILL_NAME + " 伤害暴增！");
            return curValue * 10;
        }
        return curValue;
    }
}
