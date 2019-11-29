package com.grcen.core.process;

import com.grcen.core.behavior.IAttack;
import com.grcen.core.behavior.IDead;
import com.grcen.core.goods.GoodsManager;
import com.grcen.global.TerminalUtils;
import com.grcen.role.Hero;

/**
 * 因为每一波敌人（小怪/Boss）的结束都是令其选择前进还是显示血量
 * 所以此处提取公共夫类实现end()方法
 */
public abstract class EnemyProcess extends AbsProcess {

    protected static final Hero HERO = Hero.getInstance();
    /**
     * 回合统计
     * 用于防止双方的伤害都为0死循环不退出
     * 策略 回合超过30次没有分出胜负即退出程序
     */
    protected int flag = 0;

    /**
     * 当前关卡
     * 用于生成小怪/Boss
     */
    protected int curLevel;
    /**
     * 攻击接口
     * 每一波都涉及攻击过程
     */
    protected IAttack iAttack;

    /**
     * 死亡接口
     * 当每波结束后主角死亡会被调用
     */
    protected IDead iDead;

    public EnemyProcess(int curLevel) {
        this.curLevel = curLevel;
    }


    /**
     * 死亡处理
     * 物品掉落处理
     * 前进/生命值选择/进入背包
     */
    @Override
    protected void end() {
        if (HERO.getLife() <= 0 && iDead != null) {
            iDead.dead(true, curLevel);
            return;
        }
        System.out.println("敌人已经全部被消灭");
        GoodsManager.fallingGoods(HERO);
        chooseState();
    }

    /**
     * 在进入下一波之前对选择
     * 对选择单独抽出来好对异常处理
     */
    private void chooseState() {
        final int choose = TerminalUtils.getIntegerFromTerminal("请选择（1=继续前进，2=显示主角血量状态，3=进入背包）：");
        switch (choose) {
            case 1:
                return;
            case 2:
                System.out.println(HERO.getName() + " 现在的生命值是：" + HERO.getLife());
                TerminalUtils.enterToContinue();
                return;
            case 3:
                GoodsManager.currentGoods(HERO);
                TerminalUtils.enterToContinue();
                return;
            default:
                System.out.println("请输入正确值");
                chooseState();
        }
    }
}
