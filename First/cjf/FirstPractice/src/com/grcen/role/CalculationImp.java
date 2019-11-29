package com.grcen.role;

import com.grcen.global.Configurator;

/**
 * MultipleImp
 * 负责计算当前关卡的小怪/Boss的属性增加
 */
public class CalculationImp implements ICalculation {


    @Override
    public int monsterMultiple(int level) {
        return Configurator.difficulty * level;
    }

    @Override
    public int bossMultiple(int level) {
        return Configurator.difficulty * level * 2;
    }
}
