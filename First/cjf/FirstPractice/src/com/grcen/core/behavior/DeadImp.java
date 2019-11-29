package com.grcen.core.behavior;

import com.grcen.global.Configurator;
import com.grcen.role.Hero;

/**
 * 死亡处理类
 * 只负责主角死亡后的处理
 */
public class DeadImp implements IDead {

    @Override
    public void dead(boolean isDead,int level) {
        if (isDead) {
            System.out.println(Hero.getInstance().getName() +
                    "体力不支 倒在了" + Configurator.LEVEL_MAP.get(level));
            System.exit(0);
        }
    }
}
