package com.grcen.core.skill;

import com.grcen.role.Role;

import java.util.Random;

public interface ISkill {

    /**
     * 使用技能的方法
     * 对外提供技能使用的唯一方法
     *
     * @param curValue 当前值
     */
    long useSkill(Role role ,long curValue);
}
