package com.grcen.test;

import com.grcen.core.process.AbsProcess;
import com.grcen.core.process.GameProcess;


public class Run {
    public static void main(String[] args) {
//        Host.getInstance("孙悟空", 3000, 1500, 1000, 50); //10
//        AbsProcess levelProcess = new LevelProcess(1,"水帘洞", );
//        levelProcess.execute();
        AbsProcess process = new GameProcess();
        process.execute();
    }
}
