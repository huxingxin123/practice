package com.sdz.utils;

import java.util.Random;

public class Probability {
    public static boolean  create(int percent) {
        if (percent > 100 || percent < 0) {
            System.out.println("输入正确的概率");
            return true;
        }
        Random random = new Random();
        int ranCount = random.nextInt(100);
        if (ranCount < percent) {
            return true;
        }
        return false;
    }
}
