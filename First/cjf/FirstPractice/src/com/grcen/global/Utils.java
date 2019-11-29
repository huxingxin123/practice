package com.grcen.global;

import java.util.Random;

public class Utils {

    private Utils() {

    }

    /**
     * 小概率的概率计算
     * 0.2概率
     * 产生1-100的随机，若在1-20内则触发
     */
    public static final boolean OrdinaryProbability() {
        int random = new Random().nextInt(101);
        return random < 20;
    }

    public static final boolean lowProbability() {
        int random = new Random().nextInt(101);
        return random < 5;
    }

    public static final boolean highProbability() {
        int random = new Random().nextInt(101);
        return random < 60;
    }
}
