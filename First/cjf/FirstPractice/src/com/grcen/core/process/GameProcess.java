package com.grcen.core.process;

import com.grcen.global.Configurator;
import com.grcen.global.TerminalUtils;
import com.grcen.role.Hero;

public class GameProcess extends AbsProcess {
    @Override
    protected void ready() {
        TerminalUtils.reset();
        Configurator.init();
        System.out.println(Hero.getInstance().getName() + "进入游戏！");
        TerminalUtils.enterToContinue();
    }

    @Override
    protected void battle() {
        for (int i = 1; i <= Configurator.LEVEL_MAP.size(); i++) {
            AbsProcess levelProcess = new LevelProcess(i, Configurator.LEVEL_MAP.get(i));
            levelProcess.execute();
        }
    }

    @Override
    protected void end() {
        TerminalUtils.close();
        String name = Hero.getInstance().getName();
        System.out.println(name + "闯过所有关卡，将敌人一网打尽！");
        System.out.println(name + "当前状态：");
        System.out.println(Hero.getInstance().toString());
    }
}
