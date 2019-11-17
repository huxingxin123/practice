package com.sdz.gameprops.ordinary;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.PropEnum;

public class OrdinarySpeedProp extends OrdinaryProp{

    private String name;
    private int type  = PropEnum.SPEED;
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
    public OrdinarySpeedProp() {
        name = "小极速药剂";
        value = 1;
    }

    @Override
    public int beUsedBy(Protagonist player) {
        player.setSpeed(player.getSpeed()+value);
        return super.beUsedBy(player);
    }
}
