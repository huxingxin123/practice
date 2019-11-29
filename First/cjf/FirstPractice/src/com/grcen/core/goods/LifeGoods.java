package com.grcen.core.goods;

import com.grcen.role.Role;

/**
 * 加血的物品
 */
public class LifeGoods extends AbsGoods {

    @Override
    protected void setName() {
        mName = "大碗茶";
    }

    /**
     * 加1000血
     */
    @Override
    public boolean features(Role role) {
        long newLife = role.getLife() + 1000;
        if (newLife < 9999) {
            role.setLife(newLife);
            System.out.println(role.getName() + "使用了" + mName + " 回血1000！");
            return true;
        } else {
            useFail();
            return false;
        }
    }

    @Override
    public String getName() {
        return mName;
    }


}
