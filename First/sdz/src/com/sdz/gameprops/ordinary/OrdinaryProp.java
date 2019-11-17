package com.sdz.gameprops.ordinary;

import com.sdz.game.Protagonist;
import com.sdz.gameprops.Prop;
import com.sdz.gameprops.PropEnum;

public abstract class OrdinaryProp implements Prop {

    String name;
    int propType;
    int value;

    OrdinaryProp(){}


    @Override
    public int beUsedBy(Protagonist player) {
        return 0;
    }
}
