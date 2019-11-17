package com.sdz.fight;

import com.sdz.game.Protagonist;
import com.sdz.monster.Boss;
import com.sdz.monster.Monster;
import com.sdz.monster.SmallMonster;

public interface OnFight {
    public int beAttacked(SmallMonster smallMonster);
    public int beAttacked(Boss boss);
    public int beAttacked(Protagonist protagonist);



//    public int attack(SmallMonster smallMonster);
//    public int attack(Boss boss);
//    public int attack(Protagonist player);
}
