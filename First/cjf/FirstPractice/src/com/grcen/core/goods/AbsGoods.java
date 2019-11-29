package com.grcen.core.goods;

import com.grcen.role.Role;
import com.sun.istack.internal.NotNull;

/**
 * 物品都有的属性：功能
 */
public abstract class AbsGoods {

    protected String mName;

    public AbsGoods() {
        setName();
    }

    protected abstract void setName();

    public abstract boolean features(@NotNull Role role);


    public String getName() {
        return mName;
    }

    protected void useFail(){
        System.out.println("超过最大值限制 使用失败！");
    }
}
