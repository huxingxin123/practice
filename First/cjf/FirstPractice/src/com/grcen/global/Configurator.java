package com.grcen.global;

import com.grcen.role.Hero;

import java.util.HashMap;
import java.util.Map;

public class Configurator {
    /**
     * 默认的难度和关卡
     */
    public static int difficulty = 1;

    /**
     * 关卡名与关卡号Map
     */
    public static final Map<Integer, String> LEVEL_MAP = new HashMap<>();

    /**
     * 初始化游戏
     * 与控制台交互
     */
    public static void init() {
        TerminalUtils.reset();
        // 初始化主角信息
        initHost();
        // 初始化难度
        difficulty = TerminalUtils.getIntegerFromTerminal("设置游戏难度: ");
        // 初始化关卡与关卡名
        initLevel();
    }

    private static void initLevel() {
        LEVEL_MAP.put(1, "花果山");
        LEVEL_MAP.put(2, "流沙河");
        LEVEL_MAP.put(3, "高老庄");
        LEVEL_MAP.put(4, "火焰山");
        LEVEL_MAP.put(5, "鹰愁涧");
        LEVEL_MAP.put(6, "隐雾山");
        LEVEL_MAP.put(7, "比丘国");
        LEVEL_MAP.put(8, "镇海寺");
        LEVEL_MAP.put(9, "木仙庵");
        LEVEL_MAP.put(10, "天竺国");
    }


    private static void initHost() {
        String name = TerminalUtils.getStringFromTerminal("请输入主角名称：");
        long lifeValue = TerminalUtils.getLongFromTerminal("设置初始生命值：");
        long attackValue = TerminalUtils.getLongFromTerminal("设置攻击力：");
        long defeatValue = TerminalUtils.getLongFromTerminal("设置防御力：");
        int agileValue = TerminalUtils.getIntegerFromTerminal("设置敏捷值：");
        Hero.getInstance(name, lifeValue, attackValue, defeatValue, agileValue);
    }
}
