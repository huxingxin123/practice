package com.sdz.gameprops.advanced;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.PropEnum;

public class AdvancedAggressivenessProp extends AdvancedProp{
    private String name;
    private int type = PropEnum.AGGRESSIVENESS;
    private final int level = 2;
    private int value;

    @Override
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

    public AdvancedAggressivenessProp() {
        this.name = "大攻击药剂";
        this.value = 50;

    }

    @Override
    public int beUsedBy(Protagonist player) {
        player.setAggressiveness(player.getAggressiveness()+value);
        return super.beUsedBy(player);
    }
}
