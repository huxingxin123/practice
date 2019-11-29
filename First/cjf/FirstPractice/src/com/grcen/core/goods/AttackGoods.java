package com.grcen.core.goods;

import com.grcen.role.Role;
import com.sun.istack.internal.NotNull;

public class AttackGoods extends AbsGoods {
    @Override
    protected void setName() {
        mName = "六脉神剑";
    }

    @Override
    public boolean features(@NotNull Role role) {
        long newAttack = role.getAttack() + 888;
        if (newAttack < 9999) {
            System.out.println(role.getName() + "使用了" + mName + "攻击力暴增");
            return true;
        } else {
            useFail();
            return false;
        }
    }
}
