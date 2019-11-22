package start;

import figure.Player;

public abstract class Fight {
    //初始化场景
    protected abstract void ready();

    //开始战斗
    protected abstract void start();

    //游戏结束
    protected abstract void end();


    public final void doThis(){
        this.ready();
        this.start();
        this.end();
    }
}
