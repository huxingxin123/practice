package com.sdz.gameprops.ordinary;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.Prop;
import com.sdz.gameprops.PropEnum;

public class OrdinaryDefensivenessProp extends OrdinaryProp{
    private String name;
    private  int type = PropEnum.DEFENSIVE_POWER;
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

    public OrdinaryDefensivenessProp() {
        name = "小防御药剂";
        value = 5;
    }

    @Override
    public int beUsedBy(Protagonist player) {
        player.setDefensivePower(player.getDefensivePower() + value);
        return super.beUsedBy(player);
    }
}
