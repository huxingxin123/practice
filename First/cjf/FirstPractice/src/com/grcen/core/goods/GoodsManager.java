package com.grcen.core.goods;

import com.grcen.global.TerminalUtils;
import com.grcen.global.Utils;
import com.grcen.role.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 物品管理者
 * 背包
 */
public final class GoodsManager {

    private static final List<AbsGoods> GOODS_LIST = new ArrayList<>();

    private GoodsManager() {
    }

    /**
     * 查看当前背包有什么东西
     * @param host
     */
    public static final void currentGoods(Role host) {
        if (GOODS_LIST.size() == 0) {
            System.out.println("背包空空如也～");
            return;
        }
        System.out.println("当前您有这些物品：");
        for (int i = 0; i < GOODS_LIST.size(); i++) {
            System.out.println(i + " " + GOODS_LIST.get(i).getName());
        }
        final int choose = TerminalUtils.getIntegerFromTerminal("输入以上数字以使用物品:(99=退出)");
        if (choose == 99) {
            return;
        }
        useGoods(host, choose);
    }

    /**
     * 使用指定物品
     *
     * @param role  使用者
     * @param index 选择
     */
    public static final void useGoods(Role role, int index) {
        index = checkBoundary(index);
        boolean flag = GOODS_LIST.get(index).features(role);
        if (!flag) {
            System.out.println("超过最大限制 使用失败！");
        } else {
            GOODS_LIST.remove(index);
        }
    }

    /**
     * 防止下标越界
     */
    private static final int checkBoundary(int index) {
        if (index < 0 || index >= GOODS_LIST.size()) {
            index = checkBoundary(TerminalUtils.getIntegerFromTerminal("请输入正确值："));
        }
        return index;
    }

    /**
     * 生成物品
     * 随机生成任意一种
     * @return 物品
     */
    private static final AbsGoods produceGoods() {
        int random = new Random().nextInt(5);
        switch (random) {
            case 1:
                return new LifeGoods();
            case 2:
                return new AgileGoods();
            case 3:
                return new AttackGoods();
            case 4:
                return new DefenseGoods();
            default:
                return null;
        }
    }

    /**
     * 掉落物品处理
     * 先进行随机值判断是否掉落
     *
     * @param role
     */
    public static final void fallingGoods(Role role) {
        if (!Utils.highProbability()) {
            return;
        }
        AbsGoods fallingGood = produceGoods();
        if (fallingGood != null) {
            System.out.println("幸运值爆表 掉落" + fallingGood.getName());
            final int choose = TerminalUtils.getIntegerFromTerminal("是否立即使用？（1=是，2=放入背包,3=放入并查看背包所有物品)");
            switch (choose) {
                case 1:
                    fallingGood.features(role);
                    TerminalUtils.enterToContinue();
                    break;
                case 2:
                    GOODS_LIST.add(fallingGood);
                    break;
                case 3:
                    GOODS_LIST.add(fallingGood);
                    GoodsManager.currentGoods(role);
                    break;
                default:
                    System.out.println("错误的输入 与幸运失之交臂～");
                    TerminalUtils.enterToContinue();
            }
        }
    }

}
