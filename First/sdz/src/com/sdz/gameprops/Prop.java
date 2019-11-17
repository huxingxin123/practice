package com.sdz.gameprops;

import com.sdz.game.Protagonist;

public interface Prop {
    public String getName();
    public int getType();
    public int getLevel();
    public int beUsedBy(Protagonist player);
}
