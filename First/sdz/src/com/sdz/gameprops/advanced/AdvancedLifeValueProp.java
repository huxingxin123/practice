package com.sdz.gameprops.advanced;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.PropEnum;

public class AdvancedLifeValueProp extends AdvancedProp{
    private String name;
    private int type = PropEnum.LIFE_VALUE;
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
    public AdvancedLifeValueProp() {
        name = "大生命药剂";
        value = 500;
    }

    @Override
    public int beUsedBy(Protagonist player) {
        player.setLifeValue(player.getLifeValue()+value);
        return super.beUsedBy(player);
    }
}
