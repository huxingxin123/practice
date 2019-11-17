package com.sdz.gameprops.ordinary;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.PropEnum;

public class OrdinaryAggressivenessProp extends OrdinaryProp{
    private String name;
    private int type = PropEnum.AGGRESSIVENESS;
    private final int level = 1;
    private int value;

    @Override
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public int getLevel() {
        return level;
    }
    public OrdinaryAggressivenessProp() {
        name = "小攻击药剂";
        value = 10;
    }

    @Override
    public int beUsedBy(Protagonist player) {
        player.setAggressiveness(player.getAggressiveness()+value);
        return super.beUsedBy(player);
    }
}
