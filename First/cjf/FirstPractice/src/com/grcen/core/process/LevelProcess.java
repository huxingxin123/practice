package com.grcen.core.process;

import com.grcen.global.TerminalUtils;
import com.grcen.role.Hero;

/**
 * 每个Level（实体）
 * start: 小强 进入 水帘洞
 * 每波敌人（实体）
 * ..
 * 请选择（1=继续前进，2=显示主角血量状态）：
 * end:
 */
public class LevelProcess extends AbsProcess {

    private static final Hero HERO = Hero.getInstance();

    /**
     * 当前Level名
     */
    private String levelName;
    /**
     * 当前Level数
     */
    private int num;


    public LevelProcess(int num, String levelName) {
        this.num = num;
        this.levelName = levelName;
    }

    @Override
    protected void ready() {
        System.out.println(HERO.getName() + " 进入 " + levelName);
    }

    @Override
    protected void end() {
        if (HERO.getLife() > 0) {
            System.out.println(HERO.getName() + " 成功通过 " + levelName + "！");
            TerminalUtils.enterToContinue();
        }
    }

    /**
     * 两波小怪一波Boss
     */
    @Override
    protected void battle() {
        for (int i = 0; i < 2; i++) {
            AbsProcess monsterProcess = new MonsterProcess(num);
            monsterProcess.execute();
        }
        AbsProcess bossProcess = new BossProcess(num);
        bossProcess.execute();
    }
}
