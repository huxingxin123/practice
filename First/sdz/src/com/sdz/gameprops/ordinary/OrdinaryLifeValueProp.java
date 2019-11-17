package com.sdz.gameprops.ordinary;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.PropEnum;

public class OrdinaryLifeValueProp extends OrdinaryProp {
    private String name;
    private int type = PropEnum.LIFE_VALUE;
    private final int level = 1;
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

    public OrdinaryLifeValueProp() {
        name = "小生命药剂";
        value = 100;
    }

    @Override
    public int beUsedBy(Protagonist player) {
        player.setLifeValue(player.getLifeValue()+value);
        return super.beUsedBy(player);
    }
}
