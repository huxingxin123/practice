package com.grcen.core.goods;

import com.grcen.role.Role;

public class AgileGoods extends AbsGoods {
    @Override
    protected void setName() {
        mName = "千里马";
    }

    /**
     * 需要判断是否超过合理值
     *
     * @param role 使用者
     * @return 使用成功与否
     */
    @Override
    public boolean features(Role role) {
        int newAgile = role.getAgile() + 10;
        if (newAgile < 100) {
            role.setAgile(newAgile);
            System.out.println(role.getName() + "使用了 " + mName + " 敏捷值加10！");
            return true;
        }else {
            useFail();
            return false;
        }
    }


}
