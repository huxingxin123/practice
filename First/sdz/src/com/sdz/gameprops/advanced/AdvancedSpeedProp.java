package com.sdz.gameprops.advanced;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.PropEnum;

public class AdvancedSpeedProp extends AdvancedProp{
    private String name;
    private int type = PropEnum.SPEED;
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
    public AdvancedSpeedProp()  {
        name = "大极速药剂";
        value = 2;
    }

    @Override
    public int beUsedBy(Protagonist player) {
        player.setSpeed(player.getSpeed()+value);
        return super.beUsedBy(player);
    }
}
