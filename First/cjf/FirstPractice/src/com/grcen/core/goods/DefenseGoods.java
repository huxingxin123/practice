package com.grcen.core.goods;

import com.grcen.role.Role;

public class DefenseGoods extends AbsGoods {
    @Override
    protected void setName() {
        mName = "护盾";
    }

    @Override
    public boolean features(Role role) {
        long newDefense = role.getDefense() + 456;
        if (newDefense < 9999) {
            System.out.println(role.getName() + "使用了" + mName + " 防御力加强");
            return true;
        }else {
            useFail();
            return false;
        }
    }
}
