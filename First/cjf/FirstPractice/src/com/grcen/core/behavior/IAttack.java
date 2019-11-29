package com.grcen.core.behavior;

import com.grcen.role.Role;

/**
 * IAttack接口
 * 用于实现攻击，提取称接口方便日后实现不同的攻击规则
 */
public interface IAttack {
    void attack(Role me, Role opposite);
}
