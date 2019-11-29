package com.grcen.core.behavior;

/**
 * 死亡接口
 * 当主角死亡后会被调用其中的方法
 * 提取称接口方便日后实现不同的死亡处理规则
 */
public interface IDead {
    void dead(boolean isDead,int level);
}
