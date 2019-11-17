package com.sdz.gameprops.advanced;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.PropEnum;

public class AdvancedDefensivenessProp extends AdvancedProp {
    private String name;
    private int type = PropEnum.DEFENSIVE_POWER;
    private final int level = 2;
    private int value;

    public String getName() {
        return name;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public int getValue() {
        return value;
    }
    public AdvancedDefensivenessProp() {
        this.name = "大防御药剂";
        value = 10;
    }

    @Override
    public int beUsedBy(Protagonist player) {
        player.setDefensivePower(player.getDefensivePower()+value);
        return super.beUsedBy(player);
    }
}
