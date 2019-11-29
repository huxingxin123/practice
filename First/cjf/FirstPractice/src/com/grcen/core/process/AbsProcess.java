package com.grcen.core.process;

/**
 * 抽象的Process，每一波、关卡和整个Game过程继承于此
 * 子类只能定义自己的算法族，执行顺序由父类决定
 */
public abstract class AbsProcess {

    /**
     * 每个过程的准备方法
     */
    protected abstract void ready();

    /**
     * 战斗方法
     */
    protected abstract void battle();

    /**
     * 过程结束的方法
     */
    protected abstract void end();

    /**
     * 外部只需关心执行，不需要关心其他方法
     */
    public final void execute() {
        this.ready();
        this.battle();
        this.end();
    }

}
