package com.sdz.gameprops.advanced;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.Prop;
import com.sdz.gameprops.PropEnum;

public abstract class AdvancedProp implements Prop {

    String name;
    int propType;
    int value;


    @Override
    public int beUsedBy(Protagonist player) {
        return 0;
    }
}
